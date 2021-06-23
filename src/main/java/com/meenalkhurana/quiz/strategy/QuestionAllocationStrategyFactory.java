package com.meenalkhurana.quiz.strategy;

public class QuestionAllocationStrategyFactory {

	private QuestionAllocationStrategyFactory() { }
	
	public static IQuestionsAllocationStrategy getQuestionAllocationStrategy() {
		IQuestionsAllocationStrategy quizCreationStrategy = null;
		quizCreationStrategy = new RandomQuestionAllocationStrategyImpl();
		return quizCreationStrategy;
	}
}
