package com.Quizzes.JListActionsQuiz2;

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
        String assigned = label.getAssign();
        String labelText = "<html>Task Name: " + name + "<br/> @ Assigned to: " + assigned;
        setText(labelText);

        return this;
    }
}

