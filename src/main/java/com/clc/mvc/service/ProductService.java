package com.clc.mvc.service;

import java.util.List;

import com.clc.mvc.bean.ProductBean;

public interface ProductService {
	public boolean addProduct(ProductBean bean);
	public ProductBean getProduct(int beanId);
	public List<ProductBean> getAllProduct();
	public ProductBean updateProduct(ProductBean bean);
	public List<ProductBean> deleteProduct(int beanId);
}
