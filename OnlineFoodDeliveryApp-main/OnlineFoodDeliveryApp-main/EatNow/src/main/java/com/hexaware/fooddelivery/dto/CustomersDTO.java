package com.hexaware.fooddelivery.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
/*
 * 
 * @Author:Vikas
 * Date:7-11-2023
 * Description:  class of CustomersDTO
 * 
 * 
 */
public class CustomersDTO {

	private int customerId;
	@Pattern(regexp = "[a-zA-Z]{2,10}",message = "customerName minimum of size 2")

	private String customerName;
	@Email(message = "write in email formate")
	
	private String email;
	@Pattern(regexp = "[0-9]{10}",message = "number must be of size 10")

	private String phoneNumber;
	@Pattern(regexp = "[a-zA-Z0-9]{2,50}",message = "address minimum of size 2")

	private String deliveryAddress;
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{6,}$")
	private String password;


	public CustomersDTO() {
		super();
	}


	public CustomersDTO(int customerId,
			String customerName,
		 String email,
		 String phoneNumber,
		 String deliveryAddress,
			String password) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.deliveryAddress = deliveryAddress;
		this.password = password;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getDeliveryAddress() {
		return deliveryAddress;
	}


	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
}
