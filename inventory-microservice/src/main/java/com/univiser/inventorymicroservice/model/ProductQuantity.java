package com.univiser.inventorymicroservice.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_product_quantity")
public class ProductQuantity {

    private Integer id;
    private String productId;
    private Integer currentQuantity;
    private Date updatedAt;

    public ProductQuantity() {
    }

    public ProductQuantity(Integer id, String productId, Integer currentQuantity, Date updatedAt) {
        this.id = id;
        this.productId = productId;
        this.currentQuantity = currentQuantity;
        this.updatedAt = updatedAt;
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

    @Column(name = "current_quantity")
    public Integer getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(Integer currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    @Column(name = "updated_at")
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
