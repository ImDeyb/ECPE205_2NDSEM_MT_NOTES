package com.ecpe205LecAssignment.PointOfSaleSystem;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TableModel extends AbstractTableModel {
    ArrayList<Product> products;

    public TableModel(){
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (!isDuplicate(product)) {
            products.add(product);
            fireTableRowsInserted(products.size() - 1, products.size() - 1);
        } else{
            JOptionPane.showMessageDialog(null, "Duplicate entry detected:");
        }
    }

    private boolean isDuplicate(Product newProduct) {
        for (Product existingProduct : products) {
            if (existingProduct.getName().equals(newProduct.getName())
                    && existingProduct.getBarcode().equals(newProduct.getBarcode())
                    && existingProduct.getPrice() == (newProduct.getPrice())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0 :
                return "NAME";
            case 1 :
                return "BARCODE";
            case 2 :
                return "PRICE";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product p = products.get(rowIndex);

        if(columnIndex == 0){
            return p.getName();
        } else if (columnIndex == 1){
            return p.getBarcode();
        } else if(columnIndex == 2){
            return p.getPrice();
        }
        else {
            return null;
        }
    }
}
