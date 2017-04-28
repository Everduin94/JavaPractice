package model;

import java.io.Serializable;

/**
 * implements Java.Io Serializable for saving and loading
 *
 * Created by everduin on 12/8/2016.
 */
public class Person implements Serializable{
    /* Similar to the FormEvent - The Person class will be much more 'tight' in the way it stores data
    * in the clearest form possible.
    *
    * Fields copied from FormEvent at the start (name, occupation, ageCat, empCat, taxId, usCitizen, gender)
    */
    private int id;
    private static int count = 1;


    private String name;
    private String occupation;
    private AgeCategory ageCat; //Created enum
    private EmploymentCategory empCat; //Create enum
    private String taxId;
    private boolean usCitizen;
    private Gender gender; //Created enum

    //Instructor creates constructor, could use static factory or builder.
    public Person(String name,
                  String occupation,
                  AgeCategory ageCategory,
                  EmploymentCategory employmentCategory,
                  String taxId,
                  boolean usCitizen,
                  Gender gender) {
        this.name = name;
        this.occupation = occupation;
        this.ageCat = ageCategory;
        this.empCat = employmentCategory;
        this.taxId = taxId;
        this.usCitizen = usCitizen;
        this.gender = gender;

        this.id = count;
        count++;
    }

    public Person(int id,
                  String name,
                  String occupation,
                  AgeCategory ageCategory,
                  EmploymentCategory employmentCategory,
                  String taxId,
                  boolean usCitizen,
                  Gender gender) {
        this(name, occupation, ageCategory, employmentCategory, taxId, usCitizen, gender);

        /*Override what id does in the initial ctor*/
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public AgeCategory getAgeCat() {
        return ageCat;
    }

    public void setAgeCat(AgeCategory ageCat) {
        this.ageCat = ageCat;
    }

    public EmploymentCategory getEmpCat() {
        return empCat;
    }

    public void setEmpCat(EmploymentCategory empCat) {
        this.empCat = empCat;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public boolean isUsCitizen() {
        return usCitizen;
    }

    public void setUsCitizen(boolean usCitizen) {
        this.usCitizen = usCitizen;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String toString() {
        return id + ": " + name;
    }
}
