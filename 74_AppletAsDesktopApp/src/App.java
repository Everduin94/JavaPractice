import javax.swing.*;

/**
 * Created by everduin on 1/24/2017.
 */
public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        }); //This is the recommended way of doing things, instead of just instantiating the JFrame
    }

    /*If you're using Java 8 you don't have to do this boilerplate anymore
    *
    * -This is my work machine, which is Java 7
    *
    * SwingUtilities.invokeLater(()->{ new MainFrame();})*
    *
    * ^^ lambda version for Java 8*/
}
