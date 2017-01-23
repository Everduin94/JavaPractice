package gui;

import model.EmploymentCategory;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

/**
 * Created by everduin on 1/23/2017.
 *
 * We extend AbstractCellEditor to use the default for a lot of the methods we would have
 * needed to implement from TableCellEditor CellEditor. and only implement getTableCellEDitorComponent
 * from TableCellEditor instead.
 */
public class EmployementCategoryEditor extends AbstractCellEditor implements TableCellEditor {

    private JComboBox combo; //Could get the renderer if my combobox has a lot of modifications

    public EmployementCategoryEditor () {
        combo = new JComboBox(EmploymentCategory.values()); //This is very simple compared to NISC, why?
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

        combo.setSelectedItem(value);
        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped(); //Important, to tell it to stop using editor and go back to the renderer
                // and update the cell.
            }
        });

        return combo;
    }

    @Override
    public Object getCellEditorValue() {
        return combo.getSelectedItem();
    }

    @Override
    public boolean isCellEditable(EventObject e) {
        return true; //Author not sure if needed
    }
}
