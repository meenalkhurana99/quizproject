package com.meenalkhurana.store;

import java.util.HashMap;
import java.util.Map;

import com.meenalkhurana.quiz.model.Question;
import com.meenalkhurana.quiz.model.Quiz;
import com.meenalkhurana.quiz.model.QuizResponse;

public class InMemoryStoreImpl implements IQuestionStore, IQuizStore
{
	private Map<String, Question> question = null;
	private Map<String, Quiz> quiz = null;
	private Map<String, QuizResponse> userIdToQuizResponseMap = null;
	
	public InMemoryStoreImpl() {
		this.question = new HashMap<>();
		this.quiz = new HashMap<>();
		this.userIdToQuizResponseMap = new HashMap<>();
	}
	
	@Override
	public void storeQuestion(Question question) {
		this.question.put(question.getQuestion(), question);
		
	}

	@Override
	public boolean containsQuestion(String question) {
		return this.question.containsKey(question);
	}

	@Override
	public void storeQuiz(Quiz quiz) {
		this.quiz.put(quiz.getId(), quiz);
	}

	@Override
	public Question getQuestion(String questionStr) {
		return this.question.get(questionStr);
	}

	@Override
	public boolean containsQuiz(String quizId) {
		return this.quiz.containsKey(quizId);
	}

	@Override
	public Quiz getQuiz(String quizId) {
		return this.getQuiz(quizId);
	}

	@Override
	public boolean hasUserGivenQuiz(String userId) {
		return this.userIdToQuizResponseMap.containsKey(userId);
	}

	@Override
	public QuizResponse getQuizResponseForUser(String userId) {
		return this.userIdToQuizResponseMap.get(userId);
	}

	@Override
	public void storeQuizResponse(String userId, QuizResponse quizResponseForUser) {
		this.userIdToQuizResponseMap.put(userId, quizResponseForUser);
	}

	@Override
	public Map<String, Question> getAllQuestions() {
		return this.question;
	}
}
