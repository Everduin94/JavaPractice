package com.udemySwingCourse._24MVC_CreateDataModel.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by everduin on 12/12/2016.
 */
public class Database {
    private List<Person> people;

    public Database() {
        people = new ArrayList<>();
    }

    public void addPerson(Person person){
        people.add(person);
    }

    public List<Person> getPeople(){
        return people;
    }
}
/*Next step is to write controller code to
* communicate between the model and the view.
* Then we will represent People visually.*/
