package com.meenalkhurana.quiz.exceptions;

public class NoQuizExistException extends Exception
{
	private String errorMessage = null;
	
	public NoQuizExistException(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	@Override
	public String getMessage() {
		return this.errorMessage;
	}
}
