import Mediator.DialogDirector;
import Mediator.Button;
import Mediator.FontDialogDirector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Erik Verduin
 */
public class guiApp {
    public static void main(String[] args) {

        final JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JButton button = new JButton("Pop-up");
        frame.add(button);
        frame.setMinimumSize(new Dimension(60,150));
        button.setSize(new Dimension(60,150));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogDirector director = new FontDialogDirector(frame);
                director.showDialog();
            }
        });
    }
}
