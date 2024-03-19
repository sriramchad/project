package com.hexaware.fooddelivery.service;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.fooddelivery.dto.CustomersDTO;
import com.hexaware.fooddelivery.entity.Customers;
import com.hexaware.fooddelivery.exception.CustomerNotFoundException;
import com.hexaware.fooddelivery.repository.CustomersRepository;
/*
 * 
 * @Author:Vikas
 * Date:10-11-2023
 * 
 * 
 * 
 */
@Service
public class CustomersServiceImp implements ICustomersService {
	
	
	@Autowired
	private CustomersRepository repo;
	private  PasswordEncoder passwordEncoder;	

	public CustomersServiceImp(CustomersRepository repo, PasswordEncoder passwordEncoder) {
		super();
		this.repo = repo;
		this.passwordEncoder = passwordEncoder;
	}

	Logger logger = LoggerFactory.getLogger(CustomersServiceImp.class);

	@Override
	public Customers addCustomers(CustomersDTO customersDTO) {

		Customers customers=new Customers();
       

		//customers.setCustomerId(customersDTO.getCustomerId());
		customers.setCustomerName(customersDTO.getCustomerName());
		customers.setEmail(customersDTO.getEmail());
		customers.setPhoneNumber(customersDTO.getPhoneNumber());
		customers.setDeliveryAddress(customersDTO.getDeliveryAddress());
		customers.setPassword(passwordEncoder.encode(customersDTO.getPassword()));

		
		logger.info("Added to customers with id"+customersDTO.getCustomerId());

		return repo.save(customers);
	}

	@Override
	public CustomersDTO getById(int customerId) {
		
		Customers customers=repo.findById(customerId).orElse(new Customers());
		if (customers.getCustomerId()==0) {
			throw new CustomerNotFoundException(HttpStatus.NOT_FOUND,"Customer with customerId:"+customerId+" notfound");

		}
		
		
		CustomersDTO customersDTO=new CustomersDTO();
		
		customersDTO.setCustomerId(customers.getCustomerId());
		customersDTO.setCustomerName(customers.getCustomerName());
		customersDTO.setEmail(customers.getEmail());
		customersDTO.setPhoneNumber(customers.getPhoneNumber());
		customersDTO.setDeliveryAddress(customers.getDeliveryAddress());
		customersDTO.setPassword(passwordEncoder.encode(customers.getPassword()));

		logger.info("Get  customers with id"+customers.getCustomerId());

		return customersDTO;
	}

	@Override
	public List<Customers> getAllCustomers() {
		logger.info("Fetched all customers data");

		return repo.findAll();
	}

	@Override
	public Customers updateCustomers(CustomersDTO customersDTO) {
		Customers customers=new Customers();
		
		customers.setCustomerId(customersDTO.getCustomerId());
		customers.setCustomerName(customersDTO.getCustomerName());
		customers.setEmail(customersDTO.getEmail());
		customers.setPhoneNumber(customersDTO.getPhoneNumber());
		customers.setDeliveryAddress(customersDTO.getDeliveryAddress());
		customers.setPassword(passwordEncoder.encode(customersDTO.getPassword()));

		logger.info("Updated to customers with id"+customersDTO.getCustomerId());

		return repo.save(customers);
	}

	@Override
	public void deleteById(int customerId) {
	    Customers customers = repo.findById(customerId).orElse(null);

	    logger.info("Customers deleted");

	    if (customers != null) {
	        repo.deleteById(customers.getCustomerId());
	    }
	}

	@Override
	public CustomersDTO getByCustomerName(String customerName) {
		
		Customers customers=repo.getByCustomerName(customerName);
		if (customers == null) {
	        throw new CustomerNotFoundException(HttpStatus.NOT_FOUND, "Customers with customerName: " + customerName + " not found");
	    }

		
		CustomersDTO customersDTO=new CustomersDTO();
		
		customersDTO.setCustomerId(customers.getCustomerId());
		customersDTO.setCustomerName(customers.getCustomerName());
		customersDTO.setEmail(customers.getEmail());
		customersDTO.setPhoneNumber(customers.getPhoneNumber());
		customersDTO.setDeliveryAddress(customers.getDeliveryAddress());
		customersDTO.setPassword(passwordEncoder.encode(customers.getPassword()));

		logger.info("Get  customers with name"+customers.getCustomerName());

		
		
		return customersDTO;
		
		
		
	}

}
