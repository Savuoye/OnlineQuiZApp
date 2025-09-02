package com.infotech.book.ticket.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infotech.book.ticket.app.entities.Questions;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Long>, CrudRepository<Questions, Long> {

	@Query("SELECT q FROM Questions q WHERE q.id = :id")
	Optional<Questions> fetchByIdCustom(Long id);

}
