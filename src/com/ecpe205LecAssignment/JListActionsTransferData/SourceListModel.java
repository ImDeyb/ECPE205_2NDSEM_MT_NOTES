package com.ecpe205LecAssignment.JListActionsTransferData;

import javax.swing.*;
import java.util.ArrayList;

public class SourceListModel extends AbstractListModel {
    ArrayList<Task> tasks;
    public SourceListModel(){
        tasks = new ArrayList<>();
    }
    public void addElement(Task task){
        tasks.add(task);
    }
    public void removeElementAt(int task){
         tasks.remove(task);
    }
    public void setElementAt(Task task, int index){
        tasks.set(index, task);
        fireContentsChanged(this,index,index);
    }
    @Override
    public int getSize() {
        return tasks.size();
    }

    @Override
    public Object getElementAt(int index) {
        return tasks.get(index);
    }
}
