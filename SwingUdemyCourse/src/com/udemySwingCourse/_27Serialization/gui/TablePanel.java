package com.udemySwingCourse._27Serialization.gui;

import com.udemySwingCourse._27Serialization.model.Person;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by everduin on 12/12/2016.
 */
public class TablePanel extends JPanel{
    /*Table to replace the text area*/
    private JTable table;
    private PersonTableModel tableModel;

    public TablePanel(){
        tableModel = new PersonTableModel();
        table = new JTable(tableModel);
        /*MainFrame is working like a
        * local controller for the gui*/

        setLayout(new BorderLayout());

        //Give table scroll
        add(new JScrollPane(table),BorderLayout.CENTER);
    }

    public void setData(List<Person> db){
        tableModel.setData(db);
    }

    public void refresh(){
        tableModel.fireTableDataChanged();
    }
}
