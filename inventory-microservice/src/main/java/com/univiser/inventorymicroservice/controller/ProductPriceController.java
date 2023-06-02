package com.univiser.inventorymicroservice.controller;

import com.univiser.inventorymicroservice.model.ProductPrice;
import com.univiser.inventorymicroservice.service.ProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/product-price")
public class ProductPriceController {
    @Autowired
    private ProductPriceService productPriceService;

    @PostMapping
    public ResponseEntity<ProductPrice> add(@RequestBody ProductPrice productPrice){
        try{
            productPriceService.addProductPrice(productPrice);

            return new ResponseEntity<ProductPrice>(productPrice, HttpStatus.OK);
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<ProductPrice>(HttpStatus.NOT_FOUND);
        }
    }

}
