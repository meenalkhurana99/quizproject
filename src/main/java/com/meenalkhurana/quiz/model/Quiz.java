package com.meenalkhurana.quiz.model;

import java.util.Set;

public class Quiz 
{
	private String id;
	private Set<Question> questions;
	
	public Quiz(String id, Set<Question> questions) {
		this.id = id;
		this.questions = questions;
	}
	
	public String getId() {
		return id;
	}
	public Set<Question> getQuestions() {
		return questions;
	}
	

}
