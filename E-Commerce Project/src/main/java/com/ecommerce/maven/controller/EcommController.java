package com.ecommerce.maven.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.maven.pojo.OrderItemPojo;
import com.ecommerce.maven.pojo.OrderPojo;
import com.ecommerce.maven.pojo.ProductPojo;
import com.ecommerce.maven.pojo.UserPojo;
import com.ecommerce.maven.service.EcommService;

@RestController
@RequestMapping("api/ecommerce")
public class EcommController {
	
	@Autowired
	EcommService service;
	
	// Having only one controller creates ambiguity which result in boot errors
	
	// Login - User Profile
//	@GetMapping("/{username}/{password}")
//	public UserPojo findByUsernameAndPassword(@PathVariable("username") String username, @PathVariable("password") String password){
//		
//		return service.findByUsernameAndPassword(username, password);
//		
//	}
	
	// Register User
//	@PostMapping("")
//	public UserPojo registerUser(@Valid @RequestBody UserPojo newUser){
//		return service.registerUser(newUser);
//	}
//	
//    // View Previous Order
//	@GetMapping("/{userId}")
//	OrderPojo findPreviousOrderById(@PathVariable("userId") int userId) {
//		return service.findPreviousOrderById(userId);
//		
//	}
//	
//	//Display Products
//	@GetMapping("")
//	public List<ProductPojo> getAllProducts(){
//		return service.getAllProducts();
//	}
//	
//
//
//	
//	@GetMapping("")
//	public List<OrderItemPojo> getAllOrderItems(){
//		return service.getAllOrderItems();
//	}
//	
//	@GetMapping("/{orderNo}")
//	public OrderItemPojo getAOrderItem(@PathVariable("order_no") int orderNo) {
//		return service.getAOrderItem(orderNo);
//	}


}
