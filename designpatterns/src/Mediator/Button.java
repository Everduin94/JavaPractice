package Mediator;

import javax.swing.*;
import java.awt.event.MouseEvent;

/**
 * @author Erik Verduin
 */
public class Button extends JButton implements Widget{

    private DialogDirector director;

    public Button(DialogDirector director, String name) {
        super(name);
        this.director = director;
    }

    @Override
    public void changed() {
        director.widgetChanged(this);
    }

    public void setText(char text) {

    }

    public DialogDirector getDirector() {
        return director;
    }
}
