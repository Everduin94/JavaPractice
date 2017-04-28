import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by everduin on 1/24/2017.
 */
public class MainFrame extends JFrame implements ActionListener {

    private Timer timer;
    private Game game;
    private StartPanel startPanel;
    private CardLayout cards;

    MainFrame() {
        super("Animation");
        timer = new Timer(20, this);
        cards = new CardLayout();
        setSize(600, 500);
        setLayout(cards);

        game = new Game();
        startPanel = new StartPanel();
        add(startPanel, "start");
        add(game, "game");

        timer.start();

        startPanel.setListener(new StartPanelListener() {
            @Override
            public void startGame() {
                cards.show(MainFrame.this.getContentPane(), "game");
            }
        });
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.update();
    }
}
