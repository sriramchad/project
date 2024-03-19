package com.hexaware.fooddelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hexaware.fooddelivery.entity.Menu;
/*
 * 
 * @Author:Karthik 
 * Date:10-11-2023
 * Description:  interface of MenuRepository
 * 
 * 
 */
public interface MenuRepository extends JpaRepository<Menu, Integer>{
	Menu findByItemName(String itemName);
	 @Query("FROM Menu m WHERE m.restaurants.restaurantId = :restaurantId")
	    List<Menu> findMenuByRestaurantId(@Param("restaurantId") int restaurantId);
}
