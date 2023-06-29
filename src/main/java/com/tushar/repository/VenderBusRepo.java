package com.tushar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tushar.Model.VenderBuses;

public interface VenderBusRepo extends JpaRepository<VenderBuses, Integer>{
	
	VenderBuses findByVenderId(String venderId);
	
	VenderBuses findByBusID(String busID);
	
	List<VenderBuses> findAllByOrderByIdDesc();

}
