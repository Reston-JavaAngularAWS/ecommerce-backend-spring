package com.ecommerce.maven.service;


import java.util.List;

import com.ecommerce.maven.pojo.OrderPojo;
import com.ecommerce.maven.pojo.ProductPojo;
import com.ecommerce.maven.pojo.UserPojo;


public interface EcommService {
	
	// Login
	// No way to truly test Login on Postman
	
	// Register User
	UserPojo registerUser(UserPojo userPojo);
	
	// Display Products
	List<ProductPojo> getAllProducts();
	
	// updateCart
	OrderPojo updateCart(OrderPojo orderPojo);
	
	// Checkout
	OrderPojo checkOut(OrderPojo orderPojo);
	
	// View Previous Orders
	List<OrderPojo> findPreviousOrdersById(int userId);
	
	// User Profile
	UserPojo findByUsernameAndPassword(String username, String Password);
	
	// [Optional - Utility] Add Products
	ProductPojo addProducts(ProductPojo newProduct);
	
	// [Optional - Utility] Remove Products
	void deleteProduct(int sku);
	

}
