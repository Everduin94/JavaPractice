package com.udemySwingCourse._6Communication;

import com.udemySwingCourse._4CustomComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by everduin on 12/2/2016.
 */


public class Toolbar extends JPanel implements ActionListener{

    private JButton helloButton;
    private JButton goodbyeButton;

    private TextPanel textPanel;
//Currently, toolbar is tightly coupled with textpanel
    //We want the components to know as little
    //about each other was possible
    //Communication in textpanel and toolbar
    //should not be direct like this
    //Tutorial 7 will be about clean separation
    public Toolbar() {
        helloButton = new JButton("Hello");
        goodbyeButton = new JButton("Goodbye");

        helloButton.addActionListener(this);
        goodbyeButton.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(helloButton);
        add(goodbyeButton);
    }

    public void setTextPanel(TextPanel textPanel) {
        this.textPanel = textPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();

        if(clicked == helloButton) {
            textPanel.appendText("Hello\n");
        }
        else if(clicked == goodbyeButton) {
            textPanel.appendText("Goodbye\n");
        }

    }
}
