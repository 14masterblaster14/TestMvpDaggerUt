package com.example.a2di.Model;

/**
 * Created by ADMIN on 9/28/2017.
 */

public class Product {

    private long id;
    private String productName;
    private String description;
    private double salePrice;

    public Product(long id, String productName, String description, double salePrice) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.salePrice = salePrice;
    }

    public Product(Product product) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }
}
