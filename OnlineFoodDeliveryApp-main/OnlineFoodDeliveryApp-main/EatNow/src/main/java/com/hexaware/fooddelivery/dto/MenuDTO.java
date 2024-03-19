package com.hexaware.fooddelivery.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
/*
 * 
 * @Author:Karthik
 * Date:7-11-2023
 * Description:  class of MenuDTO
 * 
 * 
 */
public class MenuDTO {

	private int menuItemId;
	
	@Min(value = 200, message = "restaurantId must be greater than or equal to 200")
	private int restaurantId;
	
	@Pattern(regexp = "[a-zA-Z]{2,10}",message = "item name minimum of size 2")
	private String itemName;
	
	private String description;
	
    @Min(value = 1, message = "Price must be greater than or equal to 1")
	private double price;
   
	public MenuDTO() {
		super();
	}
	
	public MenuDTO(int menuItemId, int restaurantId, String itemName, String description, double price) {
		super();
		this.menuItemId = menuItemId;
		this.restaurantId = restaurantId;
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

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

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
