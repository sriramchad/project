package com.hexaware.fooddelivery.dto;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
/*
 * 
 * @Author:Vikas 
 * Date:7-11-2023
 * Description:  class of CartDTO
 * 
 * 
 */
public class CartDTO {

	private int cartId;
	@Min(value = 100,message = "customerId must greater than 100")
	private int customerId;
	@Min(value = 200,message = "restaurantId must greater than 200")
	private int restaurantId;

	@Min(value = 1,message = "price must greater than 1")
	private double price;
	@Min(value = 1,message = "quantity must greater than 1")
	private int quantity;
	@Min(value = 1,message = "total must greater than 1")
	private double total;

	
	@NotEmpty(message = "menuIds list cannot be empty")
    private List<Integer> menuIds;

	public List<Integer> getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(List<Integer> menuIds) {
		this.menuIds = menuIds;
	}

	
	
	public CartDTO() {
		super();
	}

	public CartDTO(int cartId, int customerId, int restaurantId, 
			double price, int quantity, double total
			) {
		super();
		this.cartId = cartId;
		this.customerId = customerId;
		this.restaurantId = restaurantId;
		this.price = price;
		this.quantity = quantity;
		this.total = total;
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



	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}


	

	
	
}
