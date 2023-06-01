package com.univiser.inventorymicroservice.repository;

import com.univiser.inventorymicroservice.model.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, Integer> {

    @Query(value = "select id, product_id, created_at, product_price from tbl_product_price, (select product_id as prod_id, MAX(created_at) as last_updated from tbl_product_price group by prod_id) latest_tb where tbl_product_price.product_id=latest_tb.prod_id and tbl_product_price.created_at=latest_tb.last_updated", nativeQuery = true)
    List<ProductPrice> getLatestProductPrice();
}
