package com.ecommerce.maven.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

	LocalDateTime date = LocalDateTime.now();

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
	public UserPojo findByUsernameAndPassword(UserPojo userPojo) {
		Optional<UserEntity> optionalUserEntity = userDao.findByUsernameAndPassword(userPojo.getUsername(), userPojo.getPassword());
		if (optionalUserEntity.isPresent()) {
			BeanUtils.copyProperties(optionalUserEntity.get(), userPojo);
		}
		return userPojo;
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
				eachEntity.getProductSku(), 
				eachEntity.getProductName(), 
				eachEntity.getProductImage(), 
				eachEntity.getProductQuantity(),
				eachEntity.getProductPrice())));
		return allProductsPojo;
	}

	/*
	 * Cart
	 * As a User or Guest, you can add items to your cart that you will later purchase or remove from your cart.
	 * Steps:
	 * 1. Fetch record from Order table with a UserID and orderStatus as false.
	 * 	-> If it fetches a record it means we have an open cart -> Update query: PK = 0 (save method)
	 * 	-> If it does not fetch, then it is a new record (first item entering into a cart) -> Insert query: PK = Generated (save method)
	 */
	@Override
	public OrderPojo updateCart(OrderPojo orderPojo) {

		OrderEntity orderEntity = orderDao.findByUserIDAndOrderStatus(orderPojo.getUserID(), false);	

		if(orderEntity != null) {
			OrderItemEntity orderItemEntity = new OrderItemEntity();
			orderItemEntity.setOrderNo(orderEntity.getOrderNo());
			orderItemEntity.setProductSku(orderPojo.getAllProducts().get(0).getProductSku());
			orderItemDao.save(orderItemEntity);
		}else{
			ProductEntity productEntity = new ProductEntity();
			productEntity.setProductSku(orderPojo.getAllProducts().get(0).getProductSku());
			productEntity.setProductName(orderPojo.getAllProducts().get(0).getProductName());
			productEntity.setProductImage(orderPojo.getAllProducts().get(0).getProductImage());
			productEntity.setProductQuantity(orderPojo.getAllProducts().get(0).getProductQuantity());
			productEntity.setProductPrice(orderPojo.getAllProducts().get(0).getProductPrice());
			List<ProductEntity> allProducts = new ArrayList<ProductEntity>();
			allProducts.add(productEntity);
			OrderEntity order = new OrderEntity();
			order.setUserID(orderPojo.getUserID());
			order.setOrderStatus(false);
			order.setAllProducts(allProducts);
			orderDao.saveAndFlush(order);
			orderPojo.setOrderNo(order.getOrderNo());
			orderPojo.setOrderDate(order.getOrderDate());
		}

		return orderPojo;

	}


	/*
	 * CheckOut
	 * As a User or Guest, I should be able to checkout with the items in my cart, purchase them and remove them from the inventory.
	 * 1. Have save method to set to true
	 */
	@Override
	public void checkOut(Integer userID) {
		System.out.println(userID);
		OrderEntity orderEntity = orderDao.findByUserIDAndOrderStatus(userID, false);
		System.out.println(orderEntity);
		orderEntity.setOrderStatus(true);
		orderDao.save(orderEntity);

	}


	/*
	 * View Previous Orders
	 * As a User, I should be able to view a list of all my previous orders and access the details of each order.
	 * 1. Check for checkedout orders 
	 */
	@Override
	public List<OrderPojo> findPreviousOrdersById(Integer userID) {

		List<OrderEntity> orderEntity = orderDao.findByUserID(userID);
		List<OrderPojo> fetchedOrderPojo = new ArrayList<OrderPojo>();


		orderEntity.forEach((eachEntity)->{

			OrderPojo orderPojo = new OrderPojo();
			orderPojo.setOrderDate(date);
			BeanUtils.copyProperties(eachEntity, orderPojo);


			List<OrderItemPojo> fetchedOrderItemPojo = new ArrayList<OrderItemPojo>();
			eachEntity.getOrderItems().forEach((eachItemEntity) -> {
				OrderItemPojo itemPojo = new OrderItemPojo();
				BeanUtils.copyProperties(eachItemEntity, itemPojo);
				fetchedOrderItemPojo.add(itemPojo);
			});
			
			// Check if it is a previously checked out order
			if(orderPojo.getOrderStatus() != false) {
				orderPojo.setOrderItems(fetchedOrderItemPojo);
				fetchedOrderPojo.add(orderPojo);	
			}
		});


		return fetchedOrderPojo;

	}


	/*
	 * User Profile
	 * As a User, I should be able to create and maintain a profile page.
	 */
	@Override
	public UserPojo findUserProfile(UserPojo userPojo) {
		Optional<UserEntity> optionalUserEntity = userDao.findById(userPojo.getUserID());
		if (optionalUserEntity.isPresent()) {
			BeanUtils.copyProperties(optionalUserEntity.get(), userPojo);
		}
		return userPojo;
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

		newProduct.setProductSku(newProductEntity.getProductSku());
		return newProduct;
	}

	/*
	 * [Optional]  Remove Items from Cart
	 *  As a [User|Admin], I should be able to remove items from my cart within the Cart View.
	 */
	@Override
	public void deleteProduct(int productSku) {
		productDao.deleteById(productSku);

	}



}
