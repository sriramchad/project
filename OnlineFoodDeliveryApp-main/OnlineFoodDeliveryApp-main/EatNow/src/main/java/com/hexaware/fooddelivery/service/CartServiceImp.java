package com.hexaware.fooddelivery.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexaware.fooddelivery.dto.CartDTO;
import com.hexaware.fooddelivery.dto.MenuDTO;
import com.hexaware.fooddelivery.entity.Cart;
import com.hexaware.fooddelivery.entity.Customers;
import com.hexaware.fooddelivery.entity.Menu;
import com.hexaware.fooddelivery.entity.Restaurants;
import com.hexaware.fooddelivery.exception.CartIdNotFoundException;
import com.hexaware.fooddelivery.repository.CartRepository;
import com.hexaware.fooddelivery.repository.CustomersRepository;
import com.hexaware.fooddelivery.repository.MenuRepository;
import com.hexaware.fooddelivery.repository.RestaurantsRepository;
/*
 * 
 * @Author:Vikas
 * Date:10-11-2023
 * 
 * 
 * 
 */
@Service

public class CartServiceImp implements ICartService {

	
	@Autowired
	CartRepository repo;
	@Autowired
    CustomersRepository customersRepository;
	@Autowired
	RestaurantsRepository restaurantRepo;
	@Autowired
	MenuRepository menuRepo;
	
	Logger logger = LoggerFactory.getLogger(CartServiceImp.class);

	
	@Override
	public Cart addCart(CartDTO cartDTO) {
		Customers customers=  customersRepository.findById(cartDTO.getCustomerId()).orElse(null);
		Restaurants restaurant=restaurantRepo.findById(cartDTO.getRestaurantId()).orElse(null);
		List<Menu> menu=menuRepo.findAllById(cartDTO.getMenuIds());


		
		Cart cart =new Cart();
		
		
		cart.setCustomers(customers);
		cart.setRestaurants(restaurant);
		cart.setMenu(menu);

		cart.setPrice(cartDTO.getPrice());
		cart.setQuantity(cartDTO.getQuantity());
		
		cart.setTotal(cartDTO.getTotal());

		
		logger.info("Added to cart with id"+cartDTO.getCartId());

		return repo.save(cart);
	}

	@Override
	public CartDTO getById(int cartId) {
		
		Cart cart =repo.findById(cartId).orElse(new Cart());
		if (cart.getCartId()==0) {
			throw new CartIdNotFoundException(HttpStatus.NOT_FOUND,"Cart with CartId:"+cartId+" notfound");

		}
		
		
		    
	
		CartDTO cartDTO=new CartDTO();
		
        cartDTO.setMenuIds(cart.getMenu().stream().map(Menu::getMenuItemId).collect(Collectors.toList()));
        cartDTO.setCustomerId(cart.getCustomers().getCustomerId());
		cartDTO.setRestaurantId(cart.getRestaurants().getRestaurantId());
		
		
		cartDTO.setCartId(cart.getCartId());
		
		
	

		
		
		cartDTO.setPrice(cart.getPrice());
		cartDTO.setQuantity(cart.getQuantity());
		
		cartDTO.setTotal(cart.getTotal());
		
		
		logger.info("Get  cart with id"+cartDTO.getCartId());
		
		
		return cartDTO;
	}

	@Override
	public List<Cart> getAllCart() {
		logger.info("Fetched all cart data");

		return repo.findAll();
	}

	@Override
	public Cart updateCart(CartDTO cartDTO) {
		Customers customers=  customersRepository.findById(cartDTO.getCustomerId()).orElse(null);
		Restaurants restaurant=restaurantRepo.findById(cartDTO.getRestaurantId()).orElse(null);
		List<Menu> menu=menuRepo.findAllById(cartDTO.getMenuIds());


		Cart cart =new Cart();
		cart.setCustomers(customers);
		cart.setRestaurants(restaurant);
		cart.setMenu(menu);

		
		cart.setCartId(cartDTO.getCartId());
	


		
		cart.setPrice(cartDTO.getPrice());
		cart.setQuantity(cartDTO.getQuantity());
		
		cart.setTotal(cartDTO.getTotal());
		
		logger.info("Updated to cart with id"+cartDTO.getCartId());
		
		return repo.save(cart);
	}

	@Override
	public void deleteById(int cartId) {
	    Cart cart = repo.findById(cartId).orElse(null);

	    

	    if (cart != null) {
	        repo.deleteById(cart.getCartId());
	    }
	    logger.info("Cart deleted");
	}

	@Override
	public List<CartDTO> getByCustomerId(int customerId) {
	    List<Cart> cartList = repo.findCustomerByCustomerId(customerId);
	    List<CartDTO> cartDTOList = new ArrayList<>();

	    for (Cart cart : cartList) {
	        CartDTO cartDTO = new CartDTO();

	        cartDTO.setMenuIds(cart.getMenu().stream().map(Menu::getMenuItemId).collect(Collectors.toList()));
	        cartDTO.setCustomerId(cart.getCustomers().getCustomerId());
	        cartDTO.setRestaurantId(cart.getRestaurants().getRestaurantId());

	        cartDTO.setCartId(cart.getCartId());

	        cartDTO.setPrice(cart.getPrice());
	        cartDTO.setQuantity(cart.getQuantity());

	        cartDTO.setTotal(cart.getTotal());

	        cartDTOList.add(cartDTO);
	    }

	    logger.info("Get all carts for customer with id" + customerId);

	    return cartDTOList;
	}

}
