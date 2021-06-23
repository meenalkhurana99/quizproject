package com.meenalkhurana.quiz.strategy;

import java.util.Map;
import java.util.Set;

import com.meenalkhurana.quiz.model.Question;

public interface IQuestionsAllocationStrategy 
{
	Set<Question> getQuestionsForQuiz(Map<String, Question> questions);
}
