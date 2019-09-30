package com.clc.mvc.config;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc

@Configuration
@ComponentScan(basePackages = {"com.clc.mvc.*"})
//@PropertySource("${classpath:database.properties}") // spring-hibernate2
@PropertySource("classpath:database.properties")//spring mvc
public class SpringBeansConfig {
	
	@Value("${spring.hibernate.hsqldb.username}")
	String SQL_USERNAME;
	
	@Value("${spring.hibernate.hsqldb.password}")
	String SQL_PASSWORD;
	
	@Value("${spring.hibernate.hsqldb.driver}")
	String SQL_DRIVER;
	
	@Value("${spring.hibernate.hsqldb.url}")
	String SQL_URL;
	
	@Value("${spring.hibernate.hsqldb.dialect}")
	String SQL_DIALECT;
	
	@Value("${spring.hiernate.create.tables}")
	String SQL_CREATE_TABLE;
	
	@Value("${spring.hiernate.show.sql}")
	String SQL_SHOW;
	
	@Value("${spring.hiernate.format.sql}")
	String SQL_FORMAT;
	
	@Value("${spring.hiernate.scan.pckg}")
	String SQL_SCAN_PACKAGE;
	
	
	static {
		System.out.println("Spring configuration loaded");
	}
	
	
	@Bean
	public BasicDataSource createDbConfiguration() {
		BasicDataSource basicDb = new BasicDataSource();
		basicDb.setUrl(SQL_URL);
		basicDb.setUsername(SQL_USERNAME);
		basicDb.setPassword(SQL_PASSWORD);
		basicDb.setDriverClassName(SQL_DRIVER);
		return basicDb;
	}

	@Bean
	public LocalSessionFactoryBean createSessionfactory() {
		System.out.println("Localsessionfactory instance created...!");
		LocalSessionFactoryBean localBean = new LocalSessionFactoryBean();
		localBean.setDataSource(createDbConfiguration());
		localBean.setPackagesToScan(SQL_SCAN_PACKAGE);
		localBean.setHibernateProperties(getHibernateProperties());
		return localBean;
	}
	
	public Properties getHibernateProperties() {
		Properties prop = new Properties();
		prop.put(Environment.DIALECT,SQL_DIALECT);
		prop.put(Environment.SHOW_SQL,true);
		prop.put("hbm2ddl.auto","update");
		//prop.put(Environment.HBM2DDL_AUTO,"create");
		prop.put("hibernate.temp.use_jdbc_metadata_defaults",false);
		return prop;
	}
	
	
	@Bean
	public InternalResourceViewResolver prepareViewResoulver() {
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setViewClass(JstlView.class);
		view.setPrefix("/WEB-INF/");
		view.setSuffix(".jsp");
		return view;
	}
	

	{
		System.out.println("inside config file..12222");
	}
}
