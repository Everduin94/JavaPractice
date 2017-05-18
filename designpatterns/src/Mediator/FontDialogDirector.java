package Mediator;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Erik Verduin
 */
public class FontDialogDirector extends JDialog implements DialogDirector{

    private Button ok;
    private Button cancel;
    private ListBox fontList;
    private EntryField fontName;

    private String font;

    public FontDialogDirector(JFrame frame) {
        super(frame, "Font Selector");
        this.createWidgets();

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ok.changed();
            }
        });

        fontList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                fontList.changed();
                fontName.changed();
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancel.changed();
            }
        });

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void widgetChanged(Widget changedWidget) {
        if (changedWidget == fontList) {
            fontName.setText(fontList.getSelectedValue());
        } else if (changedWidget == ok) {
            saveFont();
            setVisible(false);
        } else if (changedWidget == cancel) {
            System.out.println("Cancel");
            setVisible(false);
        } else if (changedWidget == fontName) {
            font = fontName.getText();
        }
    }

    private void saveFont() {
        if (font != null && !font.isEmpty()) {
            System.out.println("Saving Font: " + font);
        } else {
            System.out.println("Font is not selected");
        }
    }

    @Override
    public void showDialog() {
        setVisible(true);
    }

    @Override
     public void createWidgets() {
        ok = new Button(this, "Okay");
        cancel = new Button(this, "Cancel");
        cancel.setSize(new Dimension(40, 40));
        fontList = new ListBox(this);
        fontList.setSize(new Dimension(80, 80));
        DefaultListModel<String> dlm = new DefaultListModel<>();

        dlm.addElement("dummy");
        dlm.addElement("dummy 1");
        dlm.addElement("dummy 2");
        dlm.addElement("dummy 3");

        fontList.setModel(dlm);
        fontName = new EntryField(this);

        this.setLayout(new BorderLayout());
        this.add(ok, BorderLayout.EAST);
        this.add(cancel, BorderLayout.WEST);
        this.add(fontName, BorderLayout.NORTH);
        this.add(fontList, BorderLayout.SOUTH);
    }
}
