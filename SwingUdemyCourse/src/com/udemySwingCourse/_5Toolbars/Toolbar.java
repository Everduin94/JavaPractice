package com.udemySwingCourse._5Toolbars;

import javax.swing.*;
import java.awt.*;

/**
 * Created by everduin on 12/2/2016.
 */

//Custom Component
public class Toolbar extends JPanel{

    //ADD TWO BUTTONS
    private JButton helloButton;
    private JButton goodbyeButton;

    //CTOR
    public Toolbar () {
        helloButton = new JButton("Hello");
        goodbyeButton = new JButton("Goodbye");

        //FlowLayout, Don't want to use BorderLayout here
        //Good for adding from left to right
        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(helloButton);
        add(goodbyeButton);
    }
}
