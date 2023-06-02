package com.univiser.inventorymicroservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.univiser.inventorymicroservice.model.Product;
import com.univiser.inventorymicroservice.model.response.ProductAvailability;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerIntTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void findAll() throws Exception {

        String responseString = this.restTemplate.getForObject("http://localhost:8082/product",
                String.class);

        ObjectMapper mapper = new ObjectMapper();

        List<Product> products = mapper.readValue(responseString, new TypeReference<List<Product>>() {});

        assertThat(products)
                .hasSize(3)
                .extracting(Product::getProductName)
                .containsExactly("Desktop", "Laptop", "Mouse");

    }

    @Test
    void getAvailableProducts() throws JsonProcessingException {

        String responseString = this.restTemplate.getForObject("http://localhost:8082/product/available-products",
                String.class);

        ObjectMapper mapper = new ObjectMapper();

        List<ProductAvailability> availableProducts = mapper.readValue(responseString, new TypeReference<List<ProductAvailability>>() {});

        // Test Available product prices
        assertThat(availableProducts)
                .hasSize(3)
                .extracting(ProductAvailability::getProductPrice)
                .containsExactly(138000.0F, 235000.0F, 8000.0F);

        // Test product Quantity
        assertThat(availableProducts)
                .hasSize(3)
                .extracting(ProductAvailability::getCurrentQuantity)
                .containsExactly(15, 7, 3);

    }
}