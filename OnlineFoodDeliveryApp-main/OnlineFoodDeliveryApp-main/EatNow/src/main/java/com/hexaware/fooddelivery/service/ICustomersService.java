package com.hexaware.fooddelivery.service;

import java.util.List;

import com.hexaware.fooddelivery.dto.CustomersDTO;
import com.hexaware.fooddelivery.entity.Customers;
/*
 * 
 * @Author:Vikas
 * Date:10-11-2023
 * Description:  interface of ICustomersService
 * 
 * 
 */
public interface ICustomersService {
	public Customers addCustomers(CustomersDTO customersDTO);
	public CustomersDTO getById(int customerId);
	public List<Customers> getAllCustomers();
	Customers updateCustomers(CustomersDTO customersDTO);
	void deleteById(int customerId);
	
	CustomersDTO getByCustomerName(String customerId);
}
