package com.udemySwingCourse._26CreateTables.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by everduin on 12/12/2016.
 */
public class Database {

    private ArrayList<Person> people;

    public Database() {
        people = new ArrayList<Person>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getPeople() {
        return people;
    }
}

