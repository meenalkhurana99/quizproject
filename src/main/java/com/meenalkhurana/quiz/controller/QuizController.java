package com.meenalkhurana.quiz.controller;

import java.util.Set;

import com.meenalkhurana.quiz.exceptions.NoQuestionExistException;
import com.meenalkhurana.quiz.exceptions.NoQuizExistException;
import com.meenalkhurana.quiz.exceptions.NoSuchOptionExist;
import com.meenalkhurana.quiz.exceptions.QuestionAlreadyExistException;
import com.meenalkhurana.quiz.manager.QuestionManager;
import com.meenalkhurana.quiz.manager.QuizManager;
import com.meenalkhurana.quiz.model.Question;
import com.meenalkhurana.quiz.model.Quiz;
import com.meenalkhurana.quiz.strategy.IQuestionsAllocationStrategy;
import com.meenalkhurana.quiz.strategy.QuestionAllocationStrategyFactory;
import com.meenalkhurana.store.IQuestionStore;
import com.meenalkhurana.store.IQuizStore;
import com.meenalkhurana.store.StoreFactory;

public class QuizController 
{
	private QuestionManager questionManager = null;
	private QuizManager quizManager = null;
	private static QuizController quizController = null;
	
	private QuizController() { }
	
	public static QuizController getInstance() {
		
		if(quizController == null)
		{
			synchronized (QuizController.class) {
				quizController = new QuizController();
				quizController.init();
			}
		}
		
		return quizController;
	}

	private void init() {
		IQuestionStore questionStore = StoreFactory.getQuestionStore();
		IQuizStore quizStore = StoreFactory.getQuizStore();
		IQuestionsAllocationStrategy questionAllocationStrategy = QuestionAllocationStrategyFactory.getQuestionAllocationStrategy();
		questionManager = new QuestionManager(questionStore);
		quizManager = new QuizManager(questionManager, quizStore, questionAllocationStrategy);
	}
	
	public Question createQuestion(String userId, String questionStr, Set<String> multipleChoiceOptions) {
		Question question = null;
		try {
			question = questionManager.createQuestion(userId, questionStr, multipleChoiceOptions);
		} catch (QuestionAlreadyExistException e) {
			System.out.print(e.getMessage());
		}
		return question;
	}
	
	public void setAnswerToQuestion(String questionStr, String answer) {
		try {
			questionManager.setAnswerToQuestion(questionStr, answer);
		} catch (NoQuestionExistException | NoSuchOptionExist e) {
			System.out.print(e.getMessage());
		}
	}
	
	public Quiz createQuiz() {
		Quiz quiz = null;
		
		try {
			quiz = quizManager.createQuiz();
		} catch (NoQuizExistException e) {
			System.out.print(e.getMessage());
		}
		
		return quiz;
	}
}
