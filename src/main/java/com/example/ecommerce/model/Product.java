package com.example.ecommerce.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String identifier = UUID.randomUUID().toString();

    private String name;

    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public Product id(Long id) {
        this.id = id;

        return this;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Product identifier(String identifier) {
        this.identifier = identifier;
        return this;
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
