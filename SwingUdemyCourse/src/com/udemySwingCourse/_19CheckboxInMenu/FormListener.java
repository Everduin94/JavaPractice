package com.udemySwingCourse._19CheckboxInMenu;

import java.util.EventListener;

/**
 * Created by Erik on 12/3/2016.
 */
//EventListener is basis for all listeners like ActionListener
public interface FormListener extends EventListener {
    public void formEventOccurred(FormEvent e);
}
