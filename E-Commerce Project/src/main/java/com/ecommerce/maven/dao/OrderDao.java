package com.ecommerce.maven.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.maven.entity.OrderEntity;

@Repository
public interface OrderDao extends JpaRepository<OrderEntity,  Integer> {
	

}
