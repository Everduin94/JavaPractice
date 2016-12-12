package com.udemySwingCourse._25MVCtwo.controller;

import com.udemySwingCourse._25MVCtwo.gui.FormEvent;
import com.udemySwingCourse._25MVCtwo.model.*;

/**
 * Created by everduin on 12/12/2016.
 */
public class Controller {

    Database dataBase = new Database();

    //Could have method that accepts all the information in MainFrame
    //Accepting form event instead
    public void addPerson(FormEvent ev){
        String name = ev.getName();
        String occupation = ev.getOccupation();
        int ageCatId = ev.getAgeCat();
        String empCat = ev.getEmpCategory();
        boolean isUs = ev.isUsCitizen();
        String taxId = ev.getTaxId();
        String gender = ev.getGender();

        AgeCategory ageCategory;
        EmploymentCategory empCategory;
        Gender genderCategory;

        //Setup Age Category
        switch (ageCatId) {
            case 0:
                ageCategory = AgeCategory.child;
                break;
            case 1:
                ageCategory = AgeCategory.adult;
                break;
            case 2:
                ageCategory = AgeCategory.senior;
                break;
            default:
                ageCategory = AgeCategory.adult;
        }

        //Setup Employement Category
        if(empCat.equals("employed")){
            empCategory = EmploymentCategory.employed;
        } else if(empCat.equals("self-employed")) {
            empCategory = EmploymentCategory.selfEmployed;
        } else if(empCat.equals("unemployed")) {
            empCategory = EmploymentCategory.unemployed;
        } else {
            empCategory = EmploymentCategory.other;
            System.err.println(empCat);
        }

        //Setup Gender Category
        if(gender.equals("male")){
            genderCategory = Gender.male;
        } else {
            genderCategory = Gender.female;
        }

        Person person = new Person(name,
                occupation,
                ageCategory,
                empCategory,
                taxId,
                isUs,
                genderCategory);

        dataBase.addPerson(person);
    }
}
