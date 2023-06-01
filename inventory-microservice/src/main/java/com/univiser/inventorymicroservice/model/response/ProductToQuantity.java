package com.univiser.inventorymicroservice.model.response;

public class ProductToQuantity  {

    private String productId;

    private String productName;

    private Integer currentQuantity;

    public ProductToQuantity() {
    }

    public ProductToQuantity(String productId, String productName, Integer currentQuantity) {
        this.productId = productId;
        this.productName = productName;
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

    public Integer getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(Integer currentQuantity) {
        this.currentQuantity = currentQuantity;
    }
}
