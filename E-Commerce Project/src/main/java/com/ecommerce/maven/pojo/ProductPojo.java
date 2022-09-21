package com.ecommerce.maven.pojo;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
// use this constructor for order items
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode


public class ProductPojo {
	
	@NotNull
	private Integer sku, productQuantity;
	@NotNull
	private String productName, productImage;
	@NotNull
	private Double productPrice;
	

}

