package com.interview.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    private String barcode;
    private String item;
    private String category;
    private int price;
    private int discount;
    private int available;


}
