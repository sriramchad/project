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
import com.hexaware.fooddelivery.dto.OrdersDTO;
import com.hexaware.fooddelivery.entity.Orders;
import com.hexaware.fooddelivery.service.IOrdersService;

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
@RequestMapping("/Orders")
public class OrdersController {
	@Autowired
	IOrdersService service;
	
	@PostMapping("/addOrders")
	@PreAuthorize("hasAnyAuthority('CUSTOMER','ADMIN')")
	public Orders addOrders(@Valid @RequestBody OrdersDTO ordersDTO) {
		return service.addOrders(ordersDTO);
	}

	@GetMapping("/getById/{cartId}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")

	public OrdersDTO getById(@PathVariable int cartId) {
		return service.getById(cartId);
	}

	@GetMapping("/getAllOrders")
	@PreAuthorize("hasAnyAuthority('CUSTOMER','ADMIN')")

	public List<Orders> getAllOrders() {
		return service.getAllOrders();
	}

	@PutMapping("/updateOrders")
	@PreAuthorize("hasAnyAuthority('CUSTOMER','ADMIN')")

	public Orders updateOrders( @RequestBody OrdersDTO ordersDTO) {
		return service.updateOrders(ordersDTO);
	}

	@DeleteMapping("/deleteById/{cartId}")
	@PreAuthorize("hasAnyAuthority('CUSTOMER','ADMIN')")

	public void deleteById(@PathVariable int cartId) {
		service.deleteById(cartId);
	}
	
	@GetMapping("/getByCustomerId/{customerId}")
	@PreAuthorize("hasAnyAuthority('CUSTOMER','ADMIN')")
	public List<OrdersDTO> getByCustomerId( @PathVariable int customerId) {
		System.out.println("ok");
		return service.getByCustomerId(customerId);
	}

}
