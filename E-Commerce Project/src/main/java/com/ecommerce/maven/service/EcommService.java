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
	
	// Add Products
	ProductPojo addProducts(ProductPojo newProduct);
	
	List<OrderItemPojo> getAllOrderItems();
	
	
	OrderPojo findPreviousOrderById(int userId);
	
	OrderPojo getAOrder(int userId);
	
	OrderItemPojo getAOrderItem(int orderNo);
	
	

}
