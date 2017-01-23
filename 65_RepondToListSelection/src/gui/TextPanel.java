package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by everduin on 12/2/2016.
 */
public class TextPanel extends JPanel {

    private JTextArea textArea;
    public TextPanel() {
        textArea = new JTextArea();

        /*65 - So the text in the textarea isn't flush with the edge */
        textArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        }

    public void appendText(String text){
        textArea.append(text);
    }

    /*Wrapper*/
    public void setTextArea(String text) {
        //this.textArea = textArea;
        textArea.setText(text);
    }
}
