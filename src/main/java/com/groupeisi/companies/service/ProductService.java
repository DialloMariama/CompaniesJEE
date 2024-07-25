package com.groupeisi.companies.service;

import java.util.List;
import java.util.Optional;

import com.groupeisi.companies.dao.IAccountUserDao;
import com.groupeisi.companies.dao.IProductDao;
import com.groupeisi.companies.dao.ProductDao;
import com.groupeisi.companies.dto.ProductDto;
import com.groupeisi.companies.entities.ProductEntity;
import com.groupeisi.companies.mapper.ProductMapper;

public class ProductService implements IProductService{
	
	private IProductDao productDao = new ProductDao();

	public void setProductDao(IProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public Optional<List<ProductDto>> findAll() {
		List<ProductEntity> productEntityList = productDao.list(new ProductEntity());
		
		return Optional.of(ProductMapper.toListProductDto(productEntityList));
	}

	@Override
	public boolean save(ProductDto productDto) {
		return productDao.save(ProductMapper.toProductEntity(productDto));
	}

	@Override
	public ProductDto getByid(String id, ProductEntity product) {
		return ProductMapper.toProductDto(productDao.get(id, product));
	}

	@Override
	public boolean update(ProductDto productDto) {
		return productDao.update(ProductMapper.toProductEntity(productDto));
	}

}
