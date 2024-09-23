package com.groupeisi.companies.service;

import java.util.List;
import java.util.Optional;

import com.groupeisi.companies.dto.SalesDto;

public interface ISalesService {

    Optional<List<SalesDto>> findAll();
    
    boolean save(SalesDto salesDto);
}
