package com.hexaware.fooddelivery.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
/*
 * 
 * @Author:Vikas 
 * Date:7-11-2023
 * Description:  class of AdminDTO
 * 
 * 
 */
public class AdminDTO {
	
	
	
	
	private int adminId;
	@NotBlank(message="Username should not be blank")
	@Size(min=2,max=20,message="Username should be between 8-20 characters")
	private String userName;
	@NotBlank(message = "Password should not be blank")
    @Size(min=4,message="Password must be at least 6 characters long")
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{6,}$")
	private String password;
	
	
	public AdminDTO() {
		super();
	}


	public AdminDTO(int adminId,
			 String userName,
		 String password) {
		super();
		this.adminId = adminId;
		this.userName = userName;
		this.password = password;
	}


	public int getAdminId() {
		return adminId;
	}


	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}