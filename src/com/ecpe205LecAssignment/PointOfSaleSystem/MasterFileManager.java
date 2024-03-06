package com.ecpe205LecAssignment.PointOfSaleSystem;

import com.Seatwork_Midterm.JListActionsWithJTable.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MasterFileManager extends JFrame {
    JTextField nameField, barcodeField, priceField;
    JTable table;
    TableModel tableModel;
    public MasterFileManager(){
        init();;
    }
    private void init(){
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        setTitle("Master File Manager");


        tableModel = new TableModel();
        table = new JTable(tableModel);

        addComponent(new JLabel("NAME:"),0,0,1,1,0,0, GridBagConstraints.NONE, GridBagConstraints.LINE_START);
        addComponent(nameField = new JTextField(10), 1,0,1,1,1,1, GridBagConstraints.HORIZONTAL);
        addComponent(new JLabel("BARCODE:"),0,1,1,1,0,0, GridBagConstraints.NONE, GridBagConstraints.LINE_START);
        addComponent(barcodeField = new JTextField(10), 1,1,1,1,1,1, GridBagConstraints.HORIZONTAL);
        addComponent(new JLabel("PRICE:"),0,2,1,1,0,0, GridBagConstraints.NONE, GridBagConstraints.LINE_START);
        addComponent(priceField = new JTextField(10), 1,2,1,1,1,1, GridBagConstraints.HORIZONTAL);
        addComponent(new JScrollPane(table),0,3,2,1,1,1,GridBagConstraints.BOTH);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void addComponent(Component component, int x, int y, int width, int height,
                              int weightX, int weightY, int fill){

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.gridheight = height;
        c.weightx = weightX;
        c.weighty = weightY;
        c.fill = fill;
        c.insets = new Insets(3,5,3,5);
        add(component, c);
    }

    private void addComponent(Component component, int x, int y, int width, int height,
                              int weightX, int weightY, int fill, int anchor){

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.gridheight = height;
        c.weightx = weightX;
        c.weighty = weightY;
        c.fill = fill;
        c.anchor = anchor;
        c.insets = new Insets(3,5,3,5);
        add(component, c);
    }
}
