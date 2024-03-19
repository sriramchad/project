package com.hexaware.fooddelivery.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
/*
 * 
 * @Author:Karthik
 * Date:7-11-2023
 * Description: Entity class of Restaurants
 * 
 * 
 */
@Entity
public class Restaurants {
	@Id
	@SequenceGenerator(name = "Restaurants_seq", initialValue = 400, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Restaurants_seq")
	private int restaurantId;
	private String restaurantName;
    private String cuisineType;
    private String location;
    private double rating;
    
    
//    @OneToOne(mappedBy = "restaurants", cascade = CascadeType.PERSIST)
//    private Menu menu;
//    public Menu getMenu() {
//		return menu;
//	}
//	public void setMenu(Menu menu) {
//		this.menu = menu;
//	}
//    
    
    
//    @ManyToMany
//    @JoinTable(
//        name = "restaurant_customer")
//    private List<Customers> customers;
//    
//    public List<Customers> getCustomers() {
//		return customers;
//	}
//	public void setCustomers(List<Customers> customers) {
//		this.customers = customers;
//	}
//	
	
	
//	@OneToOne(cascade = CascadeType.ALL)
//	private Menu menu;
//
//
//	public Menu getMenu() {
//		return menu;
//	}
//
//	public void setMenu(Menu menu) {
//		this.menu = menu;
//	}

	
	
	public Restaurants() {
		super();
	}
	public Restaurants(int restaurantId, String restaurantName, String cuisineType, String location, double rating) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.cuisineType = cuisineType;
		this.location = location;
		this.rating = rating;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
    
    
 
	
}