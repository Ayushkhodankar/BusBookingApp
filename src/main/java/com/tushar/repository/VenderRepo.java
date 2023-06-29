package com.tushar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tushar.Model.Venders;

public interface VenderRepo  extends JpaRepository<Venders, Integer>{
	
	Venders findByMob(String mob);
	
	List<Venders> findAllByOrderByIdDesc();

}
