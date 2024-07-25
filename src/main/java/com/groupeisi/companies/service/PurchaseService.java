package com.groupeisi.companies.service;

import java.util.List;
import java.util.Optional;

import com.groupeisi.companies.dao.IPurchaseDao;
import com.groupeisi.companies.dao.PurchaseDao;
import com.groupeisi.companies.dto.PurchaseDto;
import com.groupeisi.companies.entities.PurchaseEntity;
import com.groupeisi.companies.mapper.PurchaseMapper;

public class PurchaseService implements IPurchaseService{

	private IPurchaseDao purchaseDao = new PurchaseDao();

	public void setPurchaseDao(IPurchaseDao purchaseDao) {
		this.purchaseDao = purchaseDao;
	}
	
	@Override
	public Optional<List<PurchaseDto>> findAll() {
		List<PurchaseEntity> purchaseEntityList = purchaseDao.list(new PurchaseEntity());
		
		return Optional.of(PurchaseMapper.toListPurchaseDto(purchaseEntityList));
	}

	@Override
	public boolean save(PurchaseDto purchaseDto) {
		return purchaseDao.save(PurchaseMapper.toPurchaseEntity(purchaseDto));
	}

}
