package com.hexaware.fooddelivery.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexaware.fooddelivery.dto.MenuDTO;
import com.hexaware.fooddelivery.entity.Menu;
import com.hexaware.fooddelivery.entity.Restaurants;
import com.hexaware.fooddelivery.exception.MenuNotFoundException;
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
public class MenuSeviceImp implements IMenuService {
	@Autowired
	MenuRepository repo;
	@Autowired
	RestaurantsRepository restaurantsrepo;
	
	Logger logger = LoggerFactory.getLogger(MenuSeviceImp.class);

	
	
	@Override
	public Menu addMenu(MenuDTO menuDTO) {
	Restaurants restaurants=  restaurantsrepo.findById(menuDTO.getRestaurantId()).orElse(null);

		Menu menu=new Menu();
		
		
		//menu.setMenuItemId(menuDTO.getMenuItemId());
		//menu.setRestaurantId(menuDTO.getRestaurantId());
		menu.setRestaurants(restaurants);
		menu.setItemName(menuDTO.getItemName());
		menu.setDescription(menuDTO.getDescription());
		menu.setPrice(menuDTO.getPrice());
		logger.info("Added to Menu with id"+menuDTO.getMenuItemId());

		return repo.save(menu);
	}

	@Override
	public MenuDTO getById(int menuItemId) {
		Menu menu =repo.findById(menuItemId).orElse(new Menu());
		
		if(menu.getMenuItemId()==0) {
		  
		  throw new MenuNotFoundException(HttpStatus.NOT_FOUND ,"Menu with menuItemId:"+menuItemId+" notfound");
	}
	
		MenuDTO menuDTO=new MenuDTO();
		
		menuDTO.setMenuItemId(menu.getMenuItemId());
		menuDTO.setRestaurantId(menu.getRestaurants().getRestaurantId());
		menuDTO.setItemName(menu.getItemName());
		menuDTO.setDescription(menu.getDescription());
		menuDTO.setPrice(menu.getPrice());
		
		logger.info("Get  Menu with id"+menu.getMenuItemId());

		return menuDTO;
	}

	@Override
	public List<Menu> getAllMenu() {
		logger.info("Fetched all Menu data");

		return repo.findAll();
	}

	@Override
	public Menu updateMenu(MenuDTO menuDTO) {
		Restaurants restaurants=  restaurantsrepo.findById(menuDTO.getRestaurantId()).orElse(null);

		Menu menu=new Menu();
		
		
		menu.setMenuItemId(menuDTO.getMenuItemId());
//		menu.setRestaurantId(menuDTO.getRestaurantId());
		menu.setRestaurants(restaurants);
		menu.setItemName(menuDTO.getItemName());
		menu.setDescription(menuDTO.getDescription());
		menu.setPrice(menuDTO.getPrice());
		logger.info("Updated to Menu with id"+menuDTO.getMenuItemId());

		
		return repo.save(menu);
		
	}

	@Override
	public void deleteById(int menuItemId) {
	    Menu menu = repo.findById(menuItemId).orElse(null);

	    logger.info("Menu deleted ");

	    if (menu != null) {
	        repo.deleteById(menu.getMenuItemId());
	    }
	}

	@Override
	public MenuDTO getByItemName(String itemName) {
		Menu menu =repo.findByItemName(itemName);
		if(menu==null) {
			  throw new MenuNotFoundException(HttpStatus.NOT_FOUND ,"Menu with MenuItemName:"+itemName+" Notfound");

		}
		
		MenuDTO menuDTO=new MenuDTO();
		
		menuDTO.setMenuItemId(menu.getMenuItemId());
		menuDTO.setRestaurantId(menu.getRestaurants().getRestaurantId());
		menuDTO.setItemName(menu.getItemName());
		menuDTO.setDescription(menu.getDescription());
		menuDTO.setPrice(menu.getPrice());
		logger.info("Get  Menu with name"+menu.getItemName());

		
		
		return menuDTO;
	}

	@Override
	public List<MenuDTO> getByRestaurantId(int restaurantId) {
	    List<Menu> menuList = repo.findMenuByRestaurantId(restaurantId);

	    if (menuList.isEmpty()) {
	        throw new MenuNotFoundException(HttpStatus.NOT_FOUND, "Menus not found for restaurantId: " + restaurantId);
	    }

	    List<MenuDTO> menuDTOList = new ArrayList<>();

	    for (Menu menu : menuList) {
	        MenuDTO menuDTO = new MenuDTO();
	        menuDTO.setMenuItemId(menu.getMenuItemId());
	        menuDTO.setRestaurantId(menu.getRestaurants().getRestaurantId());
	        menuDTO.setItemName(menu.getItemName());
	        menuDTO.setDescription(menu.getDescription());
	        menuDTO.setPrice(menu.getPrice());
	        menuDTOList.add(menuDTO);
	    }

	    logger.info("Get all menus with restaurantId: " + restaurantId);
	    return menuDTOList;
	}


}
