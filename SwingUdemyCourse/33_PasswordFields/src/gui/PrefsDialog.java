package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 31
 *
 * Created by everduin on 12/13/2016.
 */
public class PrefsDialog extends JDialog {

    private JButton okButton;
    private JButton cancleButton;
    private JSpinner portSpinner;

    /*Data Model behind Spinner*/
    private SpinnerNumberModel spinnerModel;

    private JTextField userField;
    private JPasswordField passField;

    public PrefsDialog(JFrame parent) {
        super(parent, "Preferences", false);

        okButton = new JButton("OK");
        cancleButton = new JButton("Cancle");

        /*3306 is a MySql port*/
        spinnerModel = new SpinnerNumberModel(3306, 0, 9999, 1);
        portSpinner = new JSpinner(spinnerModel);

        userField = new JTextField(10);
        passField = new JPasswordField(10);

        /*Change the filler*/
        passField.setEchoChar('*');

        /*Start GridBag*/
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        /*First Row*/
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;

        /*Set preferred size and not fill cell*/
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;

        add(new JLabel("User:"), gc);

        gc.gridx++;
        add(userField, gc);

        /*Next Row*/
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 1;
        /*Set preferred size and not fill cell*/
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;

        add(new JLabel("Password:"), gc);

        gc.gridx++;
        add(passField, gc);

        /*Next Row*/
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 1;
        /*Set preferred size and not fill cell*/
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;

        add(new JLabel("Port:"), gc);

        gc.gridx++;
        add(portSpinner, gc);

        /*Next Row*/
        gc.gridy++;
        gc.gridx = 0;

        add(okButton, gc);

        gc.gridx++;
        add(cancleButton, gc);
        /*End GridBag*/

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Get value from spinner control*/
                int value = (Integer) portSpinner.getValue();

                String user = userField.getText();

                /*Wrap the char array in a String to print
                * Otherwise, it's just hashcode*/
                char[] password = passField.getPassword();
                System.out.println(user + " : " + new String(password));

                setVisible(false);
            }
        });

        cancleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setSize(400, 300);
        setLocationRelativeTo(parent);
    }
}
