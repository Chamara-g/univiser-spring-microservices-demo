package com.univiser.inventorymicroservice.controller;

import com.univiser.inventorymicroservice.model.ProductQuantity;
import com.univiser.inventorymicroservice.service.ProductQuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/product-quantity")
public class ProductQuantityController {

    @Autowired
    private ProductQuantityService productQuantityService;

    @PostMapping
    public ResponseEntity<ProductQuantity> add(@RequestBody ProductQuantity productQuantity){
        try{
            productQuantityService.addProductQuantity(productQuantity);

            return new ResponseEntity<ProductQuantity>(productQuantity, HttpStatus.OK);
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<ProductQuantity>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ProductQuantity productQuantity, @PathVariable String id){

        try{
            ProductQuantity existProductQuantity = productQuantityService.findByProductId(id);

            if(existProductQuantity != null){

                existProductQuantity.setCurrentQuantity(productQuantity.getCurrentQuantity());
                productQuantityService.updateProductQuantity(existProductQuantity);

                return new ResponseEntity<ProductQuantity>(existProductQuantity, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
