package com.interview.restapi.controller;

import com.interview.restapi.model.Product;
import com.interview.restapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/{barcode}")
    public ResponseEntity<Map<String, Object>> getProducts(@PathVariable String barcode) {
        Product product = service.getProducts(barcode);
        if (product != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("barcode", product.getBarcode());
            response.put("item", product.getItem());
            response.put("price", product.getPrice());
            response.put("discount", product.getDiscount());
            response.put("category",product.getCategory());
            response.put("available",product.getAvailable());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
