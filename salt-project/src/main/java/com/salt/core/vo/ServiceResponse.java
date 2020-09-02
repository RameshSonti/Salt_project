package com.salt.core.vo;

import lombok.Data;

@Data
public class ServiceResponse<T> {

	private String errorCode;
	private String errorMessage;
	private T data;
	
	
}
