package com.example.ecommerce.repository;

import com.example.ecommerce.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByIdentifier(int identifier);

    @Query("SELECT id FROM Customer c WHERE c.identifier = :identifier")
    Optional<Long> findIdByIdentifier(@Param("identifier") int identifier);

    void deleteByIdentifier(int identifier);

}
