package com.ecommerce.maven.service;

import java.time.LocalDate;
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
import com.ecommerce.maven.entity.ProductEntity;
import com.ecommerce.maven.entity.UserEntity;
import com.ecommerce.maven.pojo.OrderItemPojo;
import com.ecommerce.maven.pojo.OrderPojo;
import com.ecommerce.maven.pojo.ProductPojo;
import com.ecommerce.maven.pojo.UserPojo;

@Service
public class EcommServiceImpl implements EcommService {

	LocalDate date = LocalDate.now();

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
	public OrderPojo updateCart(OrderPojo orderPojo) {
		
		OrderEntity insertOrderEntity = new OrderEntity();
		BeanUtils.copyProperties(insertOrderEntity, orderPojo);

		List<ProductPojo> allProductsPojo = new ArrayList<ProductPojo>();
		
		orderPojo.getAllProducts().forEach((eachProductEntity) ->{
			ProductPojo insertProductPojo = new ProductPojo();
			BeanUtils.copyProperties(eachProductEntity, insertProductPojo);
			allProductsPojo.add(insertProductPojo);
		});
		
		orderPojo.setAllProducts(allProductsPojo);
		return orderPojo;

	}


	/*
	 * CheckOut
	 * As a User or Guest, I should be able to checkout with the items in my cart, purchase them and remove them from the inventory.
	 */
	@Override
	public OrderPojo checkOut(OrderPojo orderPojo) {
		
		OrderPojo newCompleteOrder = new OrderPojo();
		newCompleteOrder.setUserID(orderPojo.getUserID());
		newCompleteOrder.setOrderDate(date);
		newCompleteOrder.setOrderStatus(true);
		
	
		return orderPojo;
	}


	/*
	 * View Previous Orders
	 * As a User, I should be able to view a list of all my previous orders and access the details of each order.
	 */
	@Override
	public List<OrderPojo> findPreviousOrdersById(int userId) {

		List<OrderEntity> orderEntity = orderDao.findByUserID(userId);
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

			orderPojo.setOrderItems(fetchedOrderItemPojo);
			fetchedOrderPojo.add(orderPojo);
		});

		return fetchedOrderPojo;

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
	
	/*
	 * [Optional]  Remove Items from Cart
	 *  As a [User|Admin], I should be able to remove items from my cart within the Cart View.
	 */
	@Override
	public void deleteProduct(int sku) {
		
		productDao.deleteById(sku);
		
	}
	
	


}
