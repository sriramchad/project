package com.hexaware.fooddelivery.dto;


import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
/*
 * 
 * @Author:Karthik 
 * Date:7-11-2023
 * Description:  class of RestaurantsDTO
 * 
 * 
 */
public class RestaurantsDTO {

	private int restaurantId ;
	
	@Pattern(regexp = "[a-zA-Z]{2,50}",message = "restaurantName minimum of size 2")

	private String restaurantName ;
	@Pattern(regexp = "[a-zA-Z]{2,50}",message = "cuisineType minimum of size 2")

    private String cuisineType;
	@NotBlank(message = "mention location")
    private String location;
	@Min(value=0,message = "give some rating")
    private double rating;
    
	
	
//	private List<Integer> customerIds;
//
//	public List<Integer> getCustomerIds() {
//		return customerIds;
//	}
//
//	public void setCustomerIds(List<Integer> customerIds) {
//		this.customerIds = customerIds;
//	}
//	
//	
//	
//	
//	
//	private int menuItemId;
//
//	public int getMenuItemId() {
//		return menuItemId;
//	}
//
//	public void setMenuItemId(int menuItemId) {
//		this.menuItemId = menuItemId;
//	}
//	
//	
//	
	
   
	public RestaurantsDTO() {
		super();
	}
	public RestaurantsDTO(int restaurantId, String restaurantName, String cuisineType, String location, double rating) {
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