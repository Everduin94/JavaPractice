package com.udemySwingCourse._16CheckBoxes;

import java.util.EventObject;

/**
 * Created by Erik on 12/3/2016.
 */
public class FormEvent extends EventObject {

    private String name;
    private String occupation;
    private int ageCat;
    private String empCat;
    private String taxId; //6
    private boolean usCitizen;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public FormEvent(Object source) {
        super(source); //Source is object that raises event
        //In this case source is FormPanel
    }

    public FormEvent(Object source, String name, String occupation, int ageCat, String empCat,
                     String taxId, boolean usCitizen) {
        super(source); //Source is object that raises event
        //In this case source is FormPanel

        this.name = name;
        this.occupation = occupation;
        this.ageCat = ageCat;
        this.empCat = empCat;
        this.taxId = taxId;
        this.usCitizen = usCitizen; //7
    }

    /*8*/
    public boolean isUsCitizen() {
        return usCitizen;
    }

    public void setUsCitizen(boolean usCitizen) {
        this.usCitizen = usCitizen;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }
    /*End 8*/

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

    public int getAgeCat() {
        return ageCat;
    }

    public void setAgeCat(int ageCat) {
        this.ageCat = ageCat;
    }

    public String getEmpCategory() {
        return empCat;
    }

}
