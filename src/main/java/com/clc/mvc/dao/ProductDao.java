package com.clc.mvc.dao;

import java.util.List;

import com.clc.mvc.entities.ProductEntity;

public interface ProductDao {
	public boolean addProduct(ProductEntity entity);
	public ProductEntity getProduct(int entityId);
	public List<ProductEntity> getAllProduct();
	public ProductEntity updateProduct(ProductEntity entity);
	public List<ProductEntity> deleteProduct(int entityId);

}
