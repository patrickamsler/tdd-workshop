package org.zuhlke;

public class Product {
    private final String productId;
    private double price;
    private String description;

    public Product(String productId, double price, String description) {
        this.productId = productId;
        this.price = price;
        this.description = description;
    }

    public String getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
