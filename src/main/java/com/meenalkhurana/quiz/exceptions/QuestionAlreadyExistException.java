package com.meenalkhurana.quiz.exceptions;

public class QuestionAlreadyExistException extends Exception
{
	private String errorMessage = null;
	
	public QuestionAlreadyExistException(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	@Override
	public String getMessage() {
		return this.errorMessage;
	}
}
