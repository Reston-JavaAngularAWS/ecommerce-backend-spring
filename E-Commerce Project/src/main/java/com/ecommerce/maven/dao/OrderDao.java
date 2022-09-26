package com.ecommerce.maven.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.maven.entity.OrderEntity;
@Repository
public interface OrderDao extends JpaRepository<OrderEntity,  Integer> {
	
	// Find an Order by UserID

	List<OrderEntity> findByUserID(Integer userId);
	
	OrderEntity findByUserIDAndOrderStatus(Integer userId, Boolean orderStatus);

}
