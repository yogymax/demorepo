package com.clc.mvc.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.clc.mvc.bean.ProductBean;
import com.clc.mvc.service.ProductService;
import com.clc.mvc.service.impl.ProductServiceImpl;

@Controller
public class ProductController {

	@Autowired
	public ProductService productService;
	
	static {
		System.out.println("product controller loaded");
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public ModelAndView saveProduct(@ModelAttribute("productbean") ProductBean bean) {
		System.out.println("saveProduct invoked..."+bean);
		if(bean.getProductId()>0) {
			productService.updateProduct(bean);
		}else
			productService.addProduct(bean);
		return new ModelAndView("redirect:/add");
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public ModelAndView navigateToAddProductPage() {
		System.out.println("navigateToAddProductPage invoked");
		HashMap<String,Object> model = new HashMap<String, Object>();
		model.put("productbean",new ProductBean()); // empty bean
		model.put("products",productService.getAllProduct()); // empty bean
		return new ModelAndView("addproduct",model);
	}
	
	//http://localhost:8081/newmvc ---- index.jsp
		// link -- Add New Product ----- /add ----
	
	@RequestMapping("edit/{pid}")
	public ModelAndView editProduct(@PathVariable("pid") int pid) {
		System.out.println("editProduct invoked");
		HashMap<String,Object> model = new HashMap<String, Object>();
		model.put("productbean",productService.getProduct(pid)); // empty bean
		model.put("products",productService.getAllProduct()); // empty bean
		return new ModelAndView("addproduct",model);
	}
	
	
	@RequestMapping("delete/{pid}")
	public ModelAndView deleteProduct(@PathVariable("pid") int pid) {
		System.out.println("delete product invoked");
		productService.deleteProduct(pid);
		return new ModelAndView("redirect:/add");
	}
	
	
	
	

}
