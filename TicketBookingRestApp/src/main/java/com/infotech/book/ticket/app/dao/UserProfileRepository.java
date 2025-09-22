package com.infotech.book.ticket.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infotech.book.ticket.app.entities.UserProfiles;

@SuppressWarnings("hiding")
public interface UserProfileRepository extends JpaRepository<UserProfiles, Long> {

	Optional<UserProfiles> findByEmail(String email);
}
