package com.ecommerce.maven.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.maven.pojo.UserPojo;
import com.ecommerce.maven.service.EcommService;

@CrossOrigin
@RestController
@RequestMapping("api/user")	//http://localhost:8080/api/user
public class UserController {
	
	@Autowired
	EcommService service;
	
	// Login 
	@GetMapping("login")
	public UserPojo findByUsernameAndPassword(@Valid @RequestBody UserPojo userPojo){
		return service.findByUsernameAndPassword(userPojo);
		
	}
	
	// User Profile
	@GetMapping("profile")
	public UserPojo findByID(@Valid @RequestBody UserPojo userPojo){
		return service.findUserProfile(userPojo);
		
	}
	
	// Register User
	@PostMapping("register")
	public UserPojo registerUser(@Valid @RequestBody UserPojo newUser){
		return service.registerUser(newUser);
	}
	

}
