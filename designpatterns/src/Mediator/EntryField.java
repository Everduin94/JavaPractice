package Mediator;

import javax.swing.*;
import java.awt.event.MouseEvent;

/**
 * @author Erik Verduin
 */
public class EntryField extends JTextField implements Widget {

    private DialogDirector director;

    public EntryField(DialogDirector director) {
        this.director = director;
        this.setEditable(false);
    }

    @Override
    public void changed() {
        director.widgetChanged(this);
    }
}
