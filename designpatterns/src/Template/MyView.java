package Template;

/**
 * @author Erik Verduin
 */
public class MyView extends View{
    @Override
    protected void doDisplay() {
        // Render the view's contents
    }

    @Override
    protected void hookOperation() {
        System.out.println(this.toString() + " is calling super: ");
        super.hookOperation();
    }
}
