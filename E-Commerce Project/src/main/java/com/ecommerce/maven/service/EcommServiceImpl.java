package com.ecommerce.maven.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.maven.dao.OrderDao;
import com.ecommerce.maven.dao.OrderItemDao;
import com.ecommerce.maven.dao.ProductDao;
import com.ecommerce.maven.dao.UserDao;
import com.ecommerce.maven.entity.OrderEntity;
import com.ecommerce.maven.entity.OrderItemEntity;
import com.ecommerce.maven.entity.ProductEntity;
import com.ecommerce.maven.entity.UserEntity;
import com.ecommerce.maven.pojo.OrderItemPojo;
import com.ecommerce.maven.pojo.OrderPojo;
import com.ecommerce.maven.pojo.ProductPojo;
import com.ecommerce.maven.pojo.UserPojo;

@Service
public class EcommServiceImpl implements EcommService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	OrderItemDao orderItemDao;
	
	@Autowired
	ProductDao productDao;
	
	
	
	public EcommServiceImpl() {

	}
	
	/*
	 * Register
	 * As a User, you can register a new account
	 */
	@Override
	public UserPojo registerUser(UserPojo userPojo) {
		UserEntity newUserEntity = new UserEntity();
		BeanUtils.copyProperties(userPojo, newUserEntity);
		userDao.saveAndFlush(newUserEntity);
		
		userPojo.setUserID(newUserEntity.getUserID());
		return userPojo;
	}
	
	/*
	 * Login
	 * As a User or Admin, you can log into the application.
	 */
	@Override
	public UserPojo findByUsernameAndPassword(String username, String password) {
		Optional<UserEntity> optionalUserEntity = userDao.findByUsernameAndPassword(username, password);
		UserPojo fecthedUserPojo = null;
		if (optionalUserEntity.isPresent()) {
			fecthedUserPojo = new UserPojo();
			BeanUtils.copyProperties(optionalUserEntity.get(), fecthedUserPojo);
		}
		return fecthedUserPojo;
	}
	
	/*
	 * Display Products
	 * As a User Guest or Admin, you can see a list of available products for you to add to your cart.
	 */
	@Override
	public List<ProductPojo> getAllProducts() {
		List<ProductEntity> allproductsEntity = productDao.findAll();
		List<ProductPojo> allProductsPojo = new ArrayList<ProductPojo>();
		allproductsEntity.forEach((eachEntity)->allProductsPojo.add(new ProductPojo(
				eachEntity.getSku(), 
				eachEntity.getProductQuantity(), 
				eachEntity.getProductImage(), 
				eachEntity.getProductName(),
				eachEntity.getProductPrice())));
		return allProductsPojo;
	}
	
	/*
	 * Cart
	 * As a User or Guest, you can add items to your cart that you will later purchase or remove from your cart.
	 */
	@Override
	public OrderPojo addToCart(OrderPojo newOrder) {
		
		OrderEntity newOrderEntity = new OrderEntity();
		// Copy collection of product pojo into 
		
		BeanUtils.copyProperties(newOrder, newOrderEntity);
		
		orderDao.saveAndFlush(newOrderEntity);
		
		newOrder.setOrderNo(newOrderEntity.getOrderNo());
		
		return newOrder;
	}
	
	/*
	 * View Previous Orders
	 * As a User, I should be able to view a list of all my previous orders and access the details of each order.
	 */
	@Override
	public OrderPojo findPreviousOrderById(int userId) {
		Optional<OrderEntity> orderEntity = orderDao.findById(userId);
		OrderPojo fetchedOrderPojo = null;
		if(orderEntity.isPresent()) {
			fetchedOrderPojo = new OrderPojo();
			BeanUtils.copyProperties(orderEntity.get(), fetchedOrderPojo);
		}
		return fetchedOrderPojo;
	}

	@Override
	public OrderPojo getAOrder(int userId) {
		Optional<OrderEntity> orderOptional = orderDao.findById(userId);
		OrderPojo orderPojo = new OrderPojo();
		BeanUtils.copyProperties(orderOptional.get(), orderPojo);
		return orderPojo;
	}
	
	
	@Override
	public List<OrderItemPojo> getAllOrderItems() {
		List<OrderItemEntity> orderItemEntity = orderItemDao.findAll();
		List<OrderItemPojo> orderItemPojo = new ArrayList<OrderItemPojo>();
		
		OrderItemPojo itemPojo = new OrderItemPojo();
		OrderPojo orderPojo = new OrderPojo();
		
		orderItemEntity.forEach((eachEntity)->{
			
			BeanUtils.copyProperties(eachEntity, itemPojo);
			
			BeanUtils.copyProperties(eachEntity.getOrderEntity(), orderPojo);
			itemPojo.setOrderPojo(orderPojo);
			
			orderItemPojo.add(itemPojo);
		});
		
		return orderItemPojo;
	}

	@Override
	public OrderItemPojo getAOrderItem(int orderNo) {
		Optional<OrderItemEntity> orderOptional = orderItemDao.findById(orderNo);
		OrderItemEntity orderEntity  = orderOptional.get();
		
		OrderItemPojo orderItemPojo = new OrderItemPojo();
		BeanUtils.copyProperties(orderEntity, orderItemPojo);
		
		OrderPojo orderPojo = new OrderPojo();
		BeanUtils.copyProperties(orderEntity.getOrderEntity(), orderPojo);
		orderItemPojo.setOrderPojo(orderPojo);
		return orderItemPojo;
	}
	
	/*
	 * [Optional] Create/Update Products
	 * As an Admin, I should be able to create a new product to be displayed or update an existing product.
	 */
	@Override
	public ProductPojo addProducts(ProductPojo newProduct) {
		ProductEntity newProductEntity = new ProductEntity();
		BeanUtils.copyProperties(newProduct, newProductEntity);
		productDao.saveAndFlush(newProductEntity);
		
		newProduct.setSku(newProductEntity.getSku());
		return newProduct;
	}

}
