package com.ecpe205LecAssignment.PointOfSaleSystem;

import javax.swing.*;
import java.awt.*;

public class BarcodeLookUpFrame extends JFrame {
    JTextField quickSearchField;
    JPanel amountPanel;
    JLabel totalAmountLabel;
    JListModel jListModel;
    JList<Product> list;

    public BarcodeLookUpFrame() {
        init();
    }

    private void init() {
        setTitle("Barcode Lookup Frame");

        jListModel = new JListModel();
        list = new JList<>(jListModel);

        add(quickSearchField = new JTextField(42), BorderLayout.NORTH);
        add(new JScrollPane(list), BorderLayout.CENTER);



        amountPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        amountPanel.add(totalAmountLabel = new JLabel("Total Amount: "));
        add(amountPanel, BorderLayout.PAGE_END);


        char pesoSign = '\u20B1';
        double amount = calculateTotalAmount(jListModel.products);
        totalAmountLabel.setText("Total Amount: " + pesoSign + String.format("%.2f", amount));

        setSize(483, 545);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public double calculateTotalAmount(java.util.List<Product> productList) {
        double totalAmount = 0;

        for (Product product : productList) {
            totalAmount += product.getTotalPrice();
        }

        return totalAmount;
    }
}