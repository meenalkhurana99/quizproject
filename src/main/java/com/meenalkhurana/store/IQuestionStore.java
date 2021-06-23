package com.meenalkhurana.store;

import java.util.Map;

import com.meenalkhurana.quiz.model.Question;

public interface IQuestionStore 
{
	void storeQuestion(Question question);
	boolean containsQuestion(String question);
	Question getQuestion(String questionStr);
	Map<String, Question> getAllQuestions();
}
