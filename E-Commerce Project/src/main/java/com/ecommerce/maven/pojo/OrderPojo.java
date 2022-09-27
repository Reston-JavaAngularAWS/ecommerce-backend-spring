package com.ecommerce.maven.pojo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.ecommerce.maven.entity.ProductEntity;

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
	private LocalDateTime orderDate = LocalDateTime.now();

	@NotNull
	private Boolean orderStatus;

	@NotNull
	private List<OrderItemPojo> orderItems = new ArrayList<OrderItemPojo>();

	@NotNull
	List<ProductEntity> allProducts;

}
