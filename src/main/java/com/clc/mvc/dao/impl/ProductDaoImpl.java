package com.clc.mvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clc.mvc.dao.ProductDao;
import com.clc.mvc.entities.ProductEntity;


@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	public SessionFactory sessionFactory;
	
	static {
		System.out.println("product daoimpl loaded");
	}

	public boolean addProduct(ProductEntity entity) {
		Session session =null;
		Transaction tr = null;
		try {
			session = sessionFactory.openSession();
			tr=session.beginTransaction();
			return (Integer)session.save(entity)>0;
		}catch(Exception e) {
			return false;
		}finally {
			cleanUpResources(session,tr);
		}
		
	}

	private void cleanUpResources(Session session, Transaction tr) {
		if(session!=null) {
			if(tr!=null) {
				session.flush();
				tr.commit();
			}
			session.close();
		}
			
	}

	public ProductEntity getProduct(int entityId) {
		Session session =null;
		Transaction tr = null;
		try {
			session = sessionFactory.openSession();
			tr=session.beginTransaction();
			return session.get(ProductEntity.class,entityId);
		}catch(Exception e) {
			System.out.println("failed..get operation");
			return null;
		}finally {
			cleanUpResources(session, tr);
		}

	}

	public List<ProductEntity> getAllProduct() {
		Session session =null;
		Transaction tr = null;
		try {
			session = sessionFactory.openSession();
			tr=session.beginTransaction();
			return session.createCriteria(ProductEntity.class).list();
		}catch(Exception e) {
			System.out.println("failed..get operation");
			return null;
		}finally {
			cleanUpResources(session, tr);
		}
		
	}

	public ProductEntity updateProduct(ProductEntity entity) {
		Session session =null;
		Transaction tr = null;
		try {
			session = sessionFactory.openSession();
			tr=session.beginTransaction();
			ProductEntity dbEntity = getProduct(entity.getProductId());
			if(dbEntity!=null) {
				dbEntity.setProductCategory(entity.getProductCategory());
				dbEntity.setProductName(entity.getProductName());
				dbEntity.setProductPrice(entity.getProductPrice());
				dbEntity.setVendorName(entity.getVendorName());
				session.update(dbEntity);
			}
			return getProduct(entity.getProductId());
		}catch(Exception e) {
			return null;
		}finally {
			cleanUpResources(session,tr);
		}
	}

	public List<ProductEntity> deleteProduct(int entityId) {
		Session session =null;
		Transaction tr = null;
		try {
			session = sessionFactory.openSession();
			tr=session.beginTransaction();
			session.delete(getProduct(entityId));
		}catch(Exception e) {
		}finally {
			cleanUpResources(session,tr);
		}
		return getAllProduct();
	}
	

}
