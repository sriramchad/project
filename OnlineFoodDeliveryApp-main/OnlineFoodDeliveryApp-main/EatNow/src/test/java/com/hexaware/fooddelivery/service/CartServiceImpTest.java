package com.hexaware.fooddelivery.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hexaware.fooddelivery.dto.CartDTO;
import com.hexaware.fooddelivery.entity.Cart;

class CartServiceImpTest {

	@Test
	void testAddCart() {
		Cart cart =new Cart();
		cart.setCartId(100);
//		cart.setCustomerId(200);
//		cart.setRestaurantId(300);

//		cart.setItemId(400);
		cart.setPrice(50);
		cart.setQuantity(1);
		
		cart.setTotal(50);
//		cart.setOrderId(500);
		assertEquals(50, cart.getTotal());
	}

	@Test
	void testGetById() {
		CartDTO cartDTO=new CartDTO();
		cartDTO.setCartId(100);
		cartDTO.setCustomerId(200);
		cartDTO.setRestaurantId(300);

//		cartDTO.setItemId(400);
		cartDTO.setPrice(50);
		cartDTO.setQuantity(2);
		
		cartDTO.setTotal(100);
//		cartDTO.setOrderId(400);
		assertEquals(100, cartDTO.getCartId());
	}

	

	@Test
	void testUpdateCart() {
		Cart cart =new Cart();
		cart.setCartId(100);
//		cart.setCustomerId(200);
//		cart.setRestaurantId(300);
//
//		cart.setItemId(400);
		cart.setPrice(50);
		cart.setQuantity(1);
		
		cart.setTotal(50);
//		cart.setOrderId(500);
		assertEquals(50, cart.getTotal());
	}

	

}
