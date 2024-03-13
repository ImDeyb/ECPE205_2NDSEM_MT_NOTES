package com.ecpe205LecAssignment.PointOfSaleSystem;

import javax.swing.*;
import java.awt.*;

public class CellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        JPanel cellPanel = new JPanel(new GridLayout(2, 1));
        Product p = (Product) value;
        String name = p.getName();
        String barcode = p.getBarcode();
        double price = Double.parseDouble(p.getPrice());
        int quantity = (int) p.getQuantity();
        double totalPrice = p.getTotalPrice();


        char pesoSign = '\u20B1';

        JLabel leftCellLabel = new JLabel(name + " - " + barcode);
        JLabel rightCellLabel = new JLabel(pesoSign + String.valueOf(totalPrice));
        JLabel bottomCellLabel = new JLabel(quantity + " @ " + pesoSign + price);

        JPanel leftCellPanel = new JPanel(new BorderLayout());
        JPanel rightCellPanel = new JPanel(new BorderLayout());
        JPanel bottomCellPanel = new JPanel(new BorderLayout());

        leftCellPanel.add(leftCellLabel, BorderLayout.WEST);
        rightCellPanel.add(rightCellLabel, BorderLayout.EAST);
        bottomCellPanel.add(bottomCellLabel, BorderLayout.WEST);

        cellPanel.add(leftCellPanel);
        cellPanel.add(rightCellPanel);
        cellPanel.add(bottomCellPanel);


        return cellPanel;
    }
}
