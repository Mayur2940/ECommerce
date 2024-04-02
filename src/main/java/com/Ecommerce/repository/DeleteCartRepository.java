package com.Ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.Ecommerce.entity.DeletedCart;

public interface DeleteCartRepository extends JpaRepository<DeletedCart, Integer> {

	// Custom Repository method
	@Query(value = "select * from deleted_cart where orderid=?1", nativeQuery = true)
	public DeletedCart findByOrderId(int orderid);

	// Custom Repository method
	@Query(value = "select * from deleted_cart where customer_id=?1", nativeQuery = true)
	public List<DeletedCart> findByCustomerId(int orderid);

	@Modifying
	@Transactional
	@Query(value = "delete from deleted_cart where orderid = ?1 ", nativeQuery = true)
	public void deleteByOrderId(int id);

}
