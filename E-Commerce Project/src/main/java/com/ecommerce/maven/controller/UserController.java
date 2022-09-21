package com.ecommerce.maven.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.maven.pojo.UserPojo;
import com.ecommerce.maven.service.EcommService;

@RestController
@RequestMapping("api/user")
public class UserController {
	
	@Autowired
	EcommService service;
	
	// Register User
	@PostMapping("")
	public UserPojo registerUser(@Valid @RequestBody UserPojo newUser){
		return service.registerUser(newUser);
	}
	
	// Login
	@GetMapping("/{username}/{password}")
	public UserPojo findByUsernameAndPassword(@PathVariable("username") String username, @PathVariable("password") String password){
		
		return service.findByUsernameAndPassword(username, password);
		
	}

}
