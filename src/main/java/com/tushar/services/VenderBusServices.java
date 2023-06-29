package com.tushar.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tushar.Model.VenderBuses;

@Service
public class VenderBusServices extends BaseServices{
	
	public void addBus(VenderBuses buses) {
		venderBusRepo.save(buses);
	}
	
	public VenderBuses getBus(int id) {
		 
		Optional<VenderBuses> opt= venderBusRepo.findById(id);
		VenderBuses buses=opt.get();
		buses.setPhoto(FileStorageService.ImagePath(buses.getPhoto()));
		buses.setIncurencePic(FileStorageService.ImagePath(buses.getIncurencePic()));
		buses.setRcPic(FileStorageService.ImagePath(buses.getRcPic()));
		return buses;
	}

}
