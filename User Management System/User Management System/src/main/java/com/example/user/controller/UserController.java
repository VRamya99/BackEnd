package com.example.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.entity.UserEntity;
import com.example.user.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	private UserService userService;
	public UserController(UserService userService)
	{
		this.userService=userService;
	}
	@PostMapping("/users")
	public ResponseEntity<String> createUser(@RequestBody UserEntity user)
	{
		return new ResponseEntity<String>(userService.createUser(user),HttpStatus.CREATED);
	}
	@PutMapping("/users/{id}")
	public ResponseEntity<String> updateUser(@PathVariable("id") int id,@RequestBody(required = false) UserEntity user)
	{
		return new ResponseEntity<String>(userService.updateUser(id,user),HttpStatus.OK);
	}
	@GetMapping("/users/{id}")
	public ResponseEntity<UserEntity> getUser(@PathVariable("id") int id)
	{
		return new ResponseEntity<UserEntity>(userService.getUser(id),HttpStatus.OK);
	}

}
