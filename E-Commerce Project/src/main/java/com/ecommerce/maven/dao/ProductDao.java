package com.ecommerce.maven.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.maven.entity.ProductEntity;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity, Integer> {
	
	// Will work on Product queries here

}
