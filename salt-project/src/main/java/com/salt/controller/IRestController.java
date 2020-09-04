package com.salt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.salt.core.vo.ServiceResponse;

public interface IRestController<T> {
	/**
	 * This is generic method to create response entity
	 * 
	 * @param body
	 * @return
	 */
	public default ResponseEntity<ServiceResponse<T>> buildResponse(T body) {

		ServiceResponse<T> serviceResponse = new ServiceResponse<>();
		serviceResponse.setData(body);
		ResponseEntity<ServiceResponse<T>> responseEntity = ResponseEntity.ok(serviceResponse);
		return responseEntity;
	}
}
