package com.udemySwingCourse.Swing2;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

//This is a child class of JFrame
public class MainFrame extends JFrame { //Border Layouts and Text Areas


    private JTextArea textArea;
    private JButton btn;

    public MainFrame() {
        super("Hello World"); //Call to JFrame
        //Equivalent to JFrame frame = new JFrame("Hello");

        //This is the layout manager
        setLayout(new BorderLayout());
/*To find more layout manager styles
* Google Visual Layout Managers*/


        textArea = new JTextArea();
        btn = new JButton("Click Me!");

        add(textArea, BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);

        /*Initializing from App - Swing 1*/
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

