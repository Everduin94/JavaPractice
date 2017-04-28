package gui;

import model.EmploymentCategory;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * Created by everduin on 1/23/2017.
 */
public class EmployementCategoryRenderer implements TableCellRenderer {

    private JComboBox combo;

    public EmployementCategoryRenderer () {
        combo = new JComboBox(EmploymentCategory.values()); //Return values as an array
    }

    @Override
    public Component getTableCellRendererComponent(JTable table,
                                                   Object value,
                                                   boolean isSelected,
                                                   boolean hasFocus,
                                                   int row, int column) {

        combo.setSelectedItem(value);
        return combo; //The Combobox currently looks correct, but doesn't do anything
        //This is because this is just a renderer, next module we'll implement an editor
    }
}
