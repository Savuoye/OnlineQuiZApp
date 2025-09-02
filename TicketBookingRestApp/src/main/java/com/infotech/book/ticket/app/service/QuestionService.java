package com.infotech.book.ticket.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.book.ticket.app.dao.QuestionRepository;
import com.infotech.book.ticket.app.entities.Questions;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@SuppressWarnings("unchecked")
	public Object saveQuestion(Questions questions) {
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
		return questionRepository.save(question);
	}

	public void deleteQuestions(Long id) {
		questionRepository.delete(id);
	}
}
