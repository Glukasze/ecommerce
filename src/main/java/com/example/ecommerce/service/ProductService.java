package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public Product save(Product product) {
        product = productRepository.save(product);
        return product;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findByIdentifier(String identifier) {
        return productRepository.findByIdentifier(identifier);
    }

    public Optional<Long> findIdByIdentifier(String identifier) {
        return productRepository.findIdByIdentifier(identifier);
    }

    public void deleteByIdentifier(String identifier) {
        productRepository.deleteByIdentifier(identifier);
    }

}
