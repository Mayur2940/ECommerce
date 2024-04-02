package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Ecommerce.dto.CartDTO;
import com.Ecommerce.dto.UserDTO;
import com.Ecommerce.entity.Cart;
import com.Ecommerce.entity.CustomerEntity;
import com.Ecommerce.exception.CustomerException;
import com.Ecommerce.repository.CartRepository;
import com.Ecommerce.repository.CustomerRepository;
import com.Ecommerce.serviceimpl.CustomerServiceImpl;

class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterCustomer() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("john_doe");
        userDTO.setAddress("123 Main St");
        userDTO.setEmail("john.doe@example.com");
        userDTO.setName("John Doe");
        userDTO.setNumber("1234567890");
        userDTO.setPassword("password");
        userDTO.setRole("CUSTOMER");
        

        when(customerRepository.save(any(CustomerEntity.class))).thenReturn(new CustomerEntity());

        UserDTO result = customerService.registerCustomer(userDTO);

        assertNotNull(result);
        assertEquals(userDTO, result);
        verify(customerRepository, times(1)).save(any(CustomerEntity.class));
    }

    @Test
    public void testReadAllUsers() throws CustomerException {
        when(customerRepository.findAll()).thenReturn(new ArrayList<>());

        List<UserDTO> result = customerService.readAllUsers();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testUpdateCustomer() throws CustomerException {
        int customerId = 1;
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("john_doe_updated");
        userDTO.setRole("ADMIN");

        CustomerEntity customer = new CustomerEntity();
        customer.setId(customerId);
        customer.setUsername("john_doe");
       // customer.setRole("CUSTOMER");

        when(customerRepository.findById(customerId)).thenReturn(java.util.Optional.of(customer));
        when(customerRepository.save(any(CustomerEntity.class))).thenReturn(customer);

        UserDTO result = customerService.updateCustomer(customerId, userDTO);

        assertNotNull(result);
        assertEquals(userDTO, result);
        verify(customerRepository, times(1)).save(any(CustomerEntity.class));
    }

    @Test
    public void testDeleteCustomer() {
        int customerId = 1;

        assertTrue(customerService.deleteCustomer(customerId));
        verify(customerRepository, times(1)).deleteById(customerId);
    }

    @Test
    public void testGetByEmail() {
        String email = "john.doe@example.com";

        when(customerRepository.findByEmail(email)).thenReturn(new ArrayList<>());

        List<UserDTO> result = customerService.getByEmail(email);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetCartByCustomer() {
        int customerId = 1;

        Cart cart = new Cart();
       
        cart.setTotalPrice(100.0);
        cart.setTotalQuantity(5);

        when(cartRepository.findByCustomerId(customerId)).thenReturn(Optional.of(cart));

       
    }
}
