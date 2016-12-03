package com.udemySwingCourse._13ListBoxes;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Erik on 12/3/2016.
 */
public class FormPanel extends JPanel {

    private JLabel nameLabel;
    private JLabel occupationLabel;
    private JTextField nameField;
    private JTextField occupationField;
    private JButton okBtn;
    private FormListener formListener;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        nameLabel = new JLabel("Name: ");
        occupationLabel = new JLabel("Occupation: ");
        nameField = new JTextField(10);
        occupationField = new JTextField(10);

        okBtn = new JButton("OK");
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();
                String occupation = occupationField.getText();

                //Button is the control
                //Passing info to the listening class
                FormEvent ev = new FormEvent(this, name, occupation);

                if (formListener != null){
                    formListener.formEventOccurred(ev);
                }

            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();


        /*              ROW 1               */

        gc.weightx = 1;
        gc.weighty = 0.1; //This increases gap between the two rows

        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5); //Creates space between label and textbox
        add(nameLabel, gc);

        gc.gridy = 0;
        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0); //Essentially null
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gc);

        /*              ROW 2               */

        gc.weightx = 1;
        gc.weighty = 0.1; //Redundant value to keep track

        gc.gridy = 1;
        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(occupationLabel, gc);

        gc.gridy = 1;
        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(occupationField, gc);

        /*              ROW 3               */

        gc.weightx = 1;
        gc.weighty = 2.0;

        gc.gridy = 2;
        gc.gridx = 1;
        //First_Line_Start moved button up right under textfields
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okBtn, gc);

    }

    public void setFormListener(FormListener listener) {
        this.formListener = listener;
    }
}
