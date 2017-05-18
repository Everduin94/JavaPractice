package Strategy.concreteImpl;

import Strategy.Compositor;

/**
 * @author Erik Verduin
 */
public class SimpleCompositor implements Compositor {
    public SimpleCompositor() {

    }

    @Override
    public int compose(int natural, int stretchability, int shrinkability, int componentCount, int lineWidth, int breaks) {
        //Do custom Simple Compositor stuff
        return 1;
    }
}
