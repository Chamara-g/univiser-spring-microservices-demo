package com.univiser.inventorymicroservice.service;

import com.univiser.inventorymicroservice.model.Product;
import com.univiser.inventorymicroservice.model.ProductPrice;
import com.univiser.inventorymicroservice.repository.ProductPriceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductPriceService {

    @Autowired
    private ProductPriceRepository productPriceRepository;

    public void addProductPrice(ProductPrice productPrice){
        productPriceRepository.save(productPrice);
    }

    public List<ProductPrice> latestProductPrices(){
        return productPriceRepository.getLatestProductPrice();
    }
}
