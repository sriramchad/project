package com.hexaware.fooddelivery.repository;


import java.util.Optional;
/*
 * 
 * @Author:Vikas 
 * Date:10-11-2023
 * Description:  interface of CustomersRepository
 * 
 * 
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.fooddelivery.entity.Customers;
@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer>{
	  Customers getByCustomerName(String customerName);
	  
	  
	  
	  
	  Optional<Customers> findByCustomerName(String customerName);
		public Customers findByCustomerNameAndPassword( String customerName, String password);
}
