package com.Ecommerce.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	@Id
	private int id;
	private String username;
	private String password;
	private String role;
	
	private String name;
	private String email;
	private String number;
	private String address;
	
	
	
	

}
