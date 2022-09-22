package com.ecommerce.maven.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.maven.pojo.OrderItemPojo;
import com.ecommerce.maven.service.EcommService;

@CrossOrigin
@RestController
@RequestMapping("api/orderitem")
public class OrderItemController {
	
	@Autowired
	EcommService service;
	
	@GetMapping("")
	public List<OrderItemPojo> getAllOrderItems(){
		return service.getAllOrderItems();
	}
	
	@GetMapping("/{orderNo}")
	public OrderItemPojo getAOrderItem(@PathVariable("orderNo") int orderNo) {
		return service.getAOrderItem(orderNo);
	}

}

