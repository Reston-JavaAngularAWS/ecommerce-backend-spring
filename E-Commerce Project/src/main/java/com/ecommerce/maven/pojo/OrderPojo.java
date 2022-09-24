package com.ecommerce.maven.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	
	private Integer orderNo;

	private Integer userID;
	

	private LocalDate orderDate;
	

	private Boolean orderStatus;
	

	private List<OrderItemPojo> orderItems = new ArrayList<OrderItemPojo>();
	
	
	private List<ProductPojo> allProducts;
	
}
