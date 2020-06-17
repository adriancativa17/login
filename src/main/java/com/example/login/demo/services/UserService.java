package com.example.login.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.login.demo.converter.UserConverter;
import com.example.login.demo.dto.ErrorDTO;
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
	
	public ResponseEntity<Object> getUser(String username, String password){
		try {
			UserEntity entity = userRepository.findOneByUserName(username);
			if(entity != null) {
				if(entity.getPassword().equals(password)) {
					UserDTO dto = userConverter.entityToDTO(entity);
					return new ResponseEntity<Object>(dto, HttpStatus.OK); 
				}
				else {
					return new ResponseEntity<Object>(new ErrorDTO("Contraseña incorrecta", 13), HttpStatus.BAD_REQUEST);
				}
			}
			else {
				return new ResponseEntity<Object>(new ErrorDTO("Usuario incorrecto", 12), HttpStatus.BAD_REQUEST);
			}
		}
		catch (Exception e) {
			return new ResponseEntity<Object>(new ErrorDTO("Ocurrio un error: "+e.getMessage(), 14), HttpStatus.BAD_REQUEST);
		}
	}
}
