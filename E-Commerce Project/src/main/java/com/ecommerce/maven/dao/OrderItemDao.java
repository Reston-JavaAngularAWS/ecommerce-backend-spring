package com.ecommerce.maven.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.maven.entity.OrderItemEntity;

public interface OrderItemDao extends JpaRepository<OrderItemEntity, Integer> {
	
}
