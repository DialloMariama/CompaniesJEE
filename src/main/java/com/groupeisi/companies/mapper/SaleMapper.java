package com.groupeisi.companies.mapper;

import java.util.List;

import com.groupeisi.companies.dto.SaleDto;
import com.groupeisi.companies.entities.SaleEntity;

public class SaleMapper {

	private SaleMapper() {
		
	}

	public static SaleEntity toSaleEntity(SaleDto saleDto) {
		
		SaleEntity saleEntity = new SaleEntity();
		
		saleEntity.setDate(saleDto.getDate());
		saleEntity.setQuantity(saleDto.getQuantity());
		saleEntity.setProduct(ProductMapper.toProductEntity(saleDto.getProduct()));
		
		return saleEntity;	
	}
	
	public static SaleDto toSaleDto(SaleEntity saleEntity) {
		
		SaleDto saleDto = new SaleDto();
		
		saleDto.setDate(saleEntity.getDate());
		saleDto.setId(saleEntity.getId());
		saleDto.setQuantity(saleEntity.getQuantity());
		saleDto.setProduct(ProductMapper.toProductDto(saleEntity.getProduct()));
		
		return saleDto;	
	}
	
	public static List<SaleDto> toListSaleDto(List<SaleEntity> SaleEntities) {
		return SaleEntities.stream()
							.map(SaleMapper::toSaleDto)
							.toList();		
	}	
}