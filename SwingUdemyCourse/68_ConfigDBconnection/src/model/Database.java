package model;

import java.io.*;
import java.sql.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by everduin on 12/12/2016.
 */
public class Database {

    /*changing to Linked List for optimized adding and removing in the middle
    * ArrayList is only optimized for adding and removing at the end*/
    private List<Person> people;
    private Connection con;
    private int port;
    private String user;
    private String password;

    public Database() {
        people = new LinkedList<Person>();
    }

    public void configure(int port, String user, String password) throws Exception {
        this.port = port;
        this.user = user;
        this.password = password;

        if(con != null) {
            disconnect();
            connect();
        }
    }


    /*At this point we still need to tell
    * the table view that the model has
    * changed so that the view updates
    * (30)*/
    public void removePerson(int index) {
        people.remove(index);
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public void connect() throws Exception {

        if (con != null) {
            return;
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new Exception("Driver not found");
        }
        String pass = "JVM!xCS312!";
        String url = "jdbc:mysql://localhost:3306/swingtest";
        /*Real world don't use root.*/
        con = DriverManager.getConnection(url, "root", pass);
        System.out.println("Connected :" + con);
    }

    public void disconnect() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /*Save list of People to DB*/
    public void save() throws SQLException {

        /*SQL - ? - Wildcard - Prevents SQL injection*/
        String checkSql = "Select count(*) as count from people where id=?";
        /*Prepared Statement*/
        PreparedStatement checkStatement = con.prepareStatement(checkSql);

        /*Weird punctuation / malicious sql injection attack is stopped by prepared statement with wild cards*/
        String insertSql = "insert into people (id, name, age, employment_status, tax_id, us_citizen, gender, occupation)" +
                " values (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertStatement = con.prepareStatement(insertSql);


        String updateSql = "update people set name=?, age=?, employment_status=?, tax_id=?, us_citizen=?, gender=?, occupation=?" +
                " where id=?";
        PreparedStatement updateStatement = con.prepareStatement(updateSql);

        /*Iterate through list of people*/
        for (Person person : people) {
            int id = person.getId();

            /*Builder or something would be really useful for Person*/
            String name = person.getName();
            String occupation = person.getOccupation();
            AgeCategory age = person.getAgeCat();
            EmploymentCategory emp = person.getEmpCat();
            String tax = person.getTaxId();
            boolean isUs = person.isUsCitizen();
            Gender gender = person.getGender();

            /*This says look for the first wildcard
            * and replace it with id, in this statement*/
            checkStatement.setInt(1, id);

            ResultSet checkResult = checkStatement.executeQuery();

            checkResult.next();

            int count = checkResult.getInt(1);

            /*Person is not found in the database*/
            if (count == 0) {
                System.out.println("Count for person with ID " + id + " is " + count);
                System.out.println("Inserting");

                /*Kept receiving SQLException
                * "No value specified for parameter 8"
                * This was because my first insert
                * statement I put col instead of col++
                * ++ is post-op so the change happens
                * after the method call happens so
                * the first row is still 1.*/
                int col = 1;
                insertStatement.setInt(col++, id);
                insertStatement.setString(col++, name);
                insertStatement.setString(col++, age.name());
                insertStatement.setString(col++, emp.name());
                insertStatement.setString(col++, tax);
                insertStatement.setBoolean(col++, isUs);
                insertStatement.setString(col++, gender.name());
                insertStatement.setString(col++, occupation);

                insertStatement.executeUpdate();

            } else {
                int col = 1;
                System.out.println("Updating person with ID" + id);

                updateStatement.setString(col++, name);
                updateStatement.setString(col++, age.name());
                updateStatement.setString(col++, emp.name());
                updateStatement.setString(col++, tax);
                updateStatement.setBoolean(col++, isUs);
                updateStatement.setString(col++, gender.name());
                updateStatement.setString(col++, occupation);
                updateStatement.setInt(col++, id);

                updateStatement.executeUpdate();
            }

        }

        updateStatement.close();
        insertStatement.close();
        checkStatement.close();
    }

    public void load() throws SQLException {
        people.clear();

        String sql = "select id, name, age, employment_status, tax_id, us_citizen, gender, occupation from people" +
                " order by name";

        /*Don't need place holders so can use normal 'statement'*/
        Statement selectStatement = con.createStatement();

        ResultSet results = selectStatement.executeQuery(sql);

        results.beforeFirst();
        while(results.next()){
            int id = results.getInt("id");
            String name = results.getString("name");
            String age = results.getString("age");
            String emp = results.getString("employment_status");
            String taxId = results.getString("tax_id");
            boolean isUs = results.getBoolean("us_citizen");
            String gender = results.getString("gender");
            String occupation = results.getString("occupation");

            Person person = new Person(id, name, occupation, AgeCategory.valueOf(age),EmploymentCategory.valueOf(emp),
                    taxId, isUs, Gender.valueOf(gender));

            people.add(person);
            /*41 will be about wiring all of this into the application*/
        }

        results.close();
        selectStatement.close();
    }

    /*Other objects could potentially modify
    * this list and we don't want that so we
    * change it to
    * Collections.unmodifiableList*/
    public List<Person> getPeople() {
        return Collections.unmodifiableList(people);
    }

    public void saveToFile(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        //Returns type list of persons - (An array is an object)
        Person[] persons = people.toArray(new Person[people.size()]);

        oos.writeObject(persons);

        oos.close();
    }

    public void loadFromFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        /*Erasure - the removal of writing, recorded, material
        * or data...
        *
        * Type Erasure happens with generics,
        * it's explanation is someone confusing
        * I wouldn't worry about it for now.
        * I assume the point is that
        * the Person array never loses it's type
        * at any point.*/
        try {
            Person[] persons = (Person[]) ois.readObject();

            people.clear();
            people.addAll(Arrays.asList(persons));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ois.close();
    }
}

