package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.model.userprinciple;
import com.example.demo.repository.userrepo;
@Service
public class userdetails implements UserDetailsService {
    @Autowired
    private userrepo repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=repo.findByUsername(username);
		System.out.println("hi");
		if(user==null) {
			throw new UsernameNotFoundException("error occured");
		}
		
		return new userprinciple(user);
	}
	

}
