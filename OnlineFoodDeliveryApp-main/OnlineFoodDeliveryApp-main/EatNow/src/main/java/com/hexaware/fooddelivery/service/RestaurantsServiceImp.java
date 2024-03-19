package com.hexaware.fooddelivery.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexaware.fooddelivery.dto.RestaurantsDTO;
import com.hexaware.fooddelivery.entity.Customers;
import com.hexaware.fooddelivery.entity.Menu;
import com.hexaware.fooddelivery.entity.Restaurants;
import com.hexaware.fooddelivery.exception.RestaurantNotFoundException;
import com.hexaware.fooddelivery.repository.CustomersRepository;
import com.hexaware.fooddelivery.repository.MenuRepository;
import com.hexaware.fooddelivery.repository.RestaurantsRepository;
/*
 * 
 * @Author:Karthik
 * Date:10-11-2023
 * 
 * 
 * 
 */
@Service

public class RestaurantsServiceImp implements IRestaurantsService {
	
	@Autowired
	RestaurantsRepository repo;
	@Autowired
	MenuRepository menuRepo;
	@Autowired
    CustomersRepository customersRepository;
	
	
	Logger logger = LoggerFactory.getLogger(RestaurantsServiceImp.class);

	@Override
	public Restaurants addRestaurants(RestaurantsDTO restaurantsDTO) {
		
//		Menu menu=  menuRepo.findById(restaurantsDTO.getMenuItemId()).orElse(null);
//
//        List<Customers> customers = customersRepository.findAllById(restaurantsDTO.getCustomerIds());

		
		
		
		Restaurants restaurants=new Restaurants();
	    
//		restaurants.setCustomers(customers);
		
	    //restaurants.setRestaurantId(restaurantsDTO.getRestaurantId());
	    restaurants.setRestaurantName(restaurantsDTO.getRestaurantName());
	    restaurants.setCuisineType(restaurantsDTO.getCuisineType());
	    restaurants.setLocation(restaurantsDTO.getLocation());
	    restaurants.setRating(restaurantsDTO.getRating());
	    
	   // restaurants.setMenu(menu);
	    
	    
	    
	    
		
		logger.info("Added to Restaurants with id"+restaurantsDTO.getRestaurantId());
		
		return repo.save(restaurants);
	}

	@Override
	public RestaurantsDTO getById(int restaurantId) {
		Restaurants restaurants=repo.findById(restaurantId).orElse(new Restaurants());
		if (restaurants.getRestaurantId()==0) {
			  throw new RestaurantNotFoundException(HttpStatus.NOT_FOUND ,"Restaurant with restaurantId:"+restaurantId+" notfound");

		}
		RestaurantsDTO restaurantsDTO=new RestaurantsDTO();
		
		restaurantsDTO.setRestaurantId(restaurants.getRestaurantId());
		restaurantsDTO.setRestaurantName(restaurants.getRestaurantName());
		restaurantsDTO.setCuisineType(restaurants.getCuisineType());
		restaurantsDTO.setLocation(restaurants.getLocation());
		restaurantsDTO.setRating(restaurants.getRating());
		
		logger.info("Get Restaurants with id"+restaurants.getRestaurantId());

		return restaurantsDTO;
	}

	@Override
	public List<Restaurants> getAllRestaurants() {
		logger.info("Fetched all Restaurants data");

		return repo.findAll();
	}

	@Override
	public Restaurants updateRestaurants(RestaurantsDTO restaurantsDTO) {
		Restaurants restaurants=new Restaurants();
		
		
	    
	    restaurants.setRestaurantId(restaurantsDTO.getRestaurantId());
	    restaurants.setRestaurantName(restaurantsDTO.getRestaurantName());
	    restaurants.setCuisineType(restaurantsDTO.getCuisineType());
	    restaurants.setLocation(restaurantsDTO.getLocation());
	    restaurants.setRating(restaurantsDTO.getRating());
	    
	   
		logger.info("Updated to Restaurants with id"+restaurantsDTO.getRestaurantId());

		return repo.save(restaurants);
	}

	@Override
	public void deleteById(int restaurantId) {
	    Restaurants restaurants = repo.findById(restaurantId).orElse(null);

	    logger.info("Restaurants deleted");

	    if (restaurants != null) {
	        repo.deleteById(restaurants.getRestaurantId());
	    }
	}


	@Override
	public RestaurantsDTO getByRestaurantName(String restaurantName) {
		Restaurants restaurants=repo.findByRestaurantName(restaurantName);
		if(restaurants==null) {
			  throw new RestaurantNotFoundException(HttpStatus.NOT_FOUND ,"Restaurant with RestaurantName:"+restaurantName+" Notfound");

		}
		
		RestaurantsDTO restaurantsDTO=new RestaurantsDTO();
		
		restaurantsDTO.setRestaurantId(restaurants.getRestaurantId());
		restaurantsDTO.setRestaurantName(restaurants.getRestaurantName());
		restaurantsDTO.setCuisineType(restaurants.getCuisineType());
		restaurantsDTO.setLocation(restaurants.getLocation());
		restaurantsDTO.setRating(restaurants.getRating());
		logger.info("Get  Restaurants with name"+restaurants.getRestaurantName());

		
		
		return restaurantsDTO;
		
	}

}
