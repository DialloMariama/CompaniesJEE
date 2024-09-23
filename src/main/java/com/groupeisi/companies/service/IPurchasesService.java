package com.groupeisi.companies.service;

import java.util.List;
import java.util.Optional;

import com.groupeisi.companies.dto.PurchasesDto;

public interface IPurchasesService {
	
    Optional<List<PurchasesDto>> findAll();
    
    boolean save(PurchasesDto purchasesDto);
    
}
