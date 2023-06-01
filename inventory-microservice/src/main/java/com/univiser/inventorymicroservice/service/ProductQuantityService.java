package com.univiser.inventorymicroservice.service;

import com.univiser.inventorymicroservice.model.ProductQuantity;
import com.univiser.inventorymicroservice.repository.ProductQuantityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductQuantityService {

    @Autowired
    private ProductQuantityRepository productQuantityRepository;

    public void addProductQuantity(ProductQuantity productQuantity){
        productQuantityRepository.save(productQuantity);
    }

    public ProductQuantity findByProductId(String productId){
        return productQuantityRepository.findByProductId(productId);
    }

    public void updateProductQuantity(ProductQuantity productQuantity){
        productQuantityRepository.save(productQuantity);
    }

    public List<ProductQuantity> listAllProductQuantity(){
        return productQuantityRepository.findAll();
    }

    public List<Object> listAllProductQuantities(){
        return productQuantityRepository.getLatestProductQuantity();
    }
}
