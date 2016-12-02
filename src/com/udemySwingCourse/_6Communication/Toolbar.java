package com.udemySwingCourse._6Communication;

import com.udemySwingCourse._4CustomComponents.*;

import javax.swing.*;
import java.awt.*;


/**
 * Created by everduin on 12/2/2016.
 */


public class Toolbar extends JPanel{

    private JButton helloButton;
    private JButton goodbyeButton;


    public Toolbar () {
        helloButton = new JButton("Hello");
        goodbyeButton = new JButton("Goodbye");

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(helloButton);
        add(goodbyeButton);
    }

    public void setTextPanel(TextPanel textPanel) {

    }
}
