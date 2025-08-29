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
		Questions questions = questionRepository.findById(id);

		questions.setText(questionDetails.getText());
		questions.setOptionA(questionDetails.getOptionA());
		questions.setOptionB(questionDetails.getOptionB());
		questions.setOptionC(questionDetails.getOptionC());
		questions.setOptionD(questionDetails.getOptionD());
		questions.setCorrectOption(questionDetails.getCorrectOption());

		return questionRepository.save(questions);
	}

}
