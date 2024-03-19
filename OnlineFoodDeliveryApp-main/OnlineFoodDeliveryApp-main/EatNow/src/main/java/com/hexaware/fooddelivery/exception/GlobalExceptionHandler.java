package com.hexaware.fooddelivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/*
 * 
 * @Author:Karthik
 * Date:15-11-2023
 * 
 * 
 * 
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler({AdminNotFoundException.class,
		CartIdNotFoundException.class,
		CustomerNotFoundException.class,
		MenuNotFoundException.class,
		OrderNotFoundException.class,
		RestaurantNotFoundException.class
		})
	public ResponseEntity<String> handleAnyExp(Exception e) {
		
		return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
	}
}
