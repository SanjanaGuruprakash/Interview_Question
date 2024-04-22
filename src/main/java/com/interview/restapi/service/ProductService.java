package com.interview.restapi.service;

import com.interview.restapi.model.Product;
import com.interview.restapi.dtos.ProductResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService {


    private RestTemplate restTemplate = new RestTemplate();
    private String url = "https://jsonmock.hackerrank.com/api/inventory";

    public Product getProducts(String barcode) {
        ProductResponseDto response = restTemplate.getForObject(url, ProductResponseDto.class);
        List<Product> item=new ArrayList<>();
        if(response!=null && response.getData()!=null){
            for(Product product: response.getData()){
                    if (product.getBarcode().equalsIgnoreCase(barcode)) {
                        item.add(product);
                    }
            }
        }
        Product product=null;
        for(Product p:item){
            if (p.getBarcode().equals(barcode))
                return p;
        }

        return null;
    }
}