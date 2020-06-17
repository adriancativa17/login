package com.example.login.demo.dto;

public class ErrorDTO {

	public String message;
	public Integer errorCode;

	public ErrorDTO(String message, Integer errorCode) {
		this.message = message;
		this.errorCode = errorCode;
	}
	
	
}
