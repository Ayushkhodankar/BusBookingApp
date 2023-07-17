package com.tushar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tushar.Model.Seat;

public interface SeatRepository extends JpaRepository<Seat,Integer > {

	 Seat findBySeatNumber(String seatNumber);

	int deleteByid(int id);

	List<Seat> findByCustomerId(String customerId);

}
