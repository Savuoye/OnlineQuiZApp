package com.infotech.book.ticket.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.book.ticket.app.dao.QuestionRepository;
import com.infotech.book.ticket.app.entities.Questions;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	private final Logger logger = LoggerFactory.getLogger(QuestionService.class);

	@SuppressWarnings("unchecked")
	public Object saveQuestion(Questions questions) {

		logger.info("Adding questions into the database ::::");
		return questionRepository.save(questions);
	}

	public void deleteQuestion(Long id) {
		questionRepository.delete(id);
	}

	public Questions updateQuestion(Long id, Questions questionDetails) {

		Questions question = questionRepository.fetchByIdCustom(id)
				.orElseThrow(() -> new IllegalArgumentException("Question not found with id: " + id));

		question.setText(questionDetails.getText());
		question.setOptionA(questionDetails.getOptionA());
		question.setOptionB(questionDetails.getOptionB());
		question.setOptionC(questionDetails.getOptionC());
		question.setOptionD(questionDetails.getOptionD());
		question.setCorrectOption(questionDetails.getCorrectOption());

		logger.info("Fertching updated questions from database::::");

		return questionRepository.save(question);

	}

	public void deleteQuestions(Long id) {

		logger.info("deleting questions from database :::");
		questionRepository.delete(id);
	}
}
