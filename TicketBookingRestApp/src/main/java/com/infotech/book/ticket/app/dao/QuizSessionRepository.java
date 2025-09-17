package com.infotech.book.ticket.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infotech.book.ticket.app.entities.QuizSession;

public interface QuizSessionRepository extends JpaRepository<QuizSession, String> {

	Optional<QuizSession> findByCodeAndActiveTrue(String code);
	boolean existsByCode(String code);

}
