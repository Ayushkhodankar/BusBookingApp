package com.tushar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tushar.Model.OneWayTrip;

public interface OneWayTripRepo extends JpaRepository<OneWayTrip, Integer> {

	
}
