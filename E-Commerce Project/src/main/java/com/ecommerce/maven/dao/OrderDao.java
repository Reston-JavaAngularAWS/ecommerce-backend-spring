package com.ecommerce.maven.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.maven.entity.OrderEntity;

public interface OrderDao extends JpaRepository<OrderEntity,  Integer> {
	

}
