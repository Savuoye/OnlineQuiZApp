package com.infotech.book.ticket.request;

import java.util.List;

import com.infotech.book.ticket.app.entities.Message;

public class ChatGptRequest {

	private String model;
	private List<Message> messages;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

}
