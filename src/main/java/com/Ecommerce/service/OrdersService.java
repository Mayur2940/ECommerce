package com.Ecommerce.service;

import java.util.List;

import com.Ecommerce.dto.CartDTO;
import com.Ecommerce.dto.DeletedCartDTO;
import com.Ecommerce.dto.OrdersDTO;
import com.Ecommerce.exception.CartException;
import com.Ecommerce.exception.OrderException;

public interface OrdersService {
	
	public OrdersDTO addOrders(int custid) throws CartException;
	public String deleteOrders(int orderId);
	public OrdersDTO getById(int id) throws OrderException;
	public List<OrdersDTO> findAllOrders() throws OrderException;
	public List<OrdersDTO> getOrderCustomerId(int customerId) throws OrderException;
}
