package com.ecommerce.maven.pojo;



import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode

public class OrderPojo {
	
	private int orderNo;
	
	@NotNull
	private Integer userID;
	@NotNull
	private String orderDate;
	@NotNull
	private String orderStatus;
	
//	// Products for a given order
//	private List<ProductPojo> allProducts;
	
}
