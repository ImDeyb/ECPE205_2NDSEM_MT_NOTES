package com.Seatwork_Midterm.JListActionsWithJTable;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;

class CustomHeaderRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        setHorizontalAlignment(SwingConstants.CENTER);  // Adjust as needed

        JTableHeader header = table.getTableHeader();
        if (header != null) {
            setForeground(header.getForeground());
            setBackground(header.getBackground());
            setFont(header.getFont());
        }

        setText(value != null ? value.toString() : "");
        setBorder(UIManager.getBorder("TableHeader.cellBorder"));

        return this;
    }
}