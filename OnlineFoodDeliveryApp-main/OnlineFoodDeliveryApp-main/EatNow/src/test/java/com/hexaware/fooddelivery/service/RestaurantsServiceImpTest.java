package com.hexaware.fooddelivery.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hexaware.fooddelivery.dto.RestaurantsDTO;
import com.hexaware.fooddelivery.entity.Restaurants;

class RestaurantsServiceImpTest {

	@Test
	void testAddRestaurants() {
		Restaurants restaurants=new Restaurants();
		restaurants.setRestaurantId(100);
	    restaurants.setRestaurantName("Abhi");
	    restaurants.setCuisineType("veg");
	    restaurants.setLocation("Ongole");
	    restaurants.setRating(4);
	    assertEquals("Abhi",restaurants.getRestaurantName());
	}

	@Test
	void testGetById() {
RestaurantsDTO restaurantsDTO=new RestaurantsDTO();
		
		restaurantsDTO.setRestaurantId(400);
		restaurantsDTO.setRestaurantName("RK");
		restaurantsDTO.setCuisineType("veg");
		restaurantsDTO.setLocation("ONG");
		restaurantsDTO.setRating(4);
	    assertEquals(400,restaurantsDTO.getRestaurantId());

	}

	

	@Test
	void testUpdateRestaurants() {
		Restaurants restaurants=new Restaurants();
		restaurants.setRestaurantId(100);
	    restaurants.setRestaurantName("Abhi");
	    restaurants.setCuisineType("veg");
	    restaurants.setLocation("Ongole");
	    restaurants.setRating(4);
	    assertEquals("Ongole",restaurants.getLocation());
	}

	

	@Test
	void testGetByRestaurantName() {
		RestaurantsDTO restaurantsDTO=new RestaurantsDTO();

		restaurantsDTO.setRestaurantId(400);
		restaurantsDTO.setRestaurantName("RK");
		restaurantsDTO.setCuisineType("veg");
		restaurantsDTO.setLocation("ONG");
		restaurantsDTO.setRating(4);
	    assertEquals("RK",restaurantsDTO.getRestaurantName());

	}

}
