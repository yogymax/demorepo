package com.clc.mvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebXmlJavaConfigu implements WebApplicationInitializer{

	public void onStartup(ServletContext servletContext) throws ServletException {
		 	AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
	        webCtx.register(SpringBeansConfig.class);
	        servletContext.setInitParameter("contextconfiglocation","database.properties");
	        webCtx.setServletContext(servletContext);
	        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(webCtx));
	        servlet.setLoadOnStartup(1);
	        servlet.addMapping("/");		
		System.out.println("inside web");
	}


	
	
}
