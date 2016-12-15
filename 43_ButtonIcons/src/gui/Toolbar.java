package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by everduin on 12/2/2016.
 */


public class Toolbar extends JPanel implements ActionListener {

    private JButton saveButton;
    private JButton refreshButton;

    private ToolbarListener toolbarListener;

    public Toolbar() {
        //Added compoundBorder to separate
        setBorder(BorderFactory.createCompoundBorder());

        saveButton = new JButton("Save");
        refreshButton = new JButton("Refresh");

        saveButton.addActionListener(this);
        refreshButton.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(saveButton);
        add(refreshButton);
    }

    public void setStringListener(ToolbarListener listener) {

        this.toolbarListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if (clicked == saveButton) {
            if (toolbarListener != null) {
                toolbarListener.saveEventOccured();
            }
        } else if (clicked == refreshButton) {
            if (toolbarListener != null) {
                toolbarListener.refreshEventOccured();
            }
        }
    }
}
