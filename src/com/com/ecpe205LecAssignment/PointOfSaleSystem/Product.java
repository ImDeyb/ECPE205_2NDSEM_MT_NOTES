package com.ecpe205LecAssignment.PointOfSaleSystem;

public class Product {
    private String name, barcode, price;
    private int quantity;
    private double totalPrice;

    public Product(String name, String barcode, String price) {
        this.name = name;
        this.barcode = barcode;
        this.price = price;
        this.quantity = 1;
        this.totalPrice = Double.parseDouble(String.valueOf(price));
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
