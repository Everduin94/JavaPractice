package testDB;

import model.*;

import java.sql.SQLException;

/**
 * Created by everduin on 12/14/2016.
 */
public class TestDatabase {

    /*Could use JUnit Test*/
    public static void main(String[] args){
        System.out.println("Running Database Test");

        Database db = new Database();
        try {
            db.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*Could write JUnit tests for a serious DB
        * to check all values*/


        /*Database Object db, has a linked list of People, in 37
        * were adding to that list of people. in 38 we
        * will insertthese values into the database so
        * count returns 1 instead of 0 in our save method .
        * */
        db.addPerson(new Person("NewGuy", "Builder", AgeCategory.adult, EmploymentCategory.employed,
                "111111", true, Gender.male));
        db.addPerson(new Person("SecondNewGuy", "Professional Badass", AgeCategory.adult, EmploymentCategory.employed,
                "111111", true, Gender.male));

        try {
            db.save();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.disconnect();
    }
}
