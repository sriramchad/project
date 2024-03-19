package com.hexaware.fooddelivery.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
/*
 * 
 * @Author:Karthik 
 * Date:19-11-2023
 * 
 * 
 * 
 */
public class AuthRequest {
	
	 	@NotBlank(message = "Username is mandatory")
	    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
	    private String username;

	    @NotBlank(message = "Password is mandatory")
	    @Size(min = 6, max = 30, message = "Password must be between 6 and 30 characters")
	    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{6,}$")
	    private String password;

public AuthRequest() {
	super();
}

public AuthRequest(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}

public String getUsername() {
	return username;
}

public String getPassword() {
	return password;
}

public void setUsername(String username) {
	this.username = username;
}

public void setPassword(String password) {
	this.password = password;
}

}

