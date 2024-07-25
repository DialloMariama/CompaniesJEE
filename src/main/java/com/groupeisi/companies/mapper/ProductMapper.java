package com.groupeisi.companies.mapper;

import java.util.List;

import com.groupeisi.companies.dto.ProductDto;
import com.groupeisi.companies.entities.ProductEntity;

public class ProductMapper {

	private ProductMapper() {
		
	}

	public static ProductEntity toProductEntity(ProductDto ProductDto) {
		
		ProductEntity ProductEntity = new ProductEntity();
		
		ProductEntity.setReference(ProductDto.getReference());
		ProductEntity.setName(ProductDto.getName());
		ProductEntity.setStock(ProductDto.getStock());
		
		return ProductEntity;	
	}
	
	public static ProductDto toProductDto(ProductEntity ProductEntity) {
		
		ProductDto ProductDto = new ProductDto();
		
		ProductDto.setName(ProductEntity.getName());
		ProductDto.setReference(ProductEntity.getReference());
		ProductDto.setStock(ProductEntity.getStock());
		
		return ProductDto;	
	}
	
	public static List<ProductDto> toListProductDto(List<ProductEntity> ProductEntities) {
		return ProductEntities.stream()
							.map(ProductMapper::toProductDto)
							.toList();		
	}	
	
	public static List<ProductEntity> toListProductEntity(List<ProductDto> ProductDtos) {
		return ProductDtos.stream()
							.map(ProductMapper::toProductEntity)
							.toList();		
	}	
}
