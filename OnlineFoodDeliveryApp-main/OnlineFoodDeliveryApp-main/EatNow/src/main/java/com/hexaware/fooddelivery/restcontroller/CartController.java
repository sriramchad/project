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

import com.hexaware.fooddelivery.dto.CartDTO;
import com.hexaware.fooddelivery.dto.MenuDTO;
import com.hexaware.fooddelivery.entity.Cart;
import com.hexaware.fooddelivery.service.ICartService;

import jakarta.validation.Valid;
/*
 * 
 * @Author:Vikas
 * Date:10-11-2023
 * 
 * 
 * 
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	ICartService service;
	
	
	@PostMapping("/addCart")
	@PreAuthorize("hasAnyAuthority('CUSTOMER','ADMIN')")

	public Cart addCart(@Valid @RequestBody  CartDTO cartDTO) {
		return service.addCart(cartDTO);
	}

	@GetMapping("/getById/{cartId}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")

	public CartDTO getById(@PathVariable int cartId) {
		return service.getById(cartId);
	}

	@GetMapping("/getAllCart")
	@PreAuthorize("hasAnyAuthority('CUSTOMER','ADMIN')")

	public List<Cart> getAllCart() {
		return service.getAllCart();
	}
	
	@PutMapping("/updateCart")
	@PreAuthorize("hasAnyAuthority('CUSTOMER','ADMIN')")

	public Cart updateCart( @RequestBody  CartDTO cartDTO) {
		return service.updateCart(cartDTO);
	}

	@DeleteMapping("/deleteById/{cartId}")
	@PreAuthorize("hasAnyAuthority('CUSTOMER','ADMIN')")

	public void deleteById(@PathVariable int cartId) {
		service.deleteById(cartId);
	}
	
	@GetMapping("/getByCustomerId/{customerId}")
	@PreAuthorize("hasAnyAuthority('CUSTOMER','ADMIN')")
	public List<CartDTO> getByCustomerId( @PathVariable int customerId) {
		return service.getByCustomerId(customerId);
	}

}
