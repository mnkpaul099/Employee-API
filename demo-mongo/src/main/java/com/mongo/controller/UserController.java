package com.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.entity.User;
import com.mongo.repository.UserRepository;

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@GetMapping("/findAllUser")
	public List<User> findAllUser() {
		return userRepository.findAll();
	}
}
