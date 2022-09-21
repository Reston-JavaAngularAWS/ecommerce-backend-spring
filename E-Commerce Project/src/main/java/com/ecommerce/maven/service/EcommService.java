package com.ecommerce.maven.service;


import java.util.List;

import com.ecommerce.maven.pojo.OrderItemPojo;
import com.ecommerce.maven.pojo.OrderPojo;
import com.ecommerce.maven.pojo.ProductPojo;
import com.ecommerce.maven.pojo.UserPojo;


public interface EcommService {
	
	// Fetches user information
	
	// Login(Kinda)
	UserPojo findByUsernameAndPassword(String username, String Password);
	
	// Register User
	UserPojo registerUser(UserPojo userPojo);
	
	// Cart
	OrderPojo addToCart(OrderPojo newOrder);
	
	// Display Products
	List<ProductPojo> getAllProducts();
	
	
	OrderPojo findPreviousOrderById(int userId);
	
	List<OrderItemPojo> getAllOrderItems();
	
	OrderPojo getAOrder(int userId);
	
	OrderItemPojo getAOrderItem(int orderNo);
	
	

}
