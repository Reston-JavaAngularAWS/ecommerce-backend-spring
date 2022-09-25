package com.ecommerce.maven.service;


import java.util.List;

import com.ecommerce.maven.pojo.OrderPojo;
import com.ecommerce.maven.pojo.ProductPojo;
import com.ecommerce.maven.pojo.UserPojo;


public interface EcommService {
	
	// Login
	UserPojo findByUsernameAndPassword(UserPojo userPojo);
	
	// Register User
	UserPojo registerUser(UserPojo userPojo);
	
	// Display Products
	List<ProductPojo> getAllProducts();
	
	// updateCart
	OrderPojo updateCart(OrderPojo orderPojo);
	
	// Checkout
	OrderPojo checkOut(int userId);
	
	// View Previous Orders
	List<OrderPojo> findPreviousOrdersById(int userId);
	
	// User Profile
	UserPojo findUserProfile(UserPojo userPojo);
	
	// [Optional - Utility] Add Products
	ProductPojo addProducts(ProductPojo newProduct);
	
	// [Optional - Utility] Remove Products
	void deleteProduct(int productSku);
	

}
