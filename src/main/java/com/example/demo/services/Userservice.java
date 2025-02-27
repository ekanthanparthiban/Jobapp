package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.userrepo;

@Service
public class Userservice {
	private userrepo repo;
	@Autowired
	public void setRepo(userrepo repo) {
		this.repo = repo;
	}
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12); 
   public void addlogin(User user) {
	user.setPassword(encoder.encode(user.getPassword()));
	repo.save(user);
}
}
