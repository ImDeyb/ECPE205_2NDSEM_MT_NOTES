package com.gridBagLayout.SeatWork;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TableModel extends AbstractTableModel {
    ArrayList<Person> persons;
    public TableModel()
    {
        persons= new ArrayList<>();
    }

    public void addPerson(Person person)
    {
        persons.add(person);
    }
    @Override
    public int getRowCount() {
        return persons.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        switch (column)
        {
            case 0 :
                return "Name";
            case 1 :
                return "Age";
            default :
                return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person p = persons.get(rowIndex);

        if(columnIndex == 0)
        {
            return p.getName();
        }
        else if(columnIndex == 1)
        {
            return p.getAge();
        }
        else
        {
            return null;
        }
    }
}
