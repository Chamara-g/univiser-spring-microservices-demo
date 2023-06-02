package com.univiser.shoppingmicroservice.controller;

import com.univiser.shoppingmicroservice.client.InventoryClient;
import com.univiser.shoppingmicroservice.model.ProductAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {

    @Autowired
    private InventoryClient inventoryClient;

    @GetMapping("/available-products")
    public List<ProductAvailability> getAvailableProductList(){
        return inventoryClient.getAvailableProducts();
    }
}
