package com.ecommerce.maven.controller;



import java.util.List;

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
	
	
	// View Previous Order
	@GetMapping("/{userID}")
	List<OrderPojo> findPreviousOrderById(@PathVariable("userID") int userID) {
		return service.findPreviousOrdersById(userID);
		
	}
	
	@PostMapping("")
	public  OrderPojo updateCart(OrderPojo orderPojo){
		return service.updateCart(orderPojo);
	}


}
