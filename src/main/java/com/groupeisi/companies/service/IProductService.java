package com.groupeisi.companies.service;

import java.util.List;
import java.util.Optional;

import com.groupeisi.companies.dto.ProductDto;

public interface IProductService {

    Optional<List<ProductDto>> findAll();

    boolean save(ProductDto productDto);

    Optional<ProductDto> findByRef(String ref);
    
    boolean update(ProductDto productDto);
}
