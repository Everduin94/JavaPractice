package gui;

import model.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Created by everduin on 12/12/2016.
 */
public class TablePanel extends JPanel {
    private JTable table;
    private PersonTableModel tableModel;
    private JPopupMenu popup;
    private PersonTableListener personTableListener;

    public TablePanel() {
        tableModel = new PersonTableModel();
        table = new JTable(tableModel);
        popup = new JPopupMenu();

        JMenuItem removeItem = new JMenuItem("Delete row");
        popup.add(removeItem);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());

                /*1st Arg is Start, 2nd row is Finish |
                * This is how I set the selection
                * When I right click and then prompt
                * the popup (part 1 - 29)*/
                table.getSelectionModel().setSelectionInterval(row, row);

                if (e.getButton() == MouseEvent.BUTTON3) {
                    popup.show(table, e.getX(), e.getY());
                    /*e is mouse event, get X , get Y is location*/
                }
            }
        });

        /*This is how I point to a
        * specifc row that I want to
        * delete */
        removeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Could also get selection
                * model. (this is simpler)*/
                int row = table.getSelectedRow();

                /*My large explanation I put in MainFrame connects
                * back to this block of code right here (The call)*/
                if (personTableListener != null) {
                    personTableListener.rowDeleted(row); //Called (30)

                    /*This is the final piece to 30
                    * where we tell the view (through
                    * the controller I assume)
                    * that the model has changed*/
                    tableModel.fireTableRowsDeleted(row, row);
                }

            }
        });

        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(List<Person> db) {
        tableModel.setData(db);
    }

    public void refresh() {
        tableModel.fireTableDataChanged();
    }

    public void setPersonTableListener(PersonTableListener listener) {
        this.personTableListener = listener;
    }
}
