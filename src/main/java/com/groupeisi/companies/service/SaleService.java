package com.groupeisi.companies.service;

import java.util.List;
import java.util.Optional;

import com.groupeisi.companies.dao.ISaleDao;
import com.groupeisi.companies.dao.SaleDao;
import com.groupeisi.companies.dto.SaleDto;
import com.groupeisi.companies.entities.PurchaseEntity;
import com.groupeisi.companies.entities.SaleEntity;
import com.groupeisi.companies.mapper.PurchaseMapper;
import com.groupeisi.companies.mapper.SaleMapper;

public class SaleService implements ISaleService {

	private ISaleDao saleDao = new SaleDao();

	public void setSaleDao(ISaleDao saleDao) {
		this.saleDao = saleDao;
	}
	
	@Override
	public Optional<List<SaleDto>> findAll() {
		List<SaleEntity> saleEntityList = saleDao.list(new SaleEntity());
		
		return Optional.of(SaleMapper.toListSaleDto(saleEntityList));
	}

	@Override
	public boolean save(SaleDto saleDto) {
		return saleDao.save(SaleMapper.toSaleEntity(saleDto));
	}

}
