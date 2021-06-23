package com.meenalkhurana.quiz.manager;

import java.util.Map;
import java.util.Set;

import com.meenalkhurana.quiz.exceptions.NoQuestionExistException;
import com.meenalkhurana.quiz.exceptions.NoSuchOptionExist;
import com.meenalkhurana.quiz.exceptions.QuestionAlreadyExistException;
import com.meenalkhurana.quiz.model.Question;
import com.meenalkhurana.store.IQuestionStore;

public class QuestionManager 
{
	private IQuestionStore iQuestionStore = null;
	
	public QuestionManager(IQuestionStore dataStore) {
		this.iQuestionStore = dataStore;
	}
	
	public Question createQuestion(String userId, String questionStr, Set<String> multipleChoiceOptions) 
			throws QuestionAlreadyExistException {
		if(iQuestionStore.containsQuestion(questionStr)) {
			throw new QuestionAlreadyExistException("The question already exist");
		}
		
		Question questionObj = new Question(questionStr, userId, multipleChoiceOptions);
		this.iQuestionStore.storeQuestion(questionObj);
		return questionObj;
	}
	
	public void setAnswerToQuestion(String questionStr, String answer) throws NoQuestionExistException, NoSuchOptionExist {
		if( ! iQuestionStore.containsQuestion(questionStr)) {
			throw new NoQuestionExistException("The question does not exist");
		}
		
		Question question = iQuestionStore.getQuestion(questionStr);
		if( ! question.containsAnswer(answer)) {
			throw new NoSuchOptionExist("No such option exist");
		}
		
		question.setCorrectAnswer(answer);
		iQuestionStore.storeQuestion(question);
	}

	public Map<String, Question> getAllQuestions() {
		return iQuestionStore.getAllQuestions();
	}
}
