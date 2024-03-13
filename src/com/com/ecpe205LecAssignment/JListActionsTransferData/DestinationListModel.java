package com.ecpe205LecAssignment.JListActionsTransferData;

import javax.swing.*;
import java.util.ArrayList;

public class DestinationListModel extends AbstractListModel {
    ArrayList<Task> tasks;
    public DestinationListModel(){
        tasks = new ArrayList<>();
    }
    public void removeElementAt(int index){
        tasks.remove(index);
        fireIntervalRemoved(this, index, index);
    }
    public void addElement(Task task){
        tasks.add(task);
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
