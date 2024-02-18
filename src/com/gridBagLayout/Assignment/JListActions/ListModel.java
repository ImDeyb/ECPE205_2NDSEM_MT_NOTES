package com.gridBagLayout.Assignment.JListActions;

import javax.swing.*;
import java.util.ArrayList;

public class ListModel extends AbstractListModel {
    private ArrayList<String> emailList;
    public ListModel() {
        emailList = new ArrayList<>();
    }
    public void addEmail(String emailAddress) {
        emailList.add(emailAddress);
    }
    public boolean contains(String sameValue) {
        return emailList.contains(sameValue);
    }
    public void setElementAt(String value,int index) {
        emailList.set(index, value);
        fireContentsChanged(this, index, index);
    }
    public Object removeElementAt(int index) {
        return emailList.remove(index);
    }
    public Object removeElementAt(int[] index) {
        return emailList.remove(index);
    }
    @Override
    public int getSize() {
        return emailList.size();
    }

    @Override
    public Object getElementAt(int index) {
        return emailList.get(index);
    }

}
