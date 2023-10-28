package com.example.ecommerce.service.mapper;

import com.example.ecommerce.dto.CustomerDto;
import com.example.ecommerce.model.Customer;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDto apply(Customer customer);

    Customer apply(CustomerDto customerDto);

}
