package com.ecommerce.maven.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.maven.pojo.ProductPojo;
import com.ecommerce.maven.service.EcommService;

@CrossOrigin
@RestController
@RequestMapping("api/product") //http://localhost:8080/api/product
public class ProductController {
	
	@Autowired
	EcommService service;
	
	//  Create/Update Products
	@PostMapping("add")
	public ProductPojo addProducts(@Valid @RequestBody ProductPojo newProduct){
		return service.addProducts(newProduct);
	}
	
	// Display Products
	@GetMapping("getall")
	public List<ProductPojo> getAllProducts(){
		return service.getAllProducts();
	}
	
	// Remove Items from Cart
	@DeleteMapping("/{bsku}")
	public void deleteProduct(@PathVariable("bsku") int sku) {
		service.deleteProduct(sku);
	}
	

}

