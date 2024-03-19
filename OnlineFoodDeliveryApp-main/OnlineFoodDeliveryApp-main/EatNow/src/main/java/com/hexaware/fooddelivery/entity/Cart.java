package com.hexaware.fooddelivery.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
/*
 * 
 * @Author:Vikas 
 * Date:7-11-2023
 * Description: Entity class of Cart
 * 
 * 
 */
@Entity
public class Cart {
	
	@Id
	@SequenceGenerator(name = "Cart_seq", initialValue = 10, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Cart_seq")
	private int cartId;
	
//	private int customerId;
//	private int restaurantId;
//	private int itemId;
	private double price;
	private int quantity;
	private double total;
//	private int orderId;
	
	
	
	
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Customers customers;
	
	public Customers getCustomers() {
		return customers;
	}
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Restaurants restaurants;
	
	public Restaurants getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(Restaurants restaurants) {
		this.restaurants = restaurants;
	}
	
	
	
	
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
	        name = "cart_menu",
	        joinColumns = @JoinColumn(name = "cart_id"),
	        inverseJoinColumns = @JoinColumn(name = "menu_id")
	    )
	private List<Menu> menu;

	
	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}

	
	
	
	public Cart() {
		super();
	}

	public Cart(int cartId, 
			double price, int quantity, double total
			) {
		super();
		this.cartId = cartId;

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
