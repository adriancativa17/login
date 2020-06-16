package com.example.login.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.login.demo.converter.UserConverter;
import com.example.login.demo.dto.UserDTO;
import com.example.login.demo.entities.UserEntity;
import com.example.login.demo.repositories.UserRepository;

@Service
public class UserService {

	private UserConverter userConverter = new UserConverter();
	
	@Autowired
	private UserRepository userRepository;
	
	public ResponseEntity<Object> createUser(UserDTO dto){
		UserEntity entity = userConverter.dtoToEntity(dto);
		userRepository.saveAndFlush(entity);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
