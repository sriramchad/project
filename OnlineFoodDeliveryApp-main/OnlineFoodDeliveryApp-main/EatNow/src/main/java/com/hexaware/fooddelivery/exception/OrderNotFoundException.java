package com.hexaware.fooddelivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class OrderNotFoundException extends ResponseStatusException{
	/**
	 * @Author:Karthik
 * Date:15-11-2023
	 */
	private static final long serialVersionUID = 1L;

	public OrderNotFoundException(HttpStatus status,String msg) {
		super(status,msg); }

}
