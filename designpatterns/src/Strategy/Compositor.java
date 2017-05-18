package Strategy;

/**
 * @author Erik Verduin
 */
public interface Compositor {
    public int compose(int natural, int stretchability, int shrinkability, int componentCount, int lineWidth, int breaks);
}
