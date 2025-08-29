package com.infotech.book.ticket.app.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.infotech.book.dao.UploadResult;
import com.infotech.book.ticket.app.dao.QuizRepository;
import com.infotech.book.ticket.app.entities.Questions;
import com.infotech.book.ticket.app.entities.Quiz;
import com.infotech.book.ticket.exception.NoQuizzesFoundException;

@Service
public class QuizServiceImpl {

	@Autowired
	private QuizRepository quizRepo;

	@Autowired
	private Validator validator;

	public UploadResult uploadQuizFromCSV(MultipartFile file) {

		List<Questions> questions = new ArrayList<>();
		List<String> errorRows = new ArrayList<>();
		Quiz quiz = new Quiz();
		quiz.setTitle("Uploaded Quiz");
		quiz.setDurationInSeconds(60);
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			String line;
			int rowNum = 1;
			reader.readLine();
			while ((line = reader.readLine()) != null) {
				rowNum++;
				String[] data = line.split(",");
				if (data.length < 6) {
					errorRows.add("Row " + rowNum + " has insufficient columns");
					continue;
				}
				Questions q = new Questions();
				q.setText(data[0]);
				q.setOptionA(data[1]);
				q.setOptionB(data[2]);
				q.setOptionC(data[3]);
				q.setOptionD(data[4]);
				q.setCorrectOption(data[5]);
				q.setQuiz(quiz);

				Set<ConstraintViolation<Questions>> violations = validator.validate(q);
				if (!violations.isEmpty()) {
					String errorMsg = violations.stream().map(v -> v.getPropertyPath() + ": " + v.getMessage())
							.collect(Collectors.joining("; "));
					errorRows.add("Row " + rowNum + " error: " + errorMsg);
					continue;
				}
				questions.add(q);
			}
			quiz.setQuestions(questions);
			quizRepo.save(quiz);

		} catch (IOException ex) {
			throw new RuntimeException("Failed to parse CSV", ex);
		}
		return new UploadResult(questions.size(), errorRows);

	}
	

	public List<Quiz> getAllQuizzes() {
		List<Quiz> quizzes = quizRepo.findAll();
		if (quizzes == null || quizzes.isEmpty()) {
			throw new NoQuizzesFoundException("No quizzes available in the system.");
		}
		return quizzes;
		
	}

}
