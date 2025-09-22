package com.infotech.book.ticket.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infotech.book.ticket.app.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);

	User findByUsernameAndPassword(String username, String password);

	boolean existsByEmail(String email);

}
