package com.univiser.inventorymicroservice.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_product_price")
public class ProductPrice {

    private Integer id;
    private String productId;
    private float productPrice;
    private Date createdAt;

    public ProductPrice() {
    }
    public ProductPrice(String productId, float productPrice, Date createdAt) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.createdAt = createdAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "product_id")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Column(name = "product_price")
    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    @Column(name = "created_at")
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
