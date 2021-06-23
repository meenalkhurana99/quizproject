package com.meenalkhurana.quiz.manager;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.meenalkhurana.quiz.exceptions.NoQuizExistException;
import com.meenalkhurana.quiz.model.Question;
import com.meenalkhurana.quiz.model.Quiz;
import com.meenalkhurana.quiz.model.QuizResponse;
import com.meenalkhurana.quiz.model.QuizResult;
import com.meenalkhurana.quiz.model.Response;
import com.meenalkhurana.quiz.strategy.IQuestionsAllocationStrategy;
import com.meenalkhurana.store.IQuizStore;

public class QuizManager 
{
	private QuestionManager questionManager = null;
	private IQuizStore iQuizStore = null;
	private IQuestionsAllocationStrategy iQuestionAllocationStrategy = null;
	
	private final int MIN_CORRECT_ANSWERED_QUESTIONS_PERCENTAGE_TO_PASS = 50;
	
	public QuizManager(QuestionManager questionManager, IQuizStore quizStore, 
			IQuestionsAllocationStrategy questionAllocationStrategy) {
		this.questionManager = questionManager;
		this.iQuizStore = quizStore;
		this.iQuestionAllocationStrategy = questionAllocationStrategy;
	}
	
	public Quiz createQuiz() throws NoQuizExistException {
		Map<String, Question> allQuestion = questionManager.getAllQuestions();
		if(null == allQuestion || allQuestion.isEmpty())
		{
			throw new NoQuizExistException("No questions exist in the system to create a quiz.");
		}
		
		Set<Question> questions = this.iQuestionAllocationStrategy.getQuestionsForQuiz(allQuestion);
		Quiz quiz = new Quiz(UUID.randomUUID().toString(), questions);
		iQuizStore.storeQuiz(quiz);
		return quiz;
	}
	
	public void addResponse(String quizId, String userId, Map<String, String> questionToResponseMap)
			throws NoQuizExistException {
		if( ! iQuizStore.containsQuiz(quizId)) {
			throw new NoQuizExistException("No such quiz exist in the system");
		}

		Quiz quiz = iQuizStore.getQuiz(quizId);
		Response response = new Response
				(UUID.randomUUID().toString(), userId, System.currentTimeMillis(), questionToResponseMap);
		
		QuizResponse quizResponseForUser = null;
		/*
		 * A user can give a quiz multiple times. So in case
		 * the user is giving the same quiz again, a new response will 
		 * be recorded in the QuizResponse object. Otherwise a new QuizResponse
		 * object will be created.
		 */
		if( iQuizStore.hasUserGivenQuiz(quizId)) {
			quizResponseForUser = iQuizStore.getQuizResponseForUser(userId);
		}
		else {
			quizResponseForUser = new QuizResponse(quizId);
		}
		quizResponseForUser.addResponse(response);
		
		QuizResult result = evaluateResult(questionToResponseMap, quiz.getQuestions());
		quizResponseForUser.setResultForResponse(response.getId(), result);
		
		iQuizStore.storeQuizResponse(userId, quizResponseForUser);
	}

	private QuizResult evaluateResult(Map<String, String> questionToResponseMap, Set<Question> questionsOfQuiz) 
	{
		int correctAnswer = 0;
		for(Question questionOfQuiz : questionsOfQuiz)
		{
			String responseGivenByUser = questionToResponseMap.get(questionOfQuiz.getQuestion());
			if(responseGivenByUser.equals(questionOfQuiz.getCorrectAnswer())) {
				correctAnswer ++;
			}
		}
		
		double percentOfCorrectAnswers = (correctAnswer/questionsOfQuiz.size())*100;
		if(percentOfCorrectAnswers >= MIN_CORRECT_ANSWERED_QUESTIONS_PERCENTAGE_TO_PASS) {
			return QuizResult.PASS;
		}
		else {
			return QuizResult.FAIL;
		}
	}
}

