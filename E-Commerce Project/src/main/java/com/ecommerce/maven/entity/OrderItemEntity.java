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
@Getter
@Setter
@ToString

@Entity
@Table(name = "order_items")
public class OrderItemEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "items_id")
	private int itemId;
	
	@Column(name = "order_no")
	private int orderNo;
	
	@Column(name = "product_sku")
	private Integer productSku;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_qty")
	private Integer productQty;
	
	@Column(name = "product_price")
	private Double productPrice;
	

	
}
