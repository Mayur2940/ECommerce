package com;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Ecommerce.dto.CartDTO;
import com.Ecommerce.dto.ProductDTO;
import com.Ecommerce.dto.UserDTO;
import com.Ecommerce.entity.Cart;
import com.Ecommerce.entity.CustomerEntity;
import com.Ecommerce.entity.Product;
import com.Ecommerce.repository.CartRepository;
import com.Ecommerce.repository.CustomerRepository;
import com.Ecommerce.repository.ProductRepository;
import com.Ecommerce.serviceimpl.CartServiceImpl;

public class CartServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private CartServiceImpl cartService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddToCart() {
        int customerId = 1;
        int productId = 2;

        CustomerEntity customer = new CustomerEntity();
        customer.setId(customerId);
        customer.setAddress("123 Main St");
        customer.setEmail("customer@example.com");
        //customer.setName("John Doe");
        customer.setNumber("1234567890");
        customer.setPassword("password");
       // customer.setRole("CUSTOMER");
        customer.setUsername("john_doe");

        Product product = new Product();
        product.setProductId(productId);
        product.setBrand("Brand");
        product.setProductName("Product Name");
        product.setProductImage("Image URL");
        product.setProductPrice(19.99);
        product.setQuantity(5);

        Cart cart = new Cart();

        when(customerRepository.findById(customerId)).thenReturn(java.util.Optional.of(customer));
        when(productRepository.findById(productId)).thenReturn(java.util.Optional.of(product));

        CartDTO result = cartService.addToCart(customerId, productId);

        assertNotNull(result);
        assertEquals(customerId, result.getCustomer().getId());
        assertEquals(1, result.getProducts().size());
        assertEquals(productId, result.getProducts().get(0).getProductId());
        assertEquals(product.getProductPrice(), result.getProducts().get(0).getProductPrice());
    }

    @Test
    public void testDeleteProduct() {
        int customerId = 1;
        int productId = 2;

        CustomerEntity customer = new CustomerEntity();
        customer.setId(customerId);
        customer.setAddress("123 Main St");
        customer.setEmail("customer@example.com");
       // customer.setName("John Doe");
        customer.setNumber("1234567890");
        customer.setPassword("password");
      //  customer.setRole("CUSTOMER");
        customer.setUsername("john_doe");

        Product product = new Product();
        product.setProductId(productId);
        product.setBrand("Brand");
        product.setProductName("Product Name");
        product.setProductImage("Image URL");
        product.setProductPrice(19.99);
        product.setQuantity(5);

        Cart cart = new Cart();
        cart.setTotalPrice(product.getProductPrice());
        cart.setTotalQuantity(1);
        cart.setProducts(Arrays.asList(product));

    }}

