package com.infotech.book.ticket.app.service;

import java.util.List;

import com.infotech.book.ticket.app.entities.Questions;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.book.ticket.app.dao.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@SuppressWarnings("unchecked")
	public Object saveQuestion(Questions questions) {
		return questionRepository.save(questions);
	}

}
