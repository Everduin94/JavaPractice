package testDB;

import model.Database;

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

        db.disconnect();
    }
}
