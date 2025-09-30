package com.infotech.book.ticket.app.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.infotech.book.ticket.app.entities.UserProfiles;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfiles, Long> {

	@Query("SELECT q FROM UserProfiles q WHERE q.user.id = :userId")
	List<UserProfiles> findByUserId(Long userId);

	@Modifying
	@Transactional
	@Query("DELETE FROM UserProfiles u WHERE u.id = :id")
	void deleteProfileById(@Param("id") Long id);

}
