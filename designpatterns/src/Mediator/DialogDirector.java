package Mediator;

import javax.swing.*;

/**
 * @author Erik Verduin
 */
public interface DialogDirector {

     void showDialog();

    void createWidgets();

     void widgetChanged(Widget widget);
}
