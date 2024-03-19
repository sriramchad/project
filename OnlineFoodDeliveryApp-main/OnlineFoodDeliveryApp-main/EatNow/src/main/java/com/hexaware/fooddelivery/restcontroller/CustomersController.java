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

import com.hexaware.fooddelivery.dto.CustomersDTO;
import com.hexaware.fooddelivery.entity.Customers;
import com.hexaware.fooddelivery.service.ICustomersService;

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
@RequestMapping("/customers")
public class CustomersController {
	@Autowired
	ICustomersService service;
	
	
	
	@PostMapping("/addCustomers")
	public Customers addCustomers(@Valid @RequestBody  CustomersDTO customersDTO) {
		return service.addCustomers(customersDTO);
	}

	@GetMapping("/getById/{customerId}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")

	public CustomersDTO getById(@PathVariable int customerId) {
		return service.getById(customerId);
	}

	@GetMapping("/getAllCustomers")
	@PreAuthorize("hasAnyAuthority('ADMIN','CUSTOMER')")

	public List<Customers> getAllCustomers() {
		return service.getAllCustomers();
	}

	@PutMapping("/updateCustomers")
	@PreAuthorize("hasAnyAuthority('CUSTOMER','ADMIN')")

	public Customers updateCustomers( @RequestBody CustomersDTO customersDTO) {
		return service.updateCustomers(customersDTO);
	}

	@DeleteMapping("/deleteByCustomers/{customerId}")
	@PreAuthorize("hasAnyAuthority('CUSTOMER','ADMIN')")

	public void deleteById(@PathVariable int customerId) {
		service.deleteById(customerId);
	}

	@GetMapping("/getByCustomer_name/{customerName}")
	@PreAuthorize("hasAnyAuthority('CUSTOMER','ADMIN')")

	public CustomersDTO getByCustomerName(@PathVariable String customerName) {
		
		return service.getByCustomerName(customerName);
	}

}
