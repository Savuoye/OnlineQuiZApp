package com.infotech.book.ticket.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infotech.book.ticket.app.entities.Questions;
import com.infotech.book.ticket.app.entities.UserProfiles;

//@SuppressWarnings("hiding")
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfiles, Long> {

	@Query("SELECT q FROM UserProfiles q WHERE q.user.id = :userId")
	List<UserProfiles> findByUserId(Long userId);
}
