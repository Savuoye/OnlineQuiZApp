package com.infotech.book.ticket.app.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

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

	/*
	 * @Autowired private PasswordEncoder passwordEncoder;
	 */

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
		// user.setPassword(passwordEncoder.encode(user.getPassword()));

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

	@SuppressWarnings("unused")
	public UserProfiles updateProfile(Long id, Map<String, Object> updateProfiles) {
		List<UserProfiles> userProfiles = userProfileRepository.findByUserId(id);

		if (userProfiles.isEmpty()) {
			throw new EntityNotFoundException("No Profile found for userId");
		}

		for (UserProfiles userProfile : userProfiles) {
			applyUpdates(userProfile, updateProfiles);
		}
		return (UserProfiles) userProfileRepository.save(userProfiles);

	}

	private void applyUpdates(UserProfiles userProfiles, Map<String, Object> updates) {
		for (Map.Entry<String, Object> entry : updates.entrySet()) {
			String key = entry.getKey();
			Object object = entry.getValue();
			switch (key) {
			case "firstName":
				userProfiles.setFirstName(castToString(object.toString()));
				break;
			case "lastName":
				userProfiles.setLastName(castToString(object.toString()));
				break;
			case "bio":
				userProfiles.setBio(castToString(object.toString()));
				break;
			case "jobTitle":
				userProfiles.setJobTitle(castToString(object.toString()));
				break;
			case "company":
				userProfiles.setCompany(castToString(object.toString()));
				break;
			case "location":
				userProfiles.setLocation(castToString(object.toString()));
				break;
			case "website":
				userProfiles.setWebsite(castToString(object.toString()));
				break;
			default:
				throw new IllegalArgumentException("Invalid field: " + key);
			}
		}

	}

	private String castToString(Object value) {
		return value != null ? value.toString() : null;
	}

}
