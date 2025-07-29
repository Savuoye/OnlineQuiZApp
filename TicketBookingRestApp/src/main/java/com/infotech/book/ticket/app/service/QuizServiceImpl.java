package com.infotech.book.ticket.app.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.infotech.book.ticket.app.dao.QuizRepository;
import com.infotech.book.ticket.app.entities.Questions;
import com.infotech.book.ticket.app.entities.Quiz;

@Service
public class QuizServiceImpl {

	@Autowired
	private QuizRepository quizRepo;

	public void uploadQuizFromCSV(MultipartFile file) {

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			String line;
			Quiz quiz = new Quiz();
			quiz.setTitle("Uploaded Quiz");
			quiz.setDurationInSeconds(60);
			List<Questions> questions = new ArrayList<>();

			reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				Questions q = new Questions();
				q.setText(data[0]);
				q.setOptionA(data[1]);
				q.setOptionB(data[2]);
				q.setOptionC(data[3]);
				q.setOptionD(data[4]);
				q.setCorrectOption(data[5]);
				q.setQuiz(quiz);
				questions.add(q);
			}
			quiz.setQuestions(questions);
			quizRepo.save(quiz);

		} catch (IOException ex) {
			throw new RuntimeException("Failed to parse CSV", ex);
		}

	}

	public Quiz getQuizById(Long quizId) {
		// TODO Auto-generated method stub
		return null;
	}

}
