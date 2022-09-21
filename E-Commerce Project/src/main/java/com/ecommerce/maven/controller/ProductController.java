package com.ecommerce.maven.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.maven.pojo.ProductPojo;
import com.ecommerce.maven.service.EcommService;

@RestController
@RequestMapping("api/product")
public class ProductController {
	
	@Autowired
	EcommService service;
	
	
	//Display Products
	@GetMapping("")
	public List<ProductPojo> getAllProducts(){
		return service.getAllProducts();
	}
	


}

