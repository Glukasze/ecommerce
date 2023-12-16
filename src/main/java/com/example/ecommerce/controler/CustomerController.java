package com.example.ecommerce.controler;

import com.example.ecommerce.dto.CustomerDto;
import com.example.ecommerce.model.Customer;
import com.example.ecommerce.service.CustomerService;
import com.example.ecommerce.service.mapper.CustomerMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    @GetMapping(path = "/customers")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        List<Customer> existingCustomers = customerService.findAll();
        List<CustomerDto> CustomerDto = existingCustomers.stream().map(CustomerMapper.INSTANCE::apply).toList();
        return ResponseEntity.ok().body(CustomerDto);
    }

    @GetMapping(path = "/customers/{identifier}")
    public ResponseEntity<CustomerDto> getCustomerByIdentifier(@PathVariable String identifier) {
        Optional<Customer> existingCustomer = customerService.findByIdentifier(identifier);

        if (existingCustomer.isEmpty())
            return ResponseEntity.notFound().build();

        CustomerDto customerDto = CustomerMapper.INSTANCE.apply(existingCustomer.get());

        return ResponseEntity.ok().body(customerDto);
    }

    @PostMapping(path = "/customers")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = customerService.save(CustomerMapper.INSTANCE.apply(customerDto));

        return ResponseEntity.accepted().body(CustomerMapper.INSTANCE.apply(customer));
    }

    @PutMapping(path = "/customers")
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto) {
        Optional<Long> customerId = customerService.findCustomerIdByIdentifier(customerDto.getIdentifier());

        if (customerId.isEmpty())
            return ResponseEntity.notFound().build();

        Customer updatedCustomer = customerService.save(CustomerMapper.INSTANCE.apply(customerDto)
                .id(customerId.get())
                .identifier(customerDto.getIdentifier()));

        return ResponseEntity.accepted().body(CustomerMapper.INSTANCE.apply(updatedCustomer));
    }

    @DeleteMapping(path = "/customer/{identifier}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable String identifier) {
        customerService.deleteByIdentifier(identifier);
        return ResponseEntity.ok().build();
    }

}
