package com.ecommerce.maven.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.maven.entity.OrderItemEntity;

@Repository
public interface OrderItemDao extends JpaRepository<OrderItemEntity, Integer> {
	
}
