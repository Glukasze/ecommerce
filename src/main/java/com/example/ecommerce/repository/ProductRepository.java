package com.example.ecommerce.repository;


import com.example.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByIdentifier(int identifier);

    @Query("SELECT id FROM Product p WHERE p.identifier = :identifier")
    Long findIdByIdentifier(@Param("identifier") int identifier);

}
