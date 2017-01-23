package gui;

import model.Message;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;

/**
 * This demonstrates using a arbitrary component as a list box renderer.
 */
public class MessageListRenderer implements ListCellRenderer {

    private JPanel panel; //Mentions panel may be overkill, Jlabel could be used directly
    private JLabel label;
    private Color selectedColor;
    private Color normalColor;

    /*Do as much setup as possible to take load off of getListCellRendererComponent*/
    public MessageListRenderer() {
        panel = new JPanel();
        label = new JLabel();
        selectedColor = new Color(210, 210, 255);
        normalColor = Color.white;

        label.setIcon(Utils.createIcon("/images/Information24.gif"));

        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(label);

    }

    @Override
    public Component getListCellRendererComponent(JList list,
                                                  Object value,
                                                  int index,
                                                  boolean isSelected,
                                                  boolean cellHasFocus) {

        Message message = (Message) value;
        label.setText(message.getTitle());
        /*On click (cellHasFocus == true means it's selected*/
        panel.setBackground(cellHasFocus ? selectedColor : normalColor);


        return panel;
    }
}
