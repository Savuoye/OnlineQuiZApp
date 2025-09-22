package com.infotech.book.ticket.app.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.infotech.book.ticket.app.dao.CharacterRepository;
import com.infotech.book.ticket.app.dao.UserProfileRepository;
import com.infotech.book.ticket.app.dao.UserRepository;
import com.infotech.book.ticket.app.entities.User;
import com.infotech.book.ticket.app.entities.UserProfiles;
import com.infotech.book.ticket.app.response.LoginResponse;
import com.infotech.book.ticket.request.LoginRequest;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserProfileRepository userProfileRepository;

	@Autowired
	private CharacterRepository characterRepository;

/*	@Autowired
	private PasswordEncoder passwordEncoder;*/

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
		User user = userRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
		boolean isAuthenticated = user != null;

		return new LoginResponse(user, isAuthenticated);
	}

	public void createProfile(UserProfiles userProfile) {
		if (userRepository.existsByEmail(userProfile.getEmail())) {
			throw new IllegalArgumentException("Email already registered");
		}

		User user = new User();
		user.setEmail(user.getEmail());
		//user.setPassword(passwordEncoder.encode(user.getPassword()));

		userProfile.setUser(user);
		userProfile.setFirstName(userProfile.getFirstName());
		userProfile.setLastName(userProfile.getLastName());
		userProfile.setBio(userProfile.getBio());
		userProfile.setJobTitle(userProfile.getJobTitle());
		userProfile.setCompany(userProfile.getCompany());
		userProfile.setLocation(userProfile.getLocation());
		userProfile.setWebsite(userProfile.getWebsite());

		user.setProfile(userProfile);
		userRepository.save(user);

	}

	private UserProfiles editProfile(UserProfiles userProfile) {
        UserProfiles profile = new UserProfiles();
        profile.setFirstName(userProfile.getFirstName());
        profile.setLastName(userProfile.getLastName());
        profile.setEmail(userProfile.getEmail());
        profile.setBio(userProfile.getBio());
        profile.setJobTitle(userProfile.getJobTitle());
        profile.setCompany(userProfile.getCompany());
        profile.setLocation(userProfile.getLocation());
        profile.setWebsite(userProfile.getWebsite());
        return profile;
    }
}
