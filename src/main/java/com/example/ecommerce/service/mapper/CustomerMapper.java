package com.example.ecommerce.service.mapper;

import com.example.ecommerce.dto.CustomerDto;
import com.example.ecommerce.model.Customer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDto apply(Customer customer);

    @Mapping(target = "identifier", ignore = true)
    Customer apply(CustomerDto customerDto);

}
