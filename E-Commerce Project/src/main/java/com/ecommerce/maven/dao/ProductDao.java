package com.ecommerce.maven.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.maven.entity.ProductEntity;

public interface ProductDao extends JpaRepository<ProductEntity, Integer> {
	
	// Will work on Product queries here

}
