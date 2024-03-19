package com.hexaware.fooddelivery.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fooddelivery.dto.RestaurantsDTO;
import com.hexaware.fooddelivery.entity.Restaurants;
import com.hexaware.fooddelivery.service.IRestaurantsService;

import jakarta.validation.Valid;

/*
 * 
 * @Author:Karthik
 * Date:10-11-2023
 * 
 * 
 * 
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/Restaurants")
public class RestaurantsController {
	
	@Autowired
	private IRestaurantsService service;
	
	public RestaurantsController(IRestaurantsService service) {
		super();
		this.service = service;
	}

	@PostMapping("/addRestaurants")
	@PreAuthorize("hasAnyAuthority('ADMIN')")

	public Restaurants addRestaurants(@Valid @RequestBody RestaurantsDTO restaurantsDTO) {
		return service.addRestaurants(restaurantsDTO);
	}

	@GetMapping("/getById/{restaurantId}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")

	public RestaurantsDTO getById(@PathVariable int restaurantId) {
		return service.getById(restaurantId);
	}

	@GetMapping("/getAllRestaurants")
	@PreAuthorize("hasAnyAuthority('CUSTOMER','ADMIN')")

	public List<Restaurants> getAllRestaurants() {
		return service.getAllRestaurants();
	}

	@PutMapping("/updateRestaurants")
	@PreAuthorize("hasAnyAuthority('ADMIN')")

	public Restaurants updateRestaurants( @RequestBody RestaurantsDTO restaurantsDTO) {
		return service.updateRestaurants(restaurantsDTO);
	}

	@DeleteMapping("/deleteById/{restaurantId}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")

	public void deleteById(@PathVariable int restaurantId) {
		service.deleteById(restaurantId);
	}
	@GetMapping("/getByRestaurantName/{restaurantName}")
	@PreAuthorize("hasAnyAuthority('CUSTOMER','ADMIN')")

	public RestaurantsDTO getByRestaurantName(@PathVariable String restaurantName) {
		
		return service.getByRestaurantName(restaurantName);
	}
	
}
