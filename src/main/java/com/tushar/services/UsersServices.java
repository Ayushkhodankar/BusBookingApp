package com.tushar.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tushar.Model.Users;

@Service
public class UsersServices extends BaseServices{

	public void addUser(Users user) {
		usersRepo.save(user);
	}
	
	public Users getUsers(int id) {
		 
		Optional<Users> opt= usersRepo.findById(id);
		Users admins=opt.get();
		return admins;
	}
}
