package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by everduin on 12/27/2016.
 */
public class ProgressDialog extends JDialog {

    private JButton cancleButton;
    private JProgressBar progressBar;

    public ProgressDialog(Window parent)  {
        super(parent, "Messages Downloading...", ModalityType.APPLICATION_MODAL);

        cancleButton = new JButton("Cancle");
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);

        progressBar.setMaximum(10); //10 is arbitrary?

        progressBar.setString("Loading Messsages...");

        //progressBar.setIndeterminate(true); /*This just shows an indication and not actual progress*/

        setLayout(new FlowLayout());

        Dimension size = cancleButton.getPreferredSize();
        size.width = 400;
        progressBar.setPreferredSize(size);

        add(progressBar);
        add(cancleButton);

        pack(); /*Shrinkwraps your dialog around the controls you've added*/

        setLocationRelativeTo(parent);
    }

    @Override
    public void setVisible(final boolean visible) {


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                if(visible == false){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    setValue(0);
                }

                ProgressDialog.super.setVisible(visible);
            }
        });
    }

    public void setMaximum(int value){
        progressBar.setMaximum(value);
    }

    public void setValue(int value){

        int progress = 100 * value / progressBar.getMaximum();

        //%d - decimal  %% - escapes, (prints a literal percent)
        progressBar.setString(String.format("%d%%", progress));

        progressBar.setValue(value); /*Sets current Value*/
    }
}
