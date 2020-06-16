package com.example.login.demo.converter;

import com.example.login.demo.dto.UserDTO;
import com.example.login.demo.entities.UserEntity;

public class UserConverter {

	public UserEntity dtoToEntity(UserDTO dto) {
		UserEntity entity = new UserEntity();
		entity.setUserName(dto.username);
		entity.setPassword(dto.password);
		entity.setStatus(dto.status);
		return entity;
	}
}
