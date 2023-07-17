package com.tushar.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.tushar.repository.BookingRepo;
import com.tushar.repository.BusRepo;
import com.tushar.repository.CustomersRepo;
import com.tushar.repository.OneWayTripRepo;
import com.tushar.repository.RoundTripRepo;
import com.tushar.repository.SeatRepository;
import com.tushar.repository.UsersRepo;
import com.tushar.repository.VenderBusRepo;
import com.tushar.repository.VenderRepo;

public class BaseServices {

	@Autowired
	UsersRepo usersRepo;
	
	@Autowired
	CustomersRepo customersRepo;
	
	@Autowired
	VenderRepo venderRepo;
	
	@Autowired
	BusRepo busRepo;
	
	@Autowired
	VenderBusRepo venderBusRepo;
	
	@Autowired
	BookingRepo bookingRepo;
	
	@Autowired
    RoundTripRepo roundTripRepo;
	
	@Autowired
	OneWayTripRepo oneWayTripRepo;
	
	@Autowired
	SeatRepository seatRepository;
}
