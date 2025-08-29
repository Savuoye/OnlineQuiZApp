package com.infotech.book.ticket.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infotech.book.ticket.app.entities.Questions;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Long> {
	
	Questions findById(long id); 
	 Optional<Questions> findByQuestionId(Long quizId);
}
