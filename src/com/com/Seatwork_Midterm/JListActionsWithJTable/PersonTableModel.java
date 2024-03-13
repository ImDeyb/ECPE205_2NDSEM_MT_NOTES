package com.Seatwork_Midterm.JListActionsWithJTable;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PersonTableModel extends AbstractTableModel {
    ArrayList<Person> persons;
    public PersonTableModel(){
        persons = new ArrayList<>();
    }
    public void add(Person person){
        persons.add(person);
    }
    @Override
    public int getRowCount() {
        return persons.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0 :
                return "Firstname";
            case 1 :
                return "Lastname";
            case 2 :
                return "Title";
            case 3 :
                return "Nickname";
            case 4 :
                return "Display Format";
            case 5 :
                return "Emails";
            case 6 :
                return "Mail Format";
            default:
                return "test";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person p = persons.get(rowIndex);

        if(columnIndex == 0) {
            return p.getFirstname();
        }
        else if(columnIndex == 1) {
            return p.getLastname();
        }
        else if(columnIndex == 2){
            return p.getTitle();
        }
        else if(columnIndex == 3){
            return p.getNickname();
        }
        else if(columnIndex == 4){
            return p.getjCombos();
        }
        else if(columnIndex == 5){
            return p.getEmails();
        }
        else if(columnIndex == 6){
            return p.getRadioButtons();
        }
        else {
            return null;
        }
    }
}
