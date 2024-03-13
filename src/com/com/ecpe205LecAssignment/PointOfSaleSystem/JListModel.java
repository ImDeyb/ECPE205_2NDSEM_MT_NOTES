package com.ecpe205LecAssignment.PointOfSaleSystem;

import javax.swing.*;
import java.util.ArrayList;

public class JListModel extends AbstractListModel {
    ArrayList<Product> products;

    public JListModel(){
        products = new ArrayList<>();
    }
    public void add(Product product) {
        for (Product existingProduct : products) {
            if (existingProduct.getBarcode().equals(product.getBarcode())) {
                existingProduct.setQuantity((int) (existingProduct.getQuantity() + 1));

                existingProduct.setTotalPrice(existingProduct.getTotalPrice() + Double.parseDouble(String.valueOf(existingProduct.getPrice())));
                fireContentsChanged(this, 0, 1);
                return;
            }
        }

        products.add(product);
        fireContentsChanged(this, 0, 1);
    }
    @Override
    public int getSize() {
        return products.size();
    }

    @Override
    public Object getElementAt(int index) {
        return products.get(index);
    }
}
