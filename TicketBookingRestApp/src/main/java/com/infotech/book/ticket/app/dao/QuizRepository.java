package com.infotech.book.ticket.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.infotech.book.ticket.app.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
	@Query("SELECT q FROM Quiz q WHERE q.id = :id")
	Optional<Quiz> findQuizById(@Param("id") Long id);

}
