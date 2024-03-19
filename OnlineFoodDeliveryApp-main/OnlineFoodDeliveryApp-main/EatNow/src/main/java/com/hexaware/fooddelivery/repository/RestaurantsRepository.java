package com.hexaware.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.fooddelivery.entity.Restaurants;
/*
 * 
 * @Author:Karthik 
 * Date:10-11-2023
 * Description:  class of RestaurantsRepository
 * 
 * 
 */
public interface RestaurantsRepository extends JpaRepository<Restaurants, Integer>{
	Restaurants findByRestaurantName(String restaurantName);
}
