package com.groupeisi.companies.dao;

import java.util.List;

import com.groupeisi.companies.entities.AccountUserEntity;

public interface IAccountUserDao {
	
	AccountUserEntity login(String email, String password);
	
	List<AccountUserEntity> findAll();

}
