package com.ecommerce.maven.pojo;

import javax.validation.constraints.NotNull;

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

public class OrderItemPojo {
	
	
	private int itemId, orderNo;
	
	@NotNull
	private String productName;
	@NotNull
	private Integer productSku, productQty;
	@NotNull
	private Double productPrice;
	
	private ProductPojo products;
	

}
