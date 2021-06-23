package com.meenalkhurana.quiz.exceptions;

public class NoSuchOptionExist extends Exception {
	private String errorMessage = null;
	
	public NoSuchOptionExist(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	@Override
	public String getMessage() {
		return this.errorMessage;
	}
}
