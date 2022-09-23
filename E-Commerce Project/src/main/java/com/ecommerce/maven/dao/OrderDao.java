package com.ecommerce.maven.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.maven.entity.OrderEntity;
import com.ecommerce.maven.entity.OrderItemEntity;
@Repository
public interface OrderDao extends JpaRepository<OrderEntity,  Integer> {

//	List<OrderItemEntity> findByOrderNo();
	
	// To map order to user ID
	List<OrderEntity> findByUserID(int userID);


}
