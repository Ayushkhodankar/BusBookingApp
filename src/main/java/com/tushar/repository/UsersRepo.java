package com.tushar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tushar.Model.Users;

public interface UsersRepo extends JpaRepository<Users, Integer>{

	Users findByUsername(String username);
	
	List<Users> findAllByOrderByIdDesc();
}
