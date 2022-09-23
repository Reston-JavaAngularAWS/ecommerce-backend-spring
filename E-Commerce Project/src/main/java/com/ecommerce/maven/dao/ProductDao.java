package com.ecommerce.maven.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.maven.entity.ProductEntity;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity, Integer> {
	
	// Find order by Sku
	List<ProductEntity> findBySku(int sku);


}
