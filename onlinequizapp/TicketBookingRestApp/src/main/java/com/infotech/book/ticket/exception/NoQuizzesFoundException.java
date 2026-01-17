package com.infotech.book.ticket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT) // Or HttpStatus.NOT_FOUND if preferred
public class NoQuizzesFoundException extends RuntimeException {
	public NoQuizzesFoundException(String message) {
		super(message);
	}

}
