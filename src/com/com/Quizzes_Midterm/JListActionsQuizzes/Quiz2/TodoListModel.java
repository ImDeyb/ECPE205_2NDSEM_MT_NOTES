package com.Quizzes_Midterm.JListActionsQuizzes.Quiz2;

import javax.swing.*;
import java.util.ArrayList;

public class TodoListModel extends AbstractListModel {
    ArrayList<Task> tasks;
    public TodoListModel(){
        tasks = new ArrayList<>();
    }
    public void addElement(Task task){
        tasks.add(task);
    }
    public void removeElementAt(int task){
        tasks.remove(task);
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
