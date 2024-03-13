package com.Quizzes_Midterm.JListActionsQuizzes.Quiz2;

import com.ecpe205LecAssignment.PointOfSaleSystem.Product;

import javax.swing.*;
import java.awt.*;

public class CellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(
            JList list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        Task label = (Task) value;
        String name = label.getName();
        String assignedTo  =  label.getAssign();
        String labelText = "<html>Name: " +  name +
                "<br/>" + "@ assigned to:  " + assignedTo + "</html>";
        setText(labelText);

        return this;
    }
}

