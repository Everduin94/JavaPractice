package Strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Function Object example in Design Pattern Summaries notes.
 *
 * @author Erik Verduin
 */
public class Composition {
    private Compositor compositor;
    private List<Component> components;
    private int componentCount; // # of components
    int lineWidth; // Composition's line width
    int lineBreaks; // Position of line breaks in components
    int lineCount; // # of lines

    public Composition(Compositor compositor) {
        this.compositor = compositor;
        this.components = new ArrayList<>();
    }

    public void repair() {
        int natural = 0;
        int stretchability = 0;
        int shrinkability = 0;

        // Concrete class takes interface as param.
        // Concrete implementation of interface determines what algorithm gets used.
        // Very simple, very useful.
        /*  This is an alternative to subclassing, Inheritance supports variety of behaviors
          However, inheritance hard-wires the behavior into Context.
          You wind up with many related classes whose only difference is the algorithm or behavior.*/
        /* This pattern makes the algorithm easier to switch, understand, and extend.*/
        /* Strategies eliminate conditional statements.*/
        int breakCount = compositor.compose(natural, stretchability, shrinkability, componentCount, lineWidth, lineBreaks);

    //Layout components according to breaks... More brevity, yay.

    }
}
