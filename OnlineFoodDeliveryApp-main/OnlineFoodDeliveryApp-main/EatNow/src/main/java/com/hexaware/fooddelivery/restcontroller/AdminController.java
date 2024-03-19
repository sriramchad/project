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

import com.hexaware.fooddelivery.dto.AdminDTO;
import com.hexaware.fooddelivery.entity.Admin;
import com.hexaware.fooddelivery.service.IAdminService;

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
@RequestMapping("/api/Admin")
public class AdminController {
	@Autowired
	IAdminService service;
	
	
	@PostMapping("/addAdmin")
	public Admin addAdmin(@Valid @RequestBody AdminDTO adminDTO) {
		
		return service.addAdmin(adminDTO);
	}

	@GetMapping("/getById/{adminId}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public AdminDTO getById(@PathVariable int adminId) {
		return service.getById(adminId);
	}

	@GetMapping("/getAllAdmin")

	public List<Admin> getAllAdmin() {
		return service.getAllAdmin();
	}

	@PutMapping("/updateAdmin")
	@PreAuthorize("hasAnyAuthority('ADMIN')")

	public Admin updateAdmin( @RequestBody AdminDTO adminDTO) {
		return service.updateAdmin(adminDTO);
	}

	@DeleteMapping("/deleteById/{adminId}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")

	public void deleteById(@PathVariable int adminId) {
		service.deleteById(adminId);

	}
	@GetMapping("/getByName/{userName}")
	public AdminDTO getByName(@PathVariable String userName) {
			return service.getByAdminName(userName);
		}
}
