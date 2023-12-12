package com.example.ecommerce.service.mapper;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto apply(Product product);

    @Mapping(target = "identifier", ignore = true)
    Product apply(ProductDto productDto);

}
