package com.infotech.book.ticket.app.response;

import com.infotech.book.ticket.app.entities.User;

public class LoginResponse {

	private User user;
	private boolean isAuthenticated;

	public LoginResponse(User user, boolean isAuthenticated) {
		this.user = user;
		this.isAuthenticated = isAuthenticated;
	}

	public User getUser() {
		return user;
	}

	public boolean isAuthenticated() {
		return isAuthenticated;
	}

}
