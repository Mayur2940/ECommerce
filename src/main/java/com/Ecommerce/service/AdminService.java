package com.Ecommerce.service;

import java.util.List;

import com.Ecommerce.dto.UserDTO;

public interface AdminService {
	
	public UserDTO addAdmin(UserDTO adminDTO);
	public UserDTO updateAdmin(int id,UserDTO adminDTO);
	public List<UserDTO> getAdminByEmail(String email);
	public String deleteAdminById(int adminId);
	
	

}
