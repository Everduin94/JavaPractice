package model;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

    public Database() {
        people = new LinkedList<Person>();
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

        if(con != null){
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

