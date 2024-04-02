package com.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.dto.CartDTO;
import com.Ecommerce.dto.DeletedCartDTO;
import com.Ecommerce.dto.OrdersDTO;
import com.Ecommerce.entity.DeletedCart;
import com.Ecommerce.entity.Orders;
import com.Ecommerce.exception.CartException;
import com.Ecommerce.exception.OrderException;
import com.Ecommerce.serviceimpl.OrdersServiceImpl;

@RestController
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	private OrdersServiceImpl ordersServiceImpl;

	// User Register
	@PostMapping("/placeOrder/{custid}")
	public OrdersDTO addOrder(@PathVariable(value = "custid") int custid) throws CartException {
		return ordersServiceImpl.addOrders(custid);
	}

	// User Register
	@GetMapping("/find/{orderId}")
	public OrdersDTO FindById(@PathVariable(value = "orderId") int orderId) throws OrderException {
		return ordersServiceImpl.getById(orderId);
	}

	// User Register
	@GetMapping("/findall")
	public List<OrdersDTO> FindAllOrders() throws OrderException {
		return ordersServiceImpl.findAllOrders();
	}

	// delete users
	@DeleteMapping("/deleteOrder/{no}")
	public String deleteOrder(@PathVariable(value = "no") int no) {
		return ordersServiceImpl.deleteOrders(no);

	}
	
	// User Register
		@GetMapping("/findBycustId/{custId}")
		public List<OrdersDTO> getOrderCustId(@PathVariable(value = "custId") int custId) throws OrderException {
			return ordersServiceImpl.getOrderCustomerId(custId);
		}
}
