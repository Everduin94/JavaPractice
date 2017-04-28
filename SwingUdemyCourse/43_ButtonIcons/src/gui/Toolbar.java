package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;


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
        saveButton.setIcon(createIcon("/images/Save16.gif"));
        refreshButton = new JButton("Refresh");
        refreshButton.setIcon(createIcon("/images/Refresh16.gif"));

        saveButton.addActionListener(this);
        refreshButton.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(saveButton);
        add(refreshButton);
    }

    /*Load images - Need warnings, it's easy to have images not load*/
    private ImageIcon createIcon(String path){
        /*Use Class loader to get Java classes,
        * we're using same technology to load
        * images*/
        URL url = getClass().getResource(path);

        if(url == null){
            System.err.println("Unable to load image");
        }

        ImageIcon icon = new ImageIcon(url);
        return icon;
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
