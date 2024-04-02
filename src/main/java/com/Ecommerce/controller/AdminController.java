package com.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.dto.UserDTO;
import com.Ecommerce.serviceimpl.AdminServiceImpl;


@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000/")
public class AdminController {

	@Autowired 
	AdminServiceImpl adminServiceImpl;

	// User Register
	@PostMapping("/registerAdmin")
	public UserDTO addAdmin(@RequestBody UserDTO adminDTO) {
		return adminServiceImpl.addAdmin(adminDTO);
	}

	// Update all users
	@PutMapping("/updateAdmin/{id}")
	public UserDTO updateAdmin(@PathVariable(value = "id") int id, @RequestBody UserDTO admin) {
		adminServiceImpl.updateAdmin(id, admin);
		return admin;
	}

	// Read all user
	@GetMapping("/adminByEmail/{email}")
	public List<UserDTO> getAdminByEmail(@PathVariable(value = "email") String email) {
		return adminServiceImpl.getAdminByEmail(email);
	}
	
	public String deleteById(@PathVariable(value = "id") int id) {
		return adminServiceImpl.deleteAdminById(id);
	}

}
