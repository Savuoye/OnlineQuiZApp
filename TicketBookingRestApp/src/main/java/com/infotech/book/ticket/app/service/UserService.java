package com.infotech.book.ticket.app.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.book.ticket.app.dao.UserRepository;
import com.infotech.book.ticket.app.entities.User;
import com.infotech.book.ticket.app.response.LoginResponse;
import com.infotech.book.ticket.request.LoginRequest;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	private final Logger logger = LoggerFactory.getLogger(UserService.class);

	public User createUser(User user) {
		logger.info("Create User");
		return userRepository.save(user);
	}

	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public List<User> getAllUsers() {
		logger.info("Fetch all data from database :::::");
		return userRepository.findAll();
	}

	public LoginResponse authenticateUser(LoginRequest loginRequest) {
		User user = userRepository.findByUserNameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
		boolean isAuthenticated = user != null;

		return new LoginResponse(user, isAuthenticated);
	}

}
