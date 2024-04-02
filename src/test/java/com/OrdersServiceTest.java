package com;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
import com.Ecommerce.repository.CartRepository;
import com.Ecommerce.repository.DeleteCartRepository;
import com.Ecommerce.repository.OrdersRepository;
import com.Ecommerce.serviceimpl.OrdersServiceImpl;

public class OrdersServiceTest {

    @Mock
    private CartRepository cartRepository;

    @Mock
    private OrdersRepository ordersRepository;

    @Mock
    private DeleteCartRepository deleteCartRepository;

    @InjectMocks
    private OrdersServiceImpl ordersService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddOrders() throws CartException {
        int customerId = 1;

        Cart cart = new Cart();
        cart.setTotalPrice(100.0);
        cart.setTotalQuantity(5);

        CustomerEntity customer = new CustomerEntity();
        customer.setId(customerId);
        customer.setUsername("john_doe");

        cart.setCustomer(customer);

        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setBrand("Brand");
        product.setProductId(1);
        product.setProductImage("Image");
        product.setProductName("Product");
        product.setProductPrice(50.0);
        product.setQuantity(2);

        products.add(product);
        cart.setProducts(products);

        when(cartRepository.findByCustomerId(customerId)).thenReturn(Optional.of(cart));
        when(ordersRepository.save(any(Orders.class))).thenReturn(new Orders());
        when(deleteCartRepository.save(any(DeletedCart.class))).thenReturn(new DeletedCart());

        OrdersDTO result = ordersService.addOrders(customerId);

        assertNotNull(result);
        
    }

    @Test
    public void testGetById() {
        int orderId = 1;

        Orders order = new Orders();
        order.setOrderId(orderId);
        order.setDate(LocalDateTime.now());
        order.setStatus(Status.pending);

        DeletedCart cart = new DeletedCart();
        cart.setOrderid(orderId);
        cart.setTotalPrice(100.0);
        cart.setTotalQuantity(5);

        when(ordersRepository.findById(orderId)).thenReturn(Optional.of(order));
        when(deleteCartRepository.findByOrderId(orderId)).thenReturn(cart);

        
    }

    @Test
    public void testFindAll() {
        Orders order = new Orders();
        order.setOrderId(1);
        order.setDate(LocalDateTime.now());
        order.setStatus(Status.pending);

        DeletedCart cart = new DeletedCart();
        cart.setOrderid(1);
        cart.setTotalPrice(100.0);
        cart.setTotalQuantity(5);

        List<Orders> orders = new ArrayList<>();
        orders.add(order);

        List<DeletedCart> carts = new ArrayList<>();
        carts.add(cart);

        when(ordersRepository.findAll()).thenReturn(orders);
        when(deleteCartRepository.findAll()).thenReturn(carts);

        
    }

    @Test
    public void testDeleteOrders() {
        int orderId = 1;

        DeletedCart cart = new DeletedCart();
        cart.setOrderid(orderId);
        cart.setProducts(new ArrayList<>());

        when(deleteCartRepository.findByOrderId(orderId)).thenReturn(cart);

        String result = ordersService.deleteOrders(orderId);

        assertEquals("Deleted Successfully", result);
        verify(ordersRepository, times(1)).deleteById(orderId);
        verify(deleteCartRepository, times(1)).deleteByOrderId(orderId);
    }

    @Test
    public void testGetOrderCustomerId() {
        int customerId = 1;

        DeletedCart cart = new DeletedCart();
        cart.setOrderid(1);
        cart.setTotalPrice(100.0);
        cart.setTotalQuantity(5);

        Orders order = new Orders();
        order.setOrderId(1);
        order.setDate(LocalDateTime.now());
        order.setStatus(Status.pending);

        List<DeletedCart> carts = new ArrayList<>();
        carts.add(cart);

        List<Orders> orders = new ArrayList<>();
        orders.add(order);

        when(deleteCartRepository.findByCustomerId(customerId)).thenReturn(carts);
        when(ordersRepository.findAll()).thenReturn(orders);


   
    }
}
