package Strategy.concreteImpl;

import Strategy.Compositor;

/**
 * @author Erik Verduin
 */
public class TeXCompositor implements Compositor {
    public TeXCompositor() {

    }

    @Override
    public int compose(int natural, int stretchability, int shrinkability, int componentCount, int lineWidth, int breaks) {
        //Do custom TeXCompositor stuff
        return 2;
    }
}

