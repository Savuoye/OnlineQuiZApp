package com.infotech.book.ticket.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infotech.book.ticket.app.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
