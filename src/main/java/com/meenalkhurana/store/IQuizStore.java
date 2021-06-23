package com.meenalkhurana.store;

import com.meenalkhurana.quiz.model.Quiz;
import com.meenalkhurana.quiz.model.QuizResponse;

public interface IQuizStore {
	void storeQuiz(Quiz quiz);
	boolean containsQuiz(String quizId);
	Quiz getQuiz(String quizId);
	boolean hasUserGivenQuiz(String userId);
	QuizResponse getQuizResponseForUser(String userId);
	void storeQuizResponse(String userId, QuizResponse quizResponseForUser);
}
