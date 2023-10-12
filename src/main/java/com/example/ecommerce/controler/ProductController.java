package com.example.ecommerce.controler;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.service.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/products")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<Product> existingProducts = productRepository.findAll();
        List<ProductDto> productsDto = existingProducts.stream().map(ProductMapper.INSTANCE::apply).toList();
        return ResponseEntity.accepted().body(productsDto);
    }

    @GetMapping(path = "/products/{identifier}")
    public ResponseEntity<Object> getProductByIdentifier(@PathVariable int identifier) {
        Optional<Product> existingProduct = productRepository.findByIdentifier(identifier);

        if (existingProduct.isEmpty())
                return ResponseEntity.notFound().build();

        ProductDto productDto = ProductMapper.INSTANCE.apply(existingProduct.get());

        return ResponseEntity.accepted().body(productDto);
    }

    @PostMapping(path = "/products")
    public ResponseEntity<Object> createProduct(@RequestBody ProductDto newProductDto) {
        Product savedProduct = productRepository.save(ProductMapper.INSTANCE.apply(newProductDto));
        return ResponseEntity.accepted().body(ProductMapper.INSTANCE.apply(savedProduct));
    }

    @PutMapping(path = "/products")
    public ResponseEntity<Object> updateProduct(@RequestBody ProductDto newProductDto) {
        Optional<Long> productId = productRepository.findIdByIdentifier(newProductDto.getIdentifier());

        if (productId.isEmpty())
            return ResponseEntity.notFound().build();

        Product updatedProduct = productRepository.save(ProductMapper.INSTANCE.apply(newProductDto).id(productId.get()));

        return ResponseEntity.accepted().body(productRepository.save(updatedProduct));
    }

}
