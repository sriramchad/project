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

import com.hexaware.fooddelivery.dto.MenuDTO;
import com.hexaware.fooddelivery.entity.Menu;
import com.hexaware.fooddelivery.service.IMenuService;

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
@RequestMapping("/Menu")
public class MenuController {
	
	@Autowired
	IMenuService service;
	@PostMapping("/addMenu")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public Menu addMenu(@Valid @RequestBody  MenuDTO menuDTO) {
		return service.addMenu(menuDTO);
	}

	@GetMapping("/getById/{menuItemId}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public MenuDTO getById( @PathVariable int menuItemId) {
		return service.getById(menuItemId);
	}

	@GetMapping("/getAllMenu")
	@PreAuthorize("hasAnyAuthority('CUSTOMER','ADMIN')")

	public List<Menu> getAllMenu() {
		return service.getAllMenu();
	}

	@PutMapping("/updateMenu")
	@PreAuthorize("hasAnyAuthority('ADMIN')")

	public Menu updateMenu( @RequestBody  MenuDTO menuDTO) {
		return service.updateMenu(menuDTO);
	}

	@DeleteMapping("/deleteById/{menuItemId}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")

	public void deleteById(@PathVariable int menuItemId) {
		service.deleteById(menuItemId);
	}
	@GetMapping("/getByItemName/{itemName}")
	@PreAuthorize("hasAnyAuthority('CUSTOMER','ADMIN')")

	public MenuDTO getByItemName(@PathVariable String itemName) {
		return service.getByItemName(itemName);
		
	}
	
	@GetMapping("/getByRestaurantId/{restaurantId}")
	@PreAuthorize("hasAnyAuthority('CUSTOMER','ADMIN')")
	public List<MenuDTO> getByRestaurantId( @PathVariable int restaurantId) {
		return service.getByRestaurantId(restaurantId);
	}
}
