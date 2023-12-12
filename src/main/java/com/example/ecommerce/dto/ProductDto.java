package com.example.ecommerce.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {

    private String identifier;

    private String name;

    private BigDecimal price;

    public ProductDto identifier(String identifier) {
        this.identifier = identifier;
        return this;
    }
}
