package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.services.Userservice;

@RestController
public class usercontroller {
@Autowired
private Userservice ser;
@PostMapping("user")
public User addlogin(@RequestBody User user) {
	ser.addlogin(user);
	return user;
}
}
