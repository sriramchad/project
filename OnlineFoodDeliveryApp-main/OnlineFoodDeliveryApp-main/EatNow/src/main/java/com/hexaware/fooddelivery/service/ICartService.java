package com.hexaware.fooddelivery.service;

import java.util.List;

import com.hexaware.fooddelivery.dto.CartDTO;
import com.hexaware.fooddelivery.entity.Cart;

/*
 * 
 * @Author:Vikas
 * Date:10-11-2023
 * Description:  interface of ICartService
 * 
 * 
 */

public interface ICartService {
	
	
	public Cart addCart(CartDTO cartDTO);
	public CartDTO getById(int cartId);
	public List<Cart> getAllCart();
	Cart updateCart(CartDTO cartDTO);
	void deleteById(int cartId);
	public List<CartDTO> getByCustomerId(int customerId);
}
