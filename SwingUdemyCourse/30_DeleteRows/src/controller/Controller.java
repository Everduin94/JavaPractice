package controller;

import gui.FormEvent;
import model.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by everduin on 12/12/2016.
 */
public class Controller {
    Database db = new Database();

    public List<Person> getPeople() {
        return db.getPeople();
    }

    public void addPerson(FormEvent ev) {
        String name = ev.getName();
        String occupation = ev.getOccupation();
        int ageCatId = ev.getAgeCat();
        String empCat = ev.getEmpCategory();
        boolean isUs = ev.isUsCitizen();
        String taxId = ev.getTaxId();
        String gender = ev.getGender();

        AgeCategory ageCategory = null;

        switch(ageCatId) {
            case 0:
                ageCategory = AgeCategory.child;
                break;
            case 1:
                ageCategory = AgeCategory.adult;
                break;
            case 2:
                ageCategory = AgeCategory.senior;
                break;
        }

        EmploymentCategory empCategory;

        if(empCat.equals("Employed")) {
            empCategory = EmploymentCategory.employed;
        }
        else if(empCat.equals("Self-Employed")) {
            empCategory = EmploymentCategory.selfEmployed;
        }
        else if(empCat.equals("UnEmployed")) {
            empCategory = EmploymentCategory.unemployed;
        }
        else {
            empCategory = EmploymentCategory.other;
            System.err.println(empCat);
        }

        Gender genderCat;

        if(gender.equals("male")) {
            genderCat = Gender.male;
        }
        else {
            genderCat = Gender.female;
        }

        Person person = new Person(name, occupation, ageCategory, empCategory,
                taxId, isUs, genderCat);

        db.addPerson(person);
    }

    /*wrapper methods for controller to communicate*/
    public void saveToFile(File file) throws IOException {
        db.saveToFile(file);
    }

    public void loadFromFile(File file) throws IOException {
        db.loadFromFile(file);
    }
    /*End wrapper methods for controller to comm load and save*/

    /*This will talk to the DB to remove
    * a person at a particular index*/
    public void removePerson(int index){
        db.removePerson(index);
    }
}