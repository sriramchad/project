package com.hexaware.fooddelivery.entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
/*
 * 
 * @Author:Karthik 
 * Date:7-11-2023
 * Description: Entity class of Menu
 * 
 * 
 */
@Entity
public class Menu {
	@Id
	@SequenceGenerator(name = "Menu_seq", initialValue = 200, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Menu_seq")
	private int menuItemId;
	
//	private int restaurantId;
	private String itemName;
	private String description;
	private double price;
	
	
    @OneToOne(cascade = CascadeType.PERSIST)
	private Restaurants restaurants;
	
	public Restaurants getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(Restaurants restaurants) {
		this.restaurants = restaurants;
	}

	public Menu() {
		super();
	}
	
	public Menu(int menuItemId, String itemName, String description, double price) {
		super();
		this.menuItemId = menuItemId;
//		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		
	}

	public int getMenuItemId() {
		return menuItemId;
	}

	public void setMenuItemId(int menuItemId) {
		this.menuItemId = menuItemId;
	}

//	public int getRestaurantId() {
//		return restaurantId;
//	}
//
//	public void setRestaurantId(int restaurantId) {
//		this.restaurantId = restaurantId;
//	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}



	
	
	
}
