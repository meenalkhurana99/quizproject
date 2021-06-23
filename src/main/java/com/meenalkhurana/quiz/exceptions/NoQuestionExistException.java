package com.meenalkhurana.quiz.exceptions;

public class NoQuestionExistException extends Exception {
	private String errorMessage = null;
	
	public NoQuestionExistException(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	@Override
	public String getMessage() {
		return this.errorMessage;
	}
}
