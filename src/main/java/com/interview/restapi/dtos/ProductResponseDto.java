package com.interview.restapi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.interview.restapi.model.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponseDto {

  private Product[] data;
}
