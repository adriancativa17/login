package com.example.login.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.demo.dto.UserDTO;
import com.example.login.demo.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody() UserDTO dto){
		return userService.createUser(dto);
	}
	
	@GetMapping("/users")
	public ResponseEntity<Object> getUser(@RequestParam("username") String username, @RequestParam("password") String password){
		return userService.getUser(username, password);
	}
}
