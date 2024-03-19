package com.hexaware.fooddelivery.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
/*
 * 
 * @Author:Karthik
 * Date:7-11-2023
 * Description:  class of OrdersDTO
 * 
 * 
 */
public class OrdersDTO {

	private int cartId;
	@Min(value = 100,message = "customerId must greater than 100")
	private int customerId;
	@Min(value = 200,message = "restaurantId must greater than 200")
	private int restaurantId;
	@Pattern(regexp = "[a-zA-Z0-9]{2,50}",message = "address minimum of size 2")
	private String deliveryAddress;
	@NotBlank(message = "need to mention paymentMethod")
	private String paymentMethod;
	@Min(value = 1,message = "totalAmount must greater than 1")
	
	
	
	
	
	
	
	
	private double totalAmount;
	public OrdersDTO() {
		super();
	}
	public OrdersDTO(int cartId, int customerId, int restaurantId, String deliveryAddress, String paymentMethod,
			double totalAmount) {
		super();
		this.cartId = cartId;
		this.customerId = customerId;
		this.restaurantId = restaurantId;
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
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
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