package com.hexaware.fooddelivery.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

/*
 * 
 * @Author:Karthik
 * Date:7-11-2023
 * Description: Entity class of Orders
 * 
 * 
 */
@Entity
public class Orders {
	@Id
	@SequenceGenerator(name = "Orders_seq", initialValue = 300, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Orders_seq")
	private int cartId;
//	private int customerId;
//	private int restaurantId;
	private String deliveryAddress;
	private String paymentMethod;
	private double totalAmount;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
    private Customers customer;

	public Customers getCustomer() {
		return customer;
	}
	public void setCustomer(Customers customer) {
		this.customer = customer;
	}
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Restaurants restaurants;
	
	public Restaurants getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(Restaurants restaurants) {
		this.restaurants = restaurants;
	}
	
	
	
	
	public Orders() {
		super();
	}
	public Orders(int cartId,
//			int customerId, int restaurantId,
			String deliveryAddress, String paymentMethod,
			double totalAmount) {
		super();
		this.cartId = cartId;
//		this.customerId = customerId;
//		this.restaurantId = restaurantId;
		this.deliveryAddress = deliveryAddress;
		this.paymentMethod = paymentMethod;
		this.totalAmount = totalAmount;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
//	public int getCustomerId() {
//		return customerId;
//	}
//	public void setCustomerId(int customerId) {
//		this.customerId = customerId;
//	}
//	public int getRestaurantId() {
//		return restaurantId;
//	}
//	public void setRestaurantId(int restaurantId) {
//		this.restaurantId = restaurantId;
//	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	

}