package com.ecpe205LecAssignment.PointOfSaleSystem;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ParentFrame {
    MasterFileManager masterFileManager;
    BarcodeLookUpFrame barcodeLookUpFrame;
    public ParentFrame(MasterFileManager masterFileManager, BarcodeLookUpFrame barcodeLookUpFrame){
        this.masterFileManager = masterFileManager;
        this.barcodeLookUpFrame = barcodeLookUpFrame;
        init();
    }
    private void init(){
        masterFileManager.nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    registerProduct();
                }
            }
        });
        masterFileManager.barcodeField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    registerProduct();
                }
            }
        });
        masterFileManager.priceField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    registerProduct();
                }
            }
        });



        barcodeLookUpFrame.quickSearchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                barcodeLookUpFrame.list.setCellRenderer(new CellRenderer());
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String searchBarcode = barcodeLookUpFrame.quickSearchField.getText().trim().toUpperCase();

                    boolean productFound = false;

                    for (Product product : masterFileManager.tableModel.products) {
                        if (product.getBarcode().equals(searchBarcode)) {
                            barcodeLookUpFrame.jListModel.add(product);
                            productFound = true;
                            barcodeLookUpFrame.list.updateUI();
                            break;
                        }
                    }

                    if (!productFound) {
                        JOptionPane.showMessageDialog(null, "Product not found!", "Not found!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    private void registerProduct(){
        String name = masterFileManager.nameField.getText().trim();
        String barcode = masterFileManager.barcodeField.getText().trim();
        String price = masterFileManager.priceField.getText().trim();

        Product p = new Product(name, barcode, price);


        if (!name.isEmpty() && !barcode.isEmpty()
                && !price.isEmpty()) {
            masterFileManager.tableModel.addProduct(p);
            masterFileManager.table.updateUI();
        } else{
            JOptionPane.showMessageDialog(null, "Warning: Empty fields detected. Please fill out all text fields before proceeding.", "Warning!", JOptionPane.ERROR_MESSAGE );
        }
    }

    public static void main(String[] args) {
        MasterFileManager masterFileManager = new MasterFileManager();
        BarcodeLookUpFrame barcodeLookUpFrame = new BarcodeLookUpFrame();

        barcodeLookUpFrame.setLocation(200, 100);
        masterFileManager.setLocation(700, 100);

        barcodeLookUpFrame.setVisible(true);
        masterFileManager.setVisible(true);

        new ParentFrame(masterFileManager, barcodeLookUpFrame);
    }
}
