package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 31
 * <p>
 * Created by everduin on 12/13/2016.
 */
public class PrefsDialog extends JDialog {
/*Testing Commit Remote Changes*/
    private JButton okButton;
    private JButton cancelButton;
    private JSpinner portSpinner;

    /*Data Model behind Spinner*/
    private SpinnerNumberModel spinnerModel;

    private PrefsListener prefsListener;

    private JTextField userField;
    private JPasswordField passField;

    public PrefsDialog(JFrame parent) {
        super(parent, "Preferences", false);

        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        /*3306 is a MySql port*/
        spinnerModel = new SpinnerNumberModel(3306, 0, 9999, 1);
        portSpinner = new JSpinner(spinnerModel);

        userField = new JTextField(10);
        passField = new JPasswordField(10);

        /*Change the filler*/
        passField.setEchoChar('*');

        layoutControls();

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Get value from spinner control*/
                int port = (Integer) portSpinner.getValue();

                String user = userField.getText();

                /*Wrap the char array in a String to print
                * Otherwise, it's just hashcode*/
                char[] password = passField.getPassword();

                if (prefsListener != null) {
                    prefsListener.preferencesSet(user, new String(password), port);
                }

                setVisible(false);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setSize(320, 230);
        setLocationRelativeTo(parent);
    }

    public void setDefaults(String user, String password, int port) {
        userField.setText(user);
        passField.setText(password);
        portSpinner.setValue(port); //Autobox

    }

    public void setPrefsListener(PrefsListener prefsListener) {
        this.prefsListener = prefsListener;
    }

    /*Design and Arrangement (35)*/
    private void layoutControls() {

        JPanel controlsPanel = new JPanel();
        JPanel buttonsPanel = new JPanel();

        int space = 15;
        Border titleBorder = BorderFactory.createTitledBorder("DataBase Preferences");
        Border spaceBorder = BorderFactory.createEmptyBorder(space, space, space, space);

        controlsPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));

        /*Start GridBag*/
        /*Control Panel*/
        controlsPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        Insets rightPadding = new Insets(0,0,0,15);
        Insets noPadding = new Insets(0,0,0,0);

        /*First Row*/
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;

        /*Set preferred size and not fill cell*/
        gc.fill = GridBagConstraints.HORIZONTAL;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding; //Pad Right 15 pixels
        controlsPanel.add(new JLabel("User:"), gc);

        gc.gridx++;
        /*anchoring labels east and components west puts them
        * right by each other.*/
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = noPadding;
        controlsPanel.add(userField, gc);

        /*Next Row*/
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 1;
        /*Set preferred size and not fill cell*/
        gc.fill = GridBagConstraints.HORIZONTAL;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding;
        controlsPanel.add(new JLabel("Password:"), gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = noPadding;
        controlsPanel.add(passField, gc);

        /*Next Row*/
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 1;
        /*Set preferred size and not fill cell*/
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.EAST;
        gc.insets = rightPadding;
        controlsPanel.add(new JLabel("Port:"), gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = noPadding;
        controlsPanel.add(portSpinner, gc);
        /*End GridBag*/
        /*Buttons Panel*/
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.add(okButton);
        buttonsPanel.add(cancelButton);

        /*Clever way to make buttons the same size*/
        Dimension btnSize = cancelButton.getPreferredSize();
        okButton.setPreferredSize(btnSize);

        /*Add sub panels to dialog*/
        setLayout(new BorderLayout());
        add(controlsPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
    }
}
