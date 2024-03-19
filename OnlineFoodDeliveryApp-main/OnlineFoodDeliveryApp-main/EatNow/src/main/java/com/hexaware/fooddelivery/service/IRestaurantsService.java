package com.hexaware.fooddelivery.service;

import java.util.List;

import com.hexaware.fooddelivery.dto.RestaurantsDTO;
import com.hexaware.fooddelivery.entity.Restaurants;
/*
 * 
 * @Author:Karthik
 * Date:10-11-2023
 * Description:  interface of IRestaurantsService
 * 
 * 
 */
public interface IRestaurantsService {
	public Restaurants addRestaurants(RestaurantsDTO restaurantsDTO);
	public RestaurantsDTO getById(int restaurantId);
	public List<Restaurants> getAllRestaurants();
	Restaurants updateRestaurants(RestaurantsDTO restaurantsDTO);
	void deleteById(int restaurantId);
	
	
	
	RestaurantsDTO getByRestaurantName(String restaurantName);
}
