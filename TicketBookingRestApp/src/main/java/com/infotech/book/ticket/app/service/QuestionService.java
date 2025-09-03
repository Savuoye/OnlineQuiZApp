package com.infotech.book.ticket.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		List<Questions> question = questionRepository.fetchByIdCustom(id);
		// .orElseThrow(() -> new IllegalArgumentException("Question not found with id:
		// " + id));

		((Questions) question).setText(questionDetails.getText());
		((Questions) question).setOptionA(questionDetails.getOptionA());
		((Questions) question).setOptionB(questionDetails.getOptionB());
		((Questions) question).setOptionC(questionDetails.getOptionC());
		((Questions) question).setOptionD(questionDetails.getOptionD());
		((Questions) question).setCorrectOption(questionDetails.getCorrectOption());

		logger.info("Fertching updated questions from database::::");

		return (Questions) questionRepository.save(question);

	}

	public void deleteQuestions(Long id) {

		logger.info("deleting questions from database :::");
		questionRepository.delete(id);
	}

	public Map<Long, String> getCorrectAnswers(Long id) {
		List<Questions> questions = questionRepository.fetchByIdCustom(id);
		Map<Long, String> correctAnswers = new HashMap<>();
		for (Questions question : questions) {
			correctAnswers.put(question.getId(), question.getCorrectOption());
			logger.info("Question ID : " + question.getId() + "Correct Answer :" + question.getCorrectOption());
		}
		return correctAnswers;
	}
}
