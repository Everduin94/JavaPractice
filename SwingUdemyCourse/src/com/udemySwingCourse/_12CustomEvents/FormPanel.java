package com.udemySwingCourse._12CustomEvents;

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

    //Goal is to send data from form to textarea
    //However, not directly.
    //Need to respond to clicks on ok button
    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        nameLabel = new JLabel("Name: ");
        occupationLabel = new JLabel("Occupation: ");
        nameField = new JTextField(10);
        occupationField = new JTextField(10);

        okBtn = new JButton("OK");

        //FormPanel doesn't contain any references
        //to mainframe, but mainframe has used the
        //set form listener in an anonymous class
        //and that anonymous class implements from
        // the listener interface can recieve
        //the form event occurred.

        //Still kind of confusing
        //"Don't rack your brain over it"
        //"Just type it out to get your head around it"
        //"Understanding this will help you to create"
        //"Good Swing applications"

        /*Author refers to GridBagLayout and
        * Swing Events as the most complex
        * After tutorial 12 everything is much
        * simpler*/
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This will be called on button click
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
