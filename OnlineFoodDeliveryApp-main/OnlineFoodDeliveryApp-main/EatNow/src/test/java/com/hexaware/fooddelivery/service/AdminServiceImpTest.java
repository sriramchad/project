package com.hexaware.fooddelivery.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hexaware.fooddelivery.dto.AdminDTO;
import com.hexaware.fooddelivery.entity.Admin;

class AdminServiceImpTest {

	

	@Test
	void testAddAdmin() {
Admin admin =new Admin();
		
		
		admin.setAdminId(1);
		admin.setUserName("Jaga");
		admin.setPassword("1234");
		assertEquals("Jaga", admin.getUserName());
	}

	@Test
	void testGetById() {
		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setAdminId(101);
		adminDTO.setUserName("abc");
		adminDTO.setPassword("12345");
		assertEquals(101,adminDTO.getAdminId());
	}

	

	@Test
	void testUpdateAdmin() {
		Admin admin =new Admin();
		admin.setAdminId(1);
		admin.setUserName("Jaga");
		admin.setPassword("1234");
		assertEquals("1234", admin.getPassword());
	}

	

	@Test
	void testGetByAdminName() {
		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setAdminId(101);
		adminDTO.setUserName("abc");
		adminDTO.setPassword("12345");
		assertEquals("abc",adminDTO.getUserName());
	}

}
