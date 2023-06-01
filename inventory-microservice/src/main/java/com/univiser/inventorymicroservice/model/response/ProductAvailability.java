package com.univiser.inventorymicroservice.model.response;

import java.util.Date;

public class ProductAvailability {

    private String productId;

    private String productName;

    private float productPrice;

    private Integer currentQuantity;

    public ProductAvailability() {
    }

    public ProductAvailability(String productId, String productName, float productPrice, Integer currentQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.currentQuantity = currentQuantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(Integer currentQuantity) {
        this.currentQuantity = currentQuantity;
    }
}
