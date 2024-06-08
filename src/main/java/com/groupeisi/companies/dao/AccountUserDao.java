package com.groupeisi.companies.dao;

import java.util.List;

import com.groupeisi.companies.entities.AccountUserEntity;

public class AccountUserDao implements IAccountUserDao{

	@Override
	public AccountUserEntity login(String email, String password) {
		return new AccountUserEntity(1L, "fz@gmail.com", "passer", true);
	}

	@Override
	public List<AccountUserEntity> findAll() {
		return List.of(
				new AccountUserEntity(1L, "fz@gmail.com", "passer", true),
				new AccountUserEntity(1L, "awa@gmail.com", "passer", false),
				new AccountUserEntity(1L, "baye@gmail.com", "passer", true),
				new AccountUserEntity(1L, "modu@gmail.com", "passer", false)
		);
	}

}
