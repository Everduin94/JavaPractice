package com.udemySwingCourse._3ButtonClicks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This is a child class of JFrame
public class MainFrame extends JFrame { //Border Layouts and Text Areas


    private JTextArea textArea;
    private JButton btn;

    public MainFrame() {
        super("Hello World"); //Call to JFrame
        //Equivalent to JFrame frame = new JFrame("Hello");

        /*To find more layout manager styles
        * Google Visual Layout Managers*/

        //This is the layout manager
        setLayout(new BorderLayout());


        textArea = new JTextArea();
        btn = new JButton("Click Me!");

        //ActionListener is an interface
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Method is run whenever button is clicked

                //Directly invoking a method on the textArea
                textArea.append("Hello\n");
            }
        });

        add(textArea, BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);

        /*Initializing from App - Swing 1*/
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

