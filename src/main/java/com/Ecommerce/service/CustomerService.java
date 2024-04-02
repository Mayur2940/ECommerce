package com.Ecommerce.service;

import java.util.List;

import com.Ecommerce.dto.CartDTO;
import com.Ecommerce.dto.UserDTO;
import com.Ecommerce.exception.CartException;
import com.Ecommerce.exception.CustomerException;

public interface CustomerService {

	public UserDTO registerCustomer(UserDTO customerDTO);

	public UserDTO updateCustomer(int id, UserDTO customerDTO) throws CustomerException;

	public boolean deleteCustomer(int id);

	public List<UserDTO> getByEmail(String email);

	public CartDTO getCartByCustomer(int customerId) throws CartException;

}
