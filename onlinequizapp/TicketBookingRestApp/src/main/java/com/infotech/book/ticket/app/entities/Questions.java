package com.infotech.book.ticket.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "questions")
public class Questions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@NotBlank(message = "Question text must not be blank")
	@Column(name = "text")
	private String text;

	@NotBlank(message = "Option A must not be blank")
	@Column(name = "optionA")
	private String optionA;

	@NotBlank(message = "Option B must not be blank")
	@Column(name = "optionB")
	private String optionB;

	@NotBlank(message = "Option C must not be blank")
	@Column(name = "optionC")
	private String optionC;

	@NotBlank(message = "Option D must not be blank")
	@Column(name = "optionD")
	private String optionD;

	@Pattern(regexp = "A|B|C|D", message = "Correct option must be one of A, B, C, or D")
	@Column(name = "correctOption")
	private String correctOption;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "quiz_id") // or true, based on design
	private Quiz quiz;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String explanation;

	@Column(columnDefinition = "category")
	private String category;

	@Column(columnDefinition = "difficulty")
	private String difficulty;

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

}
