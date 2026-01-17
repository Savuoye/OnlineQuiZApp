package com.infotech.book.ticket.app.service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.book.ticket.app.dao.QuestionRepository;
import com.infotech.book.ticket.app.entities.Questions;

@Service
public class CsvExportService {

	@Autowired
	private QuestionRepository questionRepository;

	private final Logger logger = LoggerFactory.getLogger(CsvExportService.class);

	public void writeQuestionsToCsv(OutputStream outputStream) throws IOException {
		List<Questions> questions = questionRepository.findAll();
		try (OutputStreamWriter streamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
				BufferedWriter writer = new BufferedWriter(streamWriter);
				CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Question", "OptionA",
						"OptionB", "OptionC", "OptionD", "CorrectAnswer", "Category", "Difficulty"))) {
			for (Questions q : questions) {
				csvPrinter.printRecord(safe(q.getOptionA()), safe(q.getOptionB()),
						safe(q.getOptionC()), safe(q.getOptionD()), safe(q.getText()), safe(q.getCorrectOption()),
						safe(q.getCategory()), safe(q.getExplanation()), safe(q.getDifficulty()));
			}
			csvPrinter.flush();
		}

	}

	// Optional helper to avoid nulls in CSV
	private String safe(String value) {
		return value == null ? "" : value.trim();
	}

}
