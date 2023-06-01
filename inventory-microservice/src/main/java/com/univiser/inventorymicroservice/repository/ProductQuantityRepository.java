package com.univiser.inventorymicroservice.repository;

import com.univiser.inventorymicroservice.model.ProductQuantity;
import com.univiser.inventorymicroservice.model.response.ProductToQuantity;
import com.univiser.inventorymicroservice.model.response.ProductToQuantityMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductQuantityRepository extends JpaRepository<ProductQuantity, Integer> {

    //Get product quantity by product id
    ProductQuantity findByProductId(String productId);

    //Get Product Quantity
    @Query(value = "SELECT tbl_product.product_id, tbl_product.product_name, tbl_product_quantity.current_quantity FROM tbl_product LEFT JOIN tbl_product_quantity ON tbl_product.product_id = tbl_product_quantity.product_id WHERE tbl_product_quantity.current_quantity > 0", nativeQuery = true)
    List<Object> getLatestProductQuantity();
}
