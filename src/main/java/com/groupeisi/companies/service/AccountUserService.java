package com.groupeisi.companies.service;

import java.util.List;
import java.util.Optional;

import com.groupeisi.companies.dao.AccountUserDao;
import com.groupeisi.companies.dao.IAccountUserDao;
import com.groupeisi.companies.dto.AccountUserDto;
import com.groupeisi.companies.entities.AccountUserEntity;
import com.groupeisi.companies.mapper.AccountUserMapper;

public class AccountUserService implements IAccountUserService{

	private IAccountUserDao accountUserDao = new AccountUserDao();
	
	/**
	 * Cette méthode permet de vérifier les identifiants d'un utilisateur à partir de son mail et de son mot de passe.
	 * @email : représente l'email de l'utilisateur.
	 * @password : représente le mot de passe de l'utilisateur.
	 * La fonction retourne un Optional de AccountUserDto qui peut être vide ou pas.
	 */
	@Override
	public Optional<AccountUserDto> login(String email, String password) {
		
		if(email.isBlank() || password.isBlank()) {
			return Optional.empty();
		}
		else {
			return testLogin(email, password);
		}
	}

	private Optional<AccountUserDto> testLogin(String email, String password) {
		
		Optional<AccountUserEntity> accountUserEntity = accountUserDao.login(email, password);

		if(accountUserEntity.isPresent()) {
			AccountUserDto accountUserDto = AccountUserMapper.toAccountUserDto(accountUserEntity.get());
			return Optional.of(accountUserDto);
		}
		else {
			return Optional.empty();
		}
	}

	@Override
	public Optional<List<AccountUserDto>> findAll() {
		List<AccountUserEntity> accountUserEntityList = accountUserDao.list(new AccountUserEntity());
		
		return Optional.of(AccountUserMapper.toListAccountUserDto(accountUserEntityList));
	}

	public void setAccountUserDao(IAccountUserDao accountUserDao) {
		this.accountUserDao = accountUserDao;
	}

	@Override
	public boolean save(AccountUserDto accountUserDto) {
		return accountUserDao.save(AccountUserMapper.toAccountUserEntity(accountUserDto));
	}
	
	

}
