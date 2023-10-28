package com.example.ecommerce.controler;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;
import com.example.ecommerce.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @GetMapping(path = "/products")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<Product> existingProducts = productService.findAll();
        List<ProductDto> productsDto = existingProducts.stream().map(ProductMapper.INSTANCE::apply).toList();

        return ResponseEntity.ok().body(productsDto);
    }

    @GetMapping(path = "/products/{identifier}")
    public ResponseEntity<ProductDto> getProductByIdentifier(@PathVariable int identifier) {
        Optional<Product> existingProduct = productService.findByIdentifier(identifier);

        if (existingProduct.isEmpty())
                return ResponseEntity.notFound().build();

        ProductDto productDto = ProductMapper.INSTANCE.apply(existingProduct.get());

        return ResponseEntity.accepted().body(productDto);
    }

    @PostMapping(path = "/products")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto newProductDto) {
        Product savedProduct = productService.save(ProductMapper.INSTANCE.apply(newProductDto));

        return ResponseEntity.accepted().body(ProductMapper.INSTANCE.apply(savedProduct));
    }

    @PutMapping(path = "/products")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto newProductDto) {
        Optional<Long> productId = productService.findIdByIdentifier(newProductDto.getIdentifier());

        if (productId.isEmpty())
            return ResponseEntity.notFound().build();

        Product updatedProduct = productService.save(ProductMapper.INSTANCE.apply(newProductDto).id(productId.get()));

        return ResponseEntity.accepted().body(ProductMapper.INSTANCE.apply(productService.save(updatedProduct)));
    }

}
