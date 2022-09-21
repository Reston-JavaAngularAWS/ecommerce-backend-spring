package com.ecommerce.maven.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name = "products")// Name of Table
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "product_sku")
	private int sku;
	
	@Column(name = "product_quantity")
	private int productQuantity;
	
	@Column(name = "product_name")
	private String productName; 
	
	@Column(name = "product_image")
	private String productImage;
	
	@Column(name = "product_price")
	private double productPrice;

}
