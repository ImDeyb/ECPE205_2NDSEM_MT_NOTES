package com.ecpe205LecAssignment.JListActions;

import javax.swing.*;
import java.util.ArrayList;

public class ListModel extends AbstractListModel {
    ArrayList<Student> students;

    public ListModel(){
        students = new ArrayList<>();
    }
    public void addStudent(Student student){
        students.add(student);
    }

    public void update(Student newValue, int index)
    {
        students.set(index, newValue);
        fireContentsChanged(this,index,index);
    }

    @Override
    public int getSize() {
        return students.size();
    }

    @Override
    public Object getElementAt(int index) {
        return students.get(index);
    }
}
