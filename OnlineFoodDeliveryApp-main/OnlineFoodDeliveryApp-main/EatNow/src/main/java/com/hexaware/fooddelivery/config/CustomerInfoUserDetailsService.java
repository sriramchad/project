package com.hexaware.fooddelivery.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;  // Added missing import

import com.hexaware.fooddelivery.entity.Admin;
import com.hexaware.fooddelivery.entity.Customers;
import com.hexaware.fooddelivery.repository.AdminRepository;
import com.hexaware.fooddelivery.repository.CustomersRepository;



@Service  
public class CustomerInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private CustomersRepository customerRepository; 

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUserName(username)
                .orElse(null);

        if (admin != null) {
            return new AdminInfoUserDetails(admin);
        } else {
            Customers customer = customerRepository.findByCustomerName(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

            return new CustomerInfoUserDetails(customer);
        }
    }

    
}

