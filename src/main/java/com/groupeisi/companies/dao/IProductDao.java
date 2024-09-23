package com.groupeisi.companies.dao;

import java.util.Optional;

import com.groupeisi.companies.entities.ProductEntity;

public interface IProductDao extends Repository<ProductEntity> {
	
    Optional<ProductEntity> findByRef(String ref);
    
    boolean update(ProductEntity productEntity);
}
