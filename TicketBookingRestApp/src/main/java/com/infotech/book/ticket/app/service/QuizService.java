package com.infotech.book.ticket.app.service;

import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.infotech.book.ticket.app.entities.Quiz;

public interface QuizService {

	void uploadQuizFromCSV(MultipartFile file);
}
