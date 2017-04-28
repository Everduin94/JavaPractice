package com.udemySwingCourse._19CheckboxInMenu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by everduin on 12/2/2016.
 */
public class TextPanel extends JPanel {

    private JTextArea textArea;
    public TextPanel() {
        textArea = new JTextArea();

        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        }

    public void appendText(String text){
        textArea.append(text);
    }
}
