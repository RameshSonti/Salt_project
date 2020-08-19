package com.dal.api.pojo;

public class Message {
	
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Message(String text) {
		super();
		this.text = text;
	}

	@Override
	public String toString() {
		return "Message [text=" + text + "]";
	}	
	
}
