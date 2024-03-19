package com.hexaware.fooddelivery.service;


import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.fooddelivery.dto.AdminDTO;
import com.hexaware.fooddelivery.entity.Admin;
import com.hexaware.fooddelivery.exception.AdminNotFoundException;
import com.hexaware.fooddelivery.repository.AdminRepository;
/*
 * 
 * @Author:Vikas
 * Date:10-11-2023
 * 
 * 
 * 
 */
@Service
public class AdminServiceImp implements IAdminService {
	
	
	@Autowired
	private AdminRepository repo;
	private PasswordEncoder passwordEncoder;

	public AdminServiceImp(AdminRepository repo, PasswordEncoder passwordEncoder) {
		super();
		this.repo = repo;
		this.passwordEncoder = passwordEncoder;
	}

	
	
	Logger logger = LoggerFactory.getLogger(AdminServiceImp.class);
	
	@Override
	public Admin addAdmin(AdminDTO adminDTO) {
		Admin admin =new Admin();
		
		
		admin.setAdminId(adminDTO.getAdminId());
		admin.setUserName(adminDTO.getUserName());
		admin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));

		logger.info("Added to admin with name:"+adminDTO.getUserName());
		return repo.save(admin);
	}

	@Override
	public AdminDTO getById(int adminId) {
		Admin admin = repo.findById(adminId).orElse(new Admin());
		if (admin.getAdminId()==0) {
			throw new AdminNotFoundException(HttpStatus.NOT_FOUND,"admin with adminId:"+adminId+" notfound");

		}
		
		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setAdminId(admin.getAdminId());
		adminDTO.setUserName(admin.getUserName());
		adminDTO.setPassword(passwordEncoder.encode(admin.getPassword()));
		
		logger.info("Get admin with adminId:"+adminDTO.getAdminId());


		
		return adminDTO;
	}

	@Override
	public List<Admin> getAllAdmin() {
		logger.info("All admins are fetched");

		return repo.findAll();
		
	}

	@Override
	public Admin updateAdmin(AdminDTO adminDTO) {
		Admin admin=new Admin();
		admin.setAdminId(adminDTO.getAdminId());
		admin.setUserName(adminDTO.getUserName());
		admin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));

		
		logger.info("Updated admin with adminId:"+adminDTO.getAdminId());

		return repo.save(admin);
	}

	@Override
	public void deleteById(int adminId) {
		Admin admin=repo.findById(adminId).orElse(null);
		if (admin != null) {
		repo.deleteById(admin.getAdminId());}
		logger.info("Deleted admin record ");
		
	}

	@Override
	public AdminDTO getByAdminName(String userName) {
		Admin admin = repo.findByuserName(userName);
		if (admin==null) {
			throw new AdminNotFoundException(HttpStatus.NOT_FOUND,"admin with userName:"+userName+" notfound");

		}
		
		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setAdminId(admin.getAdminId());
		adminDTO.setUserName(admin.getUserName());
		adminDTO.setPassword(passwordEncoder.encode(admin.getPassword()));

		
		logger.info("Get admin with adminName:"+admin.getUserName());


		
		return adminDTO;
	}

}
