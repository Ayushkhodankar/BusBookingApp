package com.tushar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tushar.Model.Customers;

public interface CustomersRepo extends JpaRepository<Customers, Integer>{
	
	Customers findByMob(String mob);
	
	List<Customers> findAllByOrderByIdDesc();

}
