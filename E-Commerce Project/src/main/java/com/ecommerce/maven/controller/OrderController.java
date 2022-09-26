package com.ecommerce.maven.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.maven.pojo.OrderPojo;
import com.ecommerce.maven.service.EcommService;

@CrossOrigin
@RestController
@RequestMapping("api/order") //http://localhost:8080/api/order
public class OrderController {

	@Autowired
	EcommService service;


	// View Previous Order
	@GetMapping("/{userID}")
	List<OrderPojo> findPreviousOrderById(@PathVariable("userID") Integer userID) {
		return service.findPreviousOrdersById(userID);

	}

	// Cart
	@PutMapping("update")
	public  OrderPojo updateCart(@RequestBody OrderPojo orderPojo){
		return service.updateCart(orderPojo);
	}

	// Checkout
	@PutMapping("checkout/{userID}")
	public  void checkOut(@PathVariable("userID") Integer userID){
		service.checkOut(userID);
	}



}
