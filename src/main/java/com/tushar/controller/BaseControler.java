package com.tushar.controller;

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
import com.tushar.services.BookingServices;
import com.tushar.services.BusServices;
import com.tushar.services.CustomerServices;
import com.tushar.services.FileStorageService;
import com.tushar.services.OneWayTripService;
import com.tushar.services.RoundTripServices;
import com.tushar.services.UsersServices;
import com.tushar.services.VenderBusServices;
import com.tushar.services.VenderServices;

public class BaseControler {
	
	@Autowired
	public FileStorageService fileStorageService;

	@Autowired
	UsersRepo userRepo;
	
	@Autowired
	UsersServices usersServices;
	
	@Autowired
	CustomersRepo customersRepo;
	
	@Autowired
	CustomerServices customerServices;
	
	@Autowired
	VenderRepo venderRepo;
	
	@Autowired
	VenderServices venderServices;
	
	@Autowired
	VenderBusRepo venderBusRepo;
	
	@Autowired
	VenderBusServices venderBusServices;
	
	@Autowired
	BusServices busServices;
	
	@Autowired
	BusRepo busRepo;
	
	@Autowired
	BookingRepo bookingRepo;
	
	@Autowired
	BookingServices bookingServices;
	
	@Autowired
	RoundTripServices roundTripServices;
	
	@Autowired
	RoundTripRepo roundTripRepo;
	
	@Autowired
	OneWayTripService  oneWayTripService ;
	
	@Autowired 
	OneWayTripRepo oneWayTripRepo;
	
	@Autowired
	SeatRepository seatRepository;
}
