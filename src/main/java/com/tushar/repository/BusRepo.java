package com.tushar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tushar.Model.Buses;

public interface BusRepo extends JpaRepository<Buses, Integer>{

	Buses findByBusName(String busName);
	
	List<Buses> findAllByOrderByIdDesc();

	List<Buses> findByDate(String date);

	List<Buses> findByType(String type);

	List<Buses> findByDestinationStartAndDestinationEnd(String destinationStart, String destinationEnd);

	List<Buses> findByTypeAndBusName(String type, String busName);

	List<Buses> findByTypeAndBusNameAndDate(String type, String busName, String date);

	List<Buses> findByTypeAndBusNameAndDateAndDestinationStartAndDestinationEnd(String type, String busName,
			String date, String destinationStart, String destinationEnd);
}
