package com.meenalkhurana.quiz.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizResponse 
{
	private String quizId = null;
	private List<Response> responses = null;
	private Map<String, QuizResult> responseIdToResultMap = null;
	
	public QuizResponse(String quizId) {
		this.quizId = quizId;
		this.responses = new ArrayList<>();
		this.responseIdToResultMap = new HashMap<>();
	}
	
	public void resultPass(String quizId) {
		this.responseIdToResultMap.put(quizId, QuizResult.PASS);
	}
	
	public void resultFail(String quizId) {
		this.responseIdToResultMap.put(quizId, QuizResult.FAIL);
	}
	
	public String getQuizId() {
		return quizId;
	}
	
	public List<Response> getResponses() {
		return responses;
	}

	public Map<String, QuizResult> getResponseIdToResultMap() {
		return responseIdToResultMap;
	}

	public void addResponse(Response response) {
		this.responses.add(response);
	}
	
	public void setResultForResponse(String responseId, QuizResult result) {
		this.responseIdToResultMap.put(responseId, result);
	}
}
