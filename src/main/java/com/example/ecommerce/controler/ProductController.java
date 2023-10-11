package com.example.ecommerce.controler;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping(path = "/products/{identifier}")
    public Product getProductByIdentifier(@PathVariable int identifier) {
        return productRepository.findByIdentifier(identifier);
    }

    @PostMapping(path = "/products")
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping(path = "/products")
    public Product updateProduct(@RequestBody Product product) {
        Long productId = productRepository.findIdByIdentifier(product.getIdentifier());

        if (productId == null)
            return null;

        Product newProduct = product.id(productId);
        return productRepository.save(newProduct);
    }

}
