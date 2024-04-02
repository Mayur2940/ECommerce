package com.Ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ecommerce.dto.OrdersDTO;
import com.Ecommerce.entity.Orders;
import com.Ecommerce.entity.Product;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{
	
	//public List<OrdersDTO> findAl();

}
