package com.infotech.book.ticket.app.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.infotech.book.dao.UploadResult;
import com.infotech.book.ticket.app.dao.QuizRepository;
import com.infotech.book.ticket.app.dao.QuizResultRepository;
import com.infotech.book.ticket.app.dao.QuizSessionRepository;
import com.infotech.book.ticket.app.entities.Questions;
import com.infotech.book.ticket.app.entities.Quiz;
import com.infotech.book.ticket.app.entities.QuizResult;
import com.infotech.book.ticket.app.entities.QuizSession;
import com.infotech.book.ticket.app.entities.QuizSubmission;
import com.infotech.book.ticket.app.entities.User;
import com.infotech.book.ticket.exception.NoQuizzesFoundException;

@Service
public class QuizServiceImpl {

	@Autowired
	private QuizRepository quizRepository;

	@Autowired
	private QuizResultRepository quizResultRepository;

	@Autowired
	private QuizSessionRepository quizSessionRepo;

	@Autowired
	private Validator validator;

	private final Logger logger = LoggerFactory.getLogger(QuizServiceImpl.class);

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
			quizRepository.save(quiz);

		} catch (IOException ex) {
			throw new RuntimeException("Failed to parse CSV", ex);
		}

		logger.info("Uploading bulk questions from the database:::");

		return new UploadResult(questions.size(), errorRows);

	}

	public List<Quiz> getAllQuizzes() {
		List<Quiz> quizzes = quizRepository.findAll();
		if (quizzes == null || quizzes.isEmpty()) {
			throw new NoQuizzesFoundException("No quizzes available in the system.");
		}

		logger.info("Getting all quizzes from the database:::");
		return quizzes;

	}

	public Quiz getQuizById(Long id) {
		logger.info("Getting quizzes in the form  of id  from the database:::");
		return quizRepository.findQuizById(id);
	}

	public QuizResult saveQuizResult(User user, Quiz quiz, int score) {
		QuizResult quizResult = new QuizResult();
		quizResult.setUser(user);
		quizResult.setQuiz(quiz);
		quizResult.setScore(score);

		logger.info("Saving quiz result into the database :::::");

		return quizResultRepository.save(quizResult);
	}

	@SuppressWarnings("unused")
	private int evaluateSubmission(QuizSubmission quizSubmission) {
		int correctAnswer = 0;
		int wrongAnswer = 0;
		Quiz quiz = getQuizById(quizSubmission.getQuizId());
		Map<Long, Character> submittedAnswers = quizSubmission.getAnswers();
		for (Questions questions : quiz.getQuestions()) {
			Long questionId = questions.getId();
			String correctOption = questions.getCorrectOption().toUpperCase();
			if (submittedAnswers.containsKey(questionId)) {
				String submittedOption = String.valueOf(Character.toUpperCase(submittedAnswers.get(questionId)));
				if (submittedOption == correctOption) {
					correctAnswer++;
				} else {
					wrongAnswer++;

				}

			}

		}
		logger.info("Evaluating submission logic :::::");
		return correctAnswer;
	}

	public String generateJoinCode() {
		String code;
		do {
			code = String.format("%06d", new Random().nextInt(1_000_000));
		} while (quizSessionRepo.existsByCode(code));
		return code;

	}

	public QuizSession createSession(Long quizId) {
		Quiz quiz = quizRepository.findQuizById(quizId);

		QuizSession session = new QuizSession();
		session.setCode(generateJoinCode());
		session.setQuiz(quiz);
		session.setStartTime(LocalDateTime.now());
		session.setEndTime(LocalDateTime.now().plusMinutes(quiz.getDurationInSeconds()));
		session.setActive(true);

		return quizSessionRepo.save(session);

	}

	public QuizSession validateJoinCode(String code) {
		if (!code.matches("\\d{6}")) {
			throw new IllegalArgumentException("Invalid code format");
		}

		return quizSessionRepo.findByCodeAndActiveTrue(code)
				.filter(session -> session.getEndTime().isAfter(LocalDateTime.now()))
				.orElseThrow(() -> new EntityNotFoundException("Quiz not found or expired"));
	}
}
