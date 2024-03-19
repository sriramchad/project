package com.hexaware.fooddelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hexaware.fooddelivery.entity.Cart;
import com.hexaware.fooddelivery.entity.Menu;
/*
 * 
 * @Author:Karthik 
 * Date:10-11-2023
 * Description:  interface of CartRepository
 * 
 * 
 */
public interface CartRepository extends JpaRepository<Cart, Integer>{
	@Query("FROM Cart c WHERE c.customers.customerId = :customerId")
    List<Cart> findCustomerByCustomerId(@Param("customerId") int customerId);
}
