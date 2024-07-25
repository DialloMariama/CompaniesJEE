package com.groupeisi.companies.service;

import java.util.List;
import java.util.Optional;

import com.groupeisi.companies.dto.PurchaseDto;


public interface IPurchaseService {
	
	Optional<List<PurchaseDto>> findAll();
	
	boolean save(PurchaseDto purchaseDto);

}
