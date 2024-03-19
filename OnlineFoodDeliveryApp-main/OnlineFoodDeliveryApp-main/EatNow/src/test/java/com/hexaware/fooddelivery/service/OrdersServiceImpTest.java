package com.hexaware.fooddelivery.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hexaware.fooddelivery.dto.OrdersDTO;
import com.hexaware.fooddelivery.entity.Orders;

class OrdersServiceImpTest {

	@Test
	void testAddOrders() {
		Orders orders = new Orders();
		orders.setCartId(100);
//		orders.setCustomerId(200);
//		orders.setRestaurantId(300);
		orders.setDeliveryAddress("ongole");
		orders.setPaymentMethod("Debit");
		orders.setTotalAmount(400);
		assertEquals(400, orders.getTotalAmount());
	}

	@Test
	void testGetById() {
OrdersDTO ordersDTO=new OrdersDTO();
		
		ordersDTO.setCartId(100);
		ordersDTO.setCustomerId(200);
		ordersDTO.setRestaurantId(300);
		ordersDTO.setDeliveryAddress("Guntur");
		ordersDTO.setPaymentMethod("COD");
		ordersDTO.setTotalAmount(400);
		assertEquals(100, ordersDTO.getCartId());
	}

	

	@Test
	void testUpdateOrders() {
		Orders orders = new Orders();
		orders.setCartId(100);
//		orders.setCustomerId(200);
//		orders.setRestaurantId(300);
		orders.setDeliveryAddress("ongole");
		orders.setPaymentMethod("Debit");
		orders.setTotalAmount(400);
		assertEquals(100, orders.getCartId());
	}

	

}
