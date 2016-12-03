package com.udemySwingCourse.__9BorderSize;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Erik on 12/3/2016.
 */
public class FormPanel extends JPanel {
    public FormPanel(){
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        //Border is close and hardly visible
        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));

    }
}
