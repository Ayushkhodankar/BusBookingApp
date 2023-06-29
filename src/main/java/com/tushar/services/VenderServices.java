package com.tushar.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tushar.Model.Venders;

@Service
public class VenderServices  extends BaseServices{

	public void addVender(Venders venders) {
		venderRepo.save(venders);
	}
	
	public Venders getVender(int id) {
		 
		Optional<Venders> opt= venderRepo.findById(id);
		Venders venders=opt.get();
		venders.setLogo(FileStorageService.ImagePath(venders.getLogo()));
		return venders;
	}
}
