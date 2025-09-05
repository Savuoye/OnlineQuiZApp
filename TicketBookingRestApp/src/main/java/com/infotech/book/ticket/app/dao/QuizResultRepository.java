package com.infotech.book.ticket.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infotech.book.ticket.app.entities.QuizResult;

public interface QuizResultRepository extends JpaRepository<QuizResult, Long> {
}
