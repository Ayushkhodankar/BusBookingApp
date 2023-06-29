package com.tushar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tushar.Model.Buses;
import com.tushar.repository.BusRepo;

@Service
public class BusServices extends BaseServices{
	
	@Autowired
	BusRepo busRepo;
	
	public void addBus(Buses buses) {
		busRepo.save(buses);
	}
	
	public Buses getBus(int id) { 
		Optional<Buses> opt= busRepo.findById(id);
		Buses buses=opt.get();
		return buses;
	}

	public List<Buses> findByDestinationStartAndDestinationEnd(String destinationStart, String destinationEnd) {
		return busRepo.findByDestinationStartAndDestinationEnd(destinationStart,destinationEnd);
	}
}
