package Mediator;

import javax.swing.*;

/**
 * @author Erik Verduin
 */
class ListBox extends JList<String> implements Widget {

    private DialogDirector director;

    ListBox(DialogDirector director) {
        this.director = director;
    }

    @Override
    public void changed() {
        director.widgetChanged(this);
    }
}
