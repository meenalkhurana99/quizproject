package com.meenalkhurana.quiz.model;

import java.util.Set;

/**
 * Class which defines the question
 * @author meenal.khurana
 *
 */
public class Question 
{
	/**
	 * The question added by the user
	 */
	private String question;
	/**
	 * The creator of the question
	 */
	private String createdBy;
	/**
	 * Multiple choice options of the question
	 */
	private Set<String> multipleChoiceOptions;
	public Set<String> getMultipleChoiceOptions() {
		return multipleChoiceOptions;
	}

	/**
	 * Correct answer out of all the options
	 */
	private String correctAnswer = null;
	
	public Question(String question, String createdBy, Set<String> multipleChoiceOptions) {
		this.question = question;
		this.createdBy = createdBy;
		this.multipleChoiceOptions = multipleChoiceOptions;
	}
	
	public String getQuestion() {
		return this.question;
	}
	
	public String getCreatedBy() {
		return this.createdBy;
	}
	
	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String answer) {
		this.correctAnswer = answer;
	}
	
	@Override
	public String toString() {
		return "Question [question=" + question + ", createdBy=" + createdBy + ", multipleChoiceOptions="
				+ multipleChoiceOptions + ", correctAnswer=" + correctAnswer + "]";
	}

	public boolean containsAnswer(String answer) {
		return this.multipleChoiceOptions.contains(answer);
	}

}
