package com.clc.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clc.mvc.bean.ProductBean;
import com.clc.mvc.dao.ProductDao;
import com.clc.mvc.dao.impl.ProductDaoImpl;
import com.clc.mvc.entities.ProductEntity;
import com.clc.mvc.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	public ProductDaoImpl productdao;
	
	static {
		System.out.println("product serviceimpl loaded");
	}

	public boolean addProduct(ProductBean bean) {
		if(bean!=null && bean.getProductName().length()>=3)
			return productdao.addProduct(beanToEntity(bean));
		
		System.out.println("invalid productName");
		return false;
	}

	private ProductEntity beanToEntity(ProductBean bean) {
		return new ProductEntity(bean.getProductId(), bean.getProductName(),
				bean.getProductCategory(), bean.getProductPrice(), bean.getVendorName());
	}

	public ProductBean getProduct(int beanId) {
		return entityToBean(productdao.getProduct(beanId));
	}

	private ProductBean entityToBean(ProductEntity bean) {
		return new ProductBean(bean.getProductId(), bean.getProductName(),
				bean.getProductCategory(), bean.getProductPrice(), bean.getVendorName());
	}

	public List<ProductBean> getAllProduct() {
		return entitiesToBeans(productdao.getAllProduct());
	}

	private List<ProductBean> entitiesToBeans(List<ProductEntity> allProduct) {
		List<ProductBean> beans = new ArrayList<ProductBean>();
		for(ProductEntity entity : allProduct) {
				beans.add(entityToBean(entity));
		}
		return beans;
	}

	public ProductBean updateProduct(ProductBean bean) {
		return entityToBean(productdao.updateProduct(beanToEntity(bean)));
	}

	public List<ProductBean> deleteProduct(int beanId) {
		return entitiesToBeans(productdao.deleteProduct(beanId));
	}
	
	
	
}
