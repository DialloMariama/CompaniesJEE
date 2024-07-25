package com.groupeisi.companies.service;

import java.util.List;
import java.util.Optional;

import com.groupeisi.companies.dto.SaleDto;

public interface ISaleService {

	Optional<List<SaleDto>> findAll();
	
	boolean save(SaleDto saleDto);
}
