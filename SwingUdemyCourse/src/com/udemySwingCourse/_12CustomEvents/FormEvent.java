package com.udemySwingCourse._12CustomEvents;

import java.util.EventObject;

/**
 * Created by Erik on 12/3/2016.
 */
public class FormEvent extends EventObject {

    //Now we have an event object that can
    //store information temporarily
    private String name;
    private String occupation;

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

    public FormEvent(Object source, String name, String occupation) {
        super(source); //Source is object that raises event
        //In this case source is FormPanel

        this.name = name;
        this.occupation = occupation;
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
}
