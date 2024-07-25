package com.groupeisi.companies.service;

import java.util.List;
import java.util.Optional;

import com.groupeisi.companies.dto.ProductDto;
import com.groupeisi.companies.entities.ProductEntity;

public interface IProductService {

	Optional<List<ProductDto>> findAll();
	
	boolean save(ProductDto productDto);
	
	ProductDto getByid(String id, ProductEntity product);
	
	boolean update(ProductDto productDto);

}
