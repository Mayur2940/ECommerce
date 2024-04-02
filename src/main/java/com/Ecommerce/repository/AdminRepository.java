package com.Ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ecommerce.entity.AdminEntity;
@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Integer>{
	
	public List<AdminEntity> findByEmail(String email);

}
