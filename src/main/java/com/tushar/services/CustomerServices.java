package com.tushar.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tushar.Model.Customers;

@Service
public class CustomerServices extends BaseServices{

	public void addCustomer(Customers customers) {
		customersRepo.save(customers);
	}
	
	public Customers getCustomer(int id) {
		 
		Optional<Customers> opt= customersRepo.findById(id);
		Customers customers=opt.get();
		customers.setPhoto(FileStorageService.ImagePath(customers.getPhoto()));
		return customers;
	}
}
