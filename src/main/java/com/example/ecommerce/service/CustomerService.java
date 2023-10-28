package com.example.ecommerce.service;

import com.example.ecommerce.model.Customer;
import com.example.ecommerce.repository.CustomerRepository;

import jakarta.transaction.Transactional;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        customer = customerRepository.save(customer);
        return customer;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findByIdentifier(int identifier) {
        return customerRepository.findByIdentifier(identifier);
    }

    public Optional<Long> findCustomerIdByIdentifier(int identifier) {
        return customerRepository.findIdByIdentifier(identifier);
    }

}
