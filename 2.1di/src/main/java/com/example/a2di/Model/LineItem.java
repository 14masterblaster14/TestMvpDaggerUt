package com.example.a2di.Model;

/**
 * Created by ADMIN on 9/28/2017.
 */

public class LineItem extends Product {

    private int quantity;

    public LineItem(Product product, int quantity) {
        super(product);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSumPrice() {
        return getSalePrice() * quantity;
    }
}
