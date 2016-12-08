package com.udemySwingCourse._24MVC_CreateDataModel.model;

/**
 * Created by everduin on 12/8/2016.
 */
public class Person {
   /* Similar to the FormEvent - The Person class will be much more 'tight' in the way it stores data
   * in the clearest form possible.
   *
   * Fields copied from FormEvent at the start (name, occupation, ageCat, empCat, taxId, usCitizen, gender)
   */
    private int id; //Unique key of a Person

    private String name;
    private String occupation;
    private int ageCat;
    private String empCat;
    private String taxId;
    private boolean usCitizen;
    private String gender;

}
