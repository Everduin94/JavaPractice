package Template;

/**
 * @author Erik Verduin
 */
abstract class View {
    void Display() {
        setFocus();
        doDisplay(); // Abstract (pure virtual C++)
        resetFocus();
        hookOperation(); // Override Hook Operation Example (Polymorphism)
    }

    /*Template methods use inheritance (MyView extends View) to vary part of an algorithm
    * (Display is the entire algorithm). Strategies use delegation to vary the entire algorithm*/
    protected abstract void doDisplay();

    private void resetFocus() {

    }

    private void setFocus() {

    }

    /**
     * Hook operations, provide default behavior that sub classes can extended if necessary.
     * A hook operation often does nothing by default. doDisplay() is technically a hook operation
     * as well then.
     */
    protected void hookOperation() {
        System.out.println("In " + this.toString());
    }
}
