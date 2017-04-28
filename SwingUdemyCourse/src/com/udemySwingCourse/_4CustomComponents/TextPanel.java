package com.udemySwingCourse._4CustomComponents;

import javax.swing.*;
import java.awt.*;

/**
 * Created by everduin on 12/2/2016.
 */
public class TextPanel extends JPanel {
    //Can add other components into panels

    private JTextArea textArea;
    public TextPanel() {
        textArea = new JTextArea();

        //Set BorderLayout on TextPanel
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        /*Panel will take up whole area in this case
        * Wrap textArea in JScrollPane for Scroll Bars*/
    }

    //Give custom component ability to append text like before
    public void appendText(String text){
        textArea.append(text);
    }
}
