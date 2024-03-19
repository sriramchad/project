package com.hexaware.fooddelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hexaware.fooddelivery.entity.Orders;
/*
 * 
 * @Author:Karthik 
 * Date:10-11-2023
 * Description:  interface of OrdersRepository
 * 
 * 
 */
public interface OrdersRepository extends JpaRepository<Orders, Integer>{
	@Query("FROM Orders o WHERE o.customer.customerId = :customerId")
    List<Orders> findCustomerByCustomerId(@Param("customerId") int customerId);
}
