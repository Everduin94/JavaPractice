package gui;


import model.Person;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by everduin on 12/12/2016.
 *
 * Model for a GUI component and not a data model, that's why it's in this package
 */
public class PersonTableModel extends AbstractTableModel {

    private List<Person> db;

    private String[] columnNames = {"ID", "Name", "Occupation", "Age Category", "Employment Category",
            "US Citizen", "Tax ID"};

    public PersonTableModel() {
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int row, int col) {

        /*any row in col1 should be editable*/
        switch (col) {
            case 1:
                return true;
            case 5:
                return true; //So we can edit checkboxes 70
            default:
                return false;
        }
    }

    @Override
    public void setValueAt(Object aValue, int row, int col) {

        if(db == null) {
            return;
        }

        Person person = db.get(row); //This is a reference pointing at a value in a literal List<People>
        switch (col) {
            case 1:
                //Get reference to person object at specified row
                person.setName((String) aValue);
                break;
            case 5:
                person.setUsCitizen((Boolean) aValue); //So the value sticks 70
            default:
                return;
        }
    }

    public void setData(List<Person> db) {
        this.db = db;
    }

    /*This is a wrapper for my data that
    * presents it in the right way for my table*/
    @Override
    public int getRowCount() {
        return db.size();
    }

    /*Spent 30 minutes trying to find why my table
    * wasn't refreshing with data
    * turns out I had this still set to 0 which
    * I missed him setting to 7 in the tutorial
    * and returning 0 for column count made the
    * program not work as intended*/
    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = db.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return person.getId();
            case 1:
                return person.getName();
            case 2:
                return person.getOccupation();
            case 3:
                return person.getAgeCat();
            case 4:
                return person.getEmpCat();
            case 5:
                return person.isUsCitizen();
            case 6:
                return person.getTaxId();
        }
        return null;
    }

    /*Cell Renderer types generally return String, we want US Citizen to return Boolean*/
    @Override
    public Class<?> getColumnClass(int col) {
        switch (col) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return Boolean.class; //70
            case 6:
                return String.class;
            default:
                return null;
        }
    }
}
