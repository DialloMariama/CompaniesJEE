package com.groupeisi.companies.service;

import java.util.List;
import java.util.Optional;

import com.groupeisi.companies.dto.AccountUserDto;

public interface IAccountUserService {

	Optional<AccountUserDto> login(String email, String password);
	
	Optional<List<AccountUserDto>> findAll();

}
