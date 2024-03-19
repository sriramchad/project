package com.hexaware.fooddelivery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

/*
 * 
 * @Author:Vikas 
 * Date:7-11-2023
 * Description: Entity class of Customers
 * 
 * 
 */
@Entity
public class Customers {
	@Id
	@SequenceGenerator(name = "Customers_seq", initialValue = 100, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Customers_seq")
	private int customerId;
	
	private String customerName;
	private String email;
	private String phoneNumber;
	private String deliveryAddress;
	private String password;
	private final String role="CUSTOMER";
	

//	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private List<Orders> orders;
	

	public Customers() {
		super();
	}


	public Customers(int customerId, String customerName, String email, String phoneNumber, String deliveryAddress,
			String password) { //List<Orders> orders) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.deliveryAddress = deliveryAddress;
		this.password = password;
		//this.orders = orders;
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


//	public List<Orders> getOrders() {
//		return orders;
//	}
//
//
//	public void setOrders(List<Orders> orders) {
//		this.orders = orders;
//	}


	public String getRole() {
		return role;
	}

	
	
}
