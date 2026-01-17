package com.infotech.book.ticket.app.entities;

import java.util.Map;

public class QuizSubmission {
	private Long quizId;
	private Map<Long, java.lang.Character> answers; // Question ID -> Answer ('A', 'B', 'C' , 'D')

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	public Map<Long, java.lang.Character> getAnswers() {
		return answers;
	}

	public void setAnswers(Map<Long, java.lang.Character> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "QuizSubmission [quizId=" + quizId + ", answers=" + answers + "]";
	}

}
