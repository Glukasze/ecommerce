package com.example.ecommerce.dto;

import java.math.BigDecimal;

public class ProductDto {

    private int identifier;

    private String name;

    private BigDecimal price;

    public ProductDto identifier(int identifier) {
        this.identifier = identifier;
        return this;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
