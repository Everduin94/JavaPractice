package com.udemySwingCourse._8Size;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Erik on 12/3/2016.
 */
public class FormPanel extends JPanel {
    public FormPanel(){
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

    }
}
