package com.univiser.shoppingmicroservice.client;

import com.univiser.shoppingmicroservice.model.ProductAvailability;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface InventoryClient {

    @GetExchange("api/product/available-products")
    public List<ProductAvailability> getAvailableProducts();

}
