package com.Ecommerce.serviceimpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.dto.CartDTO;
import com.Ecommerce.dto.OrdersDTO;
import com.Ecommerce.dto.ProductDTO;
import com.Ecommerce.dto.UserDTO;
import com.Ecommerce.entity.Cart;
import com.Ecommerce.entity.CustomerEntity;
import com.Ecommerce.entity.DeletedCart;
import com.Ecommerce.entity.Orders;
import com.Ecommerce.entity.Product;
import com.Ecommerce.entity.Status;
import com.Ecommerce.exception.CartException;
import com.Ecommerce.exception.OrderException;
import com.Ecommerce.repository.CartRepository;
import com.Ecommerce.repository.DeleteCartRepository;
import com.Ecommerce.repository.OrdersRepository;
import com.Ecommerce.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private OrdersRepository ordersRepository;
	@Autowired
	private DeleteCartRepository deleteCartRepository;
 
	public OrdersDTO addOrders(int customerId) throws CartException {
 
		Cart cart = cartRepository.findByCustomerId(customerId).get();
		if (cart != null) {
			CartDTO cartDTO = mapCartToDTO(cart);
 
			DeletedCart deletedCart = new DeletedCart();
 
			List<Product> products = cart.getProducts();
 
			List<Product> products2 = new ArrayList<Product>();
 
			for (Product product : products) {
 
				Product product3 = new Product();
 
				product3.setBrand(product.getBrand());
				product3.setCategory(product.getCategory());
				product3.setProductId(product.getProductId());
				product3.setProductImage(product.getProductImage());
				product3.setProductName(product.getProductName());
				product3.setProductPrice(product.getProductPrice());
				product3.setQuantity(product.getQuantity());
 
				products2.add(product3);
 
			}
 
			CustomerEntity customer = cart.getCustomer();
			Orders order = new Orders();
 
			order.setCart(cart);
			order.setDate(LocalDateTime.now());
			order.setStatus(Status.pending);
 
			ordersRepository.save(order);
 
			deletedCart.setProducts(products2);
			deletedCart.setCustomer(customer);
			deletedCart.setOrderid(order.getOrderId());
			deletedCart.setTotalPrice(cart.getTotalPrice());
			deletedCart.setTotalQuantity(cart.getTotalQuantity());
 
			deleteCartRepository.save(deletedCart);
 
			cart.getProducts().clear();
			cart.setTotalPrice(0);
			cart.setTotalQuantity(0);
 
			cartRepository.save(cart);
 
			OrdersDTO ordersDTO = new OrdersDTO();
			ordersDTO.setOrderId(order.getOrderId());
			ordersDTO.setCart(cartDTO);
			ordersDTO.setDate(LocalDateTime.now());
			ordersDTO.setStatus(Status.pending);
 
			return ordersDTO;
 
		}
		else
		throw new CartException("Cart Not Found so Cannot Add Orders");
	}
 
	private CartDTO mapCartToDTO(Cart cart) {
		CartDTO cartDTO = new CartDTO();
		cartDTO.setId(cart.getId());
		cartDTO.setCustomer(mapCustomerToDTO(cart.getCustomer()));
		cartDTO.setProducts(mapProductsToDTO(cart.getProducts()));
		cartDTO.setTotalPrice(cart.getTotalPrice());
		cartDTO.setTotalQuantity(cart.getTotalQuantity());
		return cartDTO;
	}
 
	private UserDTO mapCustomerToDTO(CustomerEntity customer) {
		UserDTO customerDTO = new UserDTO();
		customerDTO.setId(customer.getId());
		customerDTO.setAddress(customer.getAddress());
		customerDTO.setEmail(customer.getEmail());
		customerDTO.setNumber(customer.getNumber());
		customerDTO.setPassword(customer.getPassword());
		customerDTO.setUsername(customer.getUsername());
//		customerDTO.setRole(customer.getRole());
//		customerDTO.setName(customer.getName());
		return customerDTO;
	}
 
	private List<ProductDTO> mapProductsToDTO(List<Product> products) {
		return products.stream().map(product -> {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setBrand(product.getBrand());
			productDTO.setCategory(product.getCategory());
			productDTO.setProductId(product.getProductId());
			productDTO.setProductImage(product.getProductImage());
			productDTO.setProductName(product.getProductName());
			productDTO.setProductPrice(product.getProductPrice());
			productDTO.setQuantity(product.getQuantity());
			return productDTO;
		}).collect(Collectors.toList());
	}
 
	public OrdersDTO getById(int id) throws OrderException {
 
		Orders order = ordersRepository.findById(id).get();
		DeletedCart cart = deleteCartRepository.findByOrderId(id);
		if(order!=null ) {
 
		OrdersDTO orderDTO = new OrdersDTO();
 
		orderDTO.setCart(mapCartToDTO(cart));
 
		orderDTO.setDate(order.getDate());
		orderDTO.setOrderId(order.getOrderId());
		orderDTO.setStatus(order.getStatus());
 
		return orderDTO;
		}
		else {
			throw new OrderException("Order Not Found");
		}
	}
 
	private CartDTO mapCartToDTO(DeletedCart cart) {
		CartDTO cartDTO = new CartDTO();
		cartDTO.setId(cart.getId());
		cartDTO.setCustomer(mapCustomerToDTO(cart.getCustomer()));
		cartDTO.setProducts(mapProductsToDTO(cart.getProducts()));
		cartDTO.setTotalPrice(cart.getTotalPrice());
		cartDTO.setTotalQuantity(cart.getTotalQuantity());
		return cartDTO;
	}
 
	public List<OrdersDTO> findAllOrders() throws OrderException{
 
		List<Orders> orders = ordersRepository.findAll();
 
		List<OrdersDTO> ordersDTOs = new ArrayList<OrdersDTO>();
		List<DeletedCart> carts = deleteCartRepository.findAll();
		if(!orders.isEmpty()) {
		for (Orders order : orders) {
			OrdersDTO orderDTO = new OrdersDTO();
			for (DeletedCart cart : carts) {
				if (order.getOrderId() == cart.getOrderid())
					orderDTO.setCart(mapCartToDTO(cart));
			}
			orderDTO.setDate(order.getDate());
			orderDTO.setOrderId(order.getOrderId());
			orderDTO.setStatus(order.getStatus());
 
			ordersDTOs.add(orderDTO);
 
		}
 
		return ordersDTOs;
		}
		else {
			throw new OrderException("Orders Not Found");
		}
	}
 
	public String deleteOrders(int orderId) {
 
		DeletedCart cart = deleteCartRepository.findByOrderId(orderId);
 
		cart.getProducts().clear();
 
		ordersRepository.deleteById(orderId);
		deleteCartRepository.deleteByOrderId(orderId);
		return "Deleted Successfully";
	}
 
	public List<OrdersDTO> getOrderCustomerId(int customerId) throws OrderException{
		List<DeletedCart> carts=deleteCartRepository.findByCustomerId(customerId);
		if(!carts.isEmpty()) {
		List<Orders> orders=ordersRepository.findAll();
		List<OrdersDTO> ordersDTOs=new ArrayList<OrdersDTO>();
		for(Orders order:orders)
		{
			for(DeletedCart cart:carts)
			{
				if (order.getOrderId()==cart.getOrderid())
				{
					OrdersDTO orderDTO=new OrdersDTO();
					orderDTO.setDate(order.getDate());
					orderDTO.setOrderId(order.getOrderId());
					orderDTO.setStatus(order.getStatus());
					orderDTO.setCart(mapCartToDTO(cart));
					ordersDTOs.add(orderDTO);
				}
			}
		}
		return ordersDTOs;
		}
		else {
			throw new OrderException("Order Not Found for Given ID");
		}
 
	}
}
