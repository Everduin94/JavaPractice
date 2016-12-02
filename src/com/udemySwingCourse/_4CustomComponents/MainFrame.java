package com.udemySwingCourse._4CustomComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private TextPanel textPanel;
    private JButton btn;

    public MainFrame() {
        super("Hello World");
        setLayout(new BorderLayout());

        textPanel = new TextPanel(); //Custom Control
        btn = new JButton("Click Me!");

        //ActionListener is an interface (4)
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Method is run whenever button is clicked (4)

                //Directly invoking a method on the textArea (4)
                textPanel.appendText("Hello\n");
            }
        });

        add(textPanel, BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /*Mainframe creates components and those components in themselves
    * can become quite complex... leading towards a MVC style approach*/
}

