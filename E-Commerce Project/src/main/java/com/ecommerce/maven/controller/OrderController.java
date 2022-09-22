package com.ecommerce.maven.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.maven.pojo.OrderPojo;
import com.ecommerce.maven.service.EcommService;

@CrossOrigin
@RestController
@RequestMapping("api/order")
public class OrderController {
	
	@Autowired
	EcommService service;
	
	// Add to Cart
	@PostMapping("")
	OrderPojo addToCart() {
		return null;
		
	}
	
	// View Previous Order
	@GetMapping("/{userId}")
	OrderPojo findPreviousOrderById(@PathVariable("userId") int userId) {
		return service.findPreviousOrderById(userId);
		
	}

}
