package com.udemySwingCourse._8Size;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private TextPanel textPanel;
    private Toolbar toolbar;
    private FormPanel formPanel;

    public MainFrame() {
        super("Hello World");
        setLayout(new BorderLayout());

        //Currently 2 components
        //All com should happen
        //Through MainFrame (Controller)
        //And not directly
        //(Component to component)
        toolbar = new Toolbar();
        textPanel = new TextPanel();
        formPanel = new FormPanel();

        //Once you understand this
        //You'll understand communication
        //It's a lot to grasp from one example
        toolbar.setStringListener(new StringListenerI() {
            @Override
            public void textEmitted(String text) {
                textPanel.appendText(text);
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

