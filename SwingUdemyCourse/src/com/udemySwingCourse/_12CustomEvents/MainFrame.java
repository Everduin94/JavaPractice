package com.udemySwingCourse._12CustomEvents;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private TextPanel textPanel;
    private Toolbar toolbar;
    private FormPanel formPanel;

    public MainFrame() {
        super("Hello World");
        setLayout(new BorderLayout());

        toolbar = new Toolbar();
        textPanel = new TextPanel();
        formPanel = new FormPanel();

        toolbar.setStringListener(new StringListenerI() {
            @Override
            public void textEmitted(String text) {
                textPanel.appendText(text);
            }
        });

        //Difference between toolbar is we'll have an event object
       //These are essentially our custom versions
        //of actionlistner and addactionlistener and actioneventperformed
        formPanel.setFormListener(new FormListener(){
            public void formEventOccurred(FormEvent e){
                String name = e.getName();
                String occupation = e.getOccupation();

                textPanel.appendText(name + ": " +
                occupation + "\n");
            }
        });

        add(formPanel, BorderLayout.WEST);
        add(toolbar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

