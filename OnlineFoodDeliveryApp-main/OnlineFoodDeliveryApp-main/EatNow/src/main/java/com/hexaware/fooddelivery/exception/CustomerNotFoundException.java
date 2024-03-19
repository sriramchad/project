package com.hexaware.fooddelivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CustomerNotFoundException extends ResponseStatusException{
	/**
	 * @Author:Vikas
 * Date:15-11-2023
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(HttpStatus status,String msg) {
		super(status,msg); }
	
}
