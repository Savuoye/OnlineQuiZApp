package com.infotech.book.ticket.app.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.book.ticket.app.dao.UserRepository;
import com.infotech.book.ticket.app.entities.User;

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

}
