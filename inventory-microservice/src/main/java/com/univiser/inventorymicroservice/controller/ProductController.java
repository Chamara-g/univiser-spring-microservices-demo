package com.univiser.inventorymicroservice.controller;

import com.univiser.inventorymicroservice.model.Product;
import com.univiser.inventorymicroservice.model.ProductPrice;
import com.univiser.inventorymicroservice.model.ProductQuantity;
import com.univiser.inventorymicroservice.model.response.ProductAvailability;
import com.univiser.inventorymicroservice.model.response.ProductToQuantityMap;
import com.univiser.inventorymicroservice.service.ProductPriceService;
import com.univiser.inventorymicroservice.service.ProductQuantityService;
import com.univiser.inventorymicroservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductQuantityService productQuantityService;

    @Autowired
    private ProductPriceService productPriceService;

    @GetMapping
    public List<Product> findAll(){
        return productService.listAllProducts();
    }

    @PostMapping
    public ResponseEntity<Product> add(@RequestBody Product product){
        try{
            productService.addProduct(product);

            return new ResponseEntity<Product>(product, HttpStatus.OK);
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/available-products")
    public List<ProductAvailability> getAvailableProducts(){

        try{
            //All Products
            List<Product> products = productService.listAllProducts();
            List<ProductQuantity> productQuantities = productQuantityService.listAllProductQuantity();
            List<ProductPrice> productPrices = productPriceService.latestProductPrices();

            // Data into Map
            Map<String, ProductQuantity> productQuantityMap = productQuantities.stream().collect(Collectors.toMap(ProductQuantity::getProductId, Function.identity()));
            Map<String, ProductPrice> productPriceMap = productPrices.stream().collect(Collectors.toMap(ProductPrice::getProductId, Function.identity()));

            Product tempProduct;
            ProductQuantity tempProductQuantity;
            ProductPrice tempProductPrice;

            List<ProductAvailability> productAvailability = new ArrayList<>();
            for (int i = 0; i < products.size(); i++) {
                tempProduct = products.get(i);

                tempProductQuantity = productQuantityMap.get(tempProduct.getProductId());
                tempProductPrice = productPriceMap.get(tempProduct.getProductId());

                // Check if product exist
                if(tempProductQuantity != null && tempProductPrice != null && tempProductQuantity.getCurrentQuantity() > 0){
                    productAvailability.add(new ProductAvailability(
                            tempProduct.getProductId(),
                            tempProduct.getProductName(),
                            tempProductPrice.getProductPrice(),
                            tempProductQuantity.getCurrentQuantity()));
                }
            }

            return productAvailability;
        }
        catch(NoSuchElementException e){
            return null;
        }
    }
}
