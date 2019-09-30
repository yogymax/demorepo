package com.clc.mvc.test;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.clc.mvc.config.SpringBeansConfig;
import com.clc.mvc.controller.ProductController;
import com.clc.mvc.dao.impl.ProductDaoImpl;
import com.clc.mvc.service.impl.ProductServiceImpl;

public class TestConfigSeperately {

public static void main(String[] args) {
	ApplicationContext context = new AnnotationConfigApplicationContext(SpringBeansConfig.class);
	ProductController controller = (ProductController) context.getBean("prodc");
	//ProductServiceImpl service = controller.productService;
	//ProductDaoImpl daoImpl = service.productdao;
	//SessionFactory sessionFactory = daoImpl.sessionFactory;
	
	//System.out.println(sessionFactory.hashCode());
	
	
}
	
}
