package com.infotech.book.ticket.app.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;

@Entity
@Table(name = "quiz")
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "quiz_url", unique = true)
	private String quizUrl;

	@Column(name = "description", length = 1000)
	private String description;

	@Column(name = "duration_in_seconds")
	private int durationInSeconds;

	@Column(name = "start_datetime")
	private LocalDateTime startDateTime;

	@Column(name = "end_datetime")
	private LocalDateTime endDateTime;

	@Column(name = "time_zone")
	private String timeZone;

	@Column(name = "quiz_mode")
	private String quizMode;

	@OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Questions> questions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getQuizUrl() {
		return quizUrl;
	}

	public void setQuizUrl(String quizUrl) {
		this.quizUrl = quizUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDurationInSeconds() {
		return durationInSeconds;
	}

	public void setDurationInSeconds(int durationInSeconds) {
		this.durationInSeconds = durationInSeconds;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getQuizMode() {
		return quizMode;
	}

	public void setQuizMode(String quizMode) {
		this.quizMode = quizMode;
	}

	public List<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Quiz [id=" + id + ", title=" + title + ", quizUrl=" + quizUrl + ", description=" + description
				+ ", durationInSeconds=" + durationInSeconds + ", startDateTime=" + startDateTime + ", endDateTime="
				+ endDateTime + ", timeZone=" + timeZone + ", quizMode=" + quizMode + ", questions=" + questions + "]";
	}

}
