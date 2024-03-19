package com.hexaware.fooddelivery.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hexaware.fooddelivery.dto.CustomersDTO;
import com.hexaware.fooddelivery.entity.Customers;

class CustomersServiceImpTest {

	@Test
	void testCustomersServiceImp() {
		Customers customers=new Customers();
	       

		customers.setCustomerId(100);
		customers.setCustomerName("Hari");
		customers.setEmail("abc@gmail.com");
		customers.setPhoneNumber("1234567890");
		customers.setDeliveryAddress("MM Road");
		assertEquals("MM Road", customers.getDeliveryAddress());
	}

	@Test
	void testAddCustomers() {
		fail("Not yet implemented");
	}

	@Test
	void testGetById() {
		CustomersDTO customersDTO=new CustomersDTO();

		customersDTO.setCustomerId(100);
		customersDTO.setCustomerName("Hari");
		customersDTO.setEmail("abc@gmail.com");
		customersDTO.setPhoneNumber("12344567890");
		customersDTO.setDeliveryAddress("South ByPass");
		assertEquals("South ByPass", customersDTO.getDeliveryAddress());
	}

	

	@Test
	void testUpdateCustomers() {
		Customers customers=new Customers();
	       

		customers.setCustomerId(100);
		customers.setCustomerName("Hari");
		customers.setEmail("abc@gmail.com");
		customers.setPhoneNumber("1234567890");
		customers.setDeliveryAddress("MM Road");
		assertEquals(100, customers.getCustomerId());
	}

	

	@Test
	void testGetByCustomerName() {
		CustomersDTO customersDTO=new CustomersDTO();

		customersDTO.setCustomerId(100);
		customersDTO.setCustomerName("Hari");
		customersDTO.setEmail("abc@gmail.com");
		customersDTO.setPhoneNumber("12344567890");
		customersDTO.setDeliveryAddress("South ByPass");
		assertEquals("Hari", customersDTO.getCustomerName());
	}

}
