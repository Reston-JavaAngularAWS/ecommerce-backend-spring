package com.ecommerce.maven.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.maven.service.EcommService;

@CrossOrigin
@RestController
@RequestMapping("api/orderitem") //http://localhost:8080/api/orderitem
public class OrderItemController {
	
	@Autowired
	EcommService service;
	
}

