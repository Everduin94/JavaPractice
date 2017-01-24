import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by everduin on 1/24/2017.
 */
public class Main extends JApplet implements ActionListener {

    private Timer timer;
    private Game game;
    private StartPanel startPanel;
    /*CardLayouts*/
    private CardLayout cards;

    @Override
    public void destroy() {
        System.out.println("destroy");
    }

    @Override
    public void init() {



        /*Calls listener every 500 ms
        * We can say "This" because Main
        * implements an Action Listner and
        * it's methods.
        *
        * Or we could have used an anonymous class*/
        timer = new Timer(20, this);
        //timer.setInitialDelay(); // 500 also includes init delay


        cards = new CardLayout();
        setSize(600, 500); //Frame size
        setLayout(cards);

        game = new Game();
        startPanel = new StartPanel();
        add(startPanel, "start"); //Add custom JComponent to frame
        add(game, "game"); //Adding to the "content pane" same for JFrame and Applet
        /*using visual builder, and multiple views*/
        startPanel.setListener(new StartPanelListener() {
            @Override
            public void startGame() {
                //"game" needs to be a constant like many things in this app lol.
                cards.show(Main.this.getContentPane(), "game"); //Pass in reference to content pane of parent
                //"this" would refer to the anonymous class here which is startPanel.
            }
        });
    }

    @Override
    public void start() {
        timer.start(); //for applets
    }

    @Override
    public void stop() {

        timer.stop(); //for applets, page loses focus
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Timers can be a good alternative to multithreading
        game.update();
    }
}
