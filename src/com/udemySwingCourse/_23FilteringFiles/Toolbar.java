package com.udemySwingCourse._23FilteringFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by everduin on 12/2/2016.
 */

public class Toolbar extends JPanel implements ActionListener {

    private JButton helloButton;
    private JButton goodbyeButton;

    private StringListenerI textListener;

    public Toolbar() {
        //Added compoundBorder to separate
        setBorder(BorderFactory.createCompoundBorder());

        helloButton = new JButton("Hello");
        goodbyeButton = new JButton("Goodbye");

        helloButton.addActionListener(this);
        goodbyeButton.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(helloButton);
        add(goodbyeButton);
    }

    public void setStringListener(StringListenerI listener) {

        this.textListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if (clicked == helloButton) {
            if (textListener != null) {
                textListener.textEmitted("Hello\n");
            }
        } else if (clicked == goodbyeButton) {
            if (textListener != null) {
                textListener.textEmitted("Goodbye\n");
            }
        }
    }
}
