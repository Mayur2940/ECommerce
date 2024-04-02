package com.Ecommerce.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.dto.CartDTO;
import com.Ecommerce.dto.ProductDTO;
import com.Ecommerce.dto.UserDTO;
import com.Ecommerce.entity.Cart;
import com.Ecommerce.entity.CustomerEntity;
import com.Ecommerce.entity.Product;
import com.Ecommerce.repository.CartRepository;
import com.Ecommerce.repository.CustomerRepository;
import com.Ecommerce.repository.ProductRepository;
import com.Ecommerce.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CartRepository cartRepository;

	public CartDTO addToCart(int customerId, int productId) {
		double total;
		int quantity;
		CustomerEntity customer = customerRepository.findById(customerId).get();

		Product product = productRepository.findById(productId).get();
		System.out.println(product);

		Cart cart = customer.getCart();

		if (cart == null) {
			cart = new Cart();
			customer.setCart(cart);

			cart.setCustomer(customer);

		}
		total = cart.getTotalPrice();

		quantity = cart.getTotalQuantity();

		quantity = quantity + 1;
		total = product.getProductPrice() + total;
		cart.setTotalPrice(total);
		cart.setTotalQuantity(quantity);
		cart.getProducts().add(product);
		System.out.println(cart.getProducts());

		cartRepository.save(cart);

		CartDTO cartDTO = new CartDTO();
		UserDTO userDTO = new UserDTO();

		userDTO.setAddress(customer.getAddress());
		userDTO.setEmail(customer.getEmail());
		//userDTO.setName(customer.getName());
		userDTO.setNumber(customer.getNumber());
		userDTO.setPassword(customer.getPassword());
		//userDTO.setRole(customer.getRole());
		userDTO.setId(customer.getId());
		userDTO.setUsername(customer.getUsername());

		cartDTO.setCustomer(userDTO);

		List<ProductDTO> productIds = new ArrayList<>();
		for (Product product_i : cart.getProducts()) {
			ProductDTO product1 = new ProductDTO();
			product1.setBrand(product_i.getBrand());
			product1.setCategory(product_i.getCategory());
			product1.setProductId(product_i.getProductId());
			product1.setProductImage(product_i.getProductImage());
			product1.setProductName(product_i.getProductName());
			product1.setProductPrice(product_i.getProductPrice());
			product1.setQuantity(product_i.getQuantity());

			productIds.add(product1);
		}
		cartDTO.setProducts(productIds);

		return cartDTO;
	}

	public String deleteProduct(int custid, int prodid) {

		CustomerEntity customer = customerRepository.findById(custid).orElse(null);
		Cart cart=customer.getCart();
		
		List<Product> products=cart.getProducts();
		int quantity;
		double totalprice;
		quantity=cart.getTotalQuantity();
		totalprice=cart.getTotalPrice();
		for (Product product:products)
		{
			if (product.getProductId()== prodid)
			{
				quantity=quantity-1;
				totalprice=totalprice-product.getProductPrice();
				cartRepository.deleteByCartProduct(prodid);
			}
		}
		cart.setTotalPrice(totalprice);
		cart.setTotalQuantity(quantity);
		cartRepository.save(cart);
		
		return "deleted Successfully";
		

	}
}