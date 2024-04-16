package com.demoblaze.models;

public class Product {
    private String category;
    private String product;

    public Product(String category, String product) {
        this.category = category;
        this.product = product;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
