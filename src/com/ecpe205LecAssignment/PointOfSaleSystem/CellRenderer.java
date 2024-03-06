    package com.ecpe205LecAssignment.PointOfSaleSystem;

    import javax.swing.*;
    import java.awt.*;

    public class CellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(
                JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            Product label = (Product) value;
            String name = label.getName();
            String barcode = label.getBarcode();
            double price = Double.parseDouble(String.valueOf(label.getPrice()));
            int quantity = (int) label.getQuantity();
            double totalPrice = label.getTotalPrice();

            char pesoSign = '\u20B1';

            String formattedTotalPrice = String.format("%.2f", totalPrice);
            String formattedPrice = String.format("%.2f", price);

            String labelText = "<html><table width='100%'>" +
                    "<tr><td>" + name + " - " + barcode + "</td><td align='right'>" + pesoSign + formattedTotalPrice + "</td></tr>" +
                    "<tr><td colspan='10'>"  + quantity + " @ " + pesoSign + formattedPrice + "</td></tr>" +
                    "</table></html>";
            setText(labelText);

            return this;
        }}
