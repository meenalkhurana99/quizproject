package com.meenalkhurana.quiz.model;

import java.util.Map;

public class Response 
{
	private String id = null;
	private long submissionTime = 0;
	private Map<String, String> questionToAnswerMap = null;
	
	public Response(String id, String submittedBy, long submissionTime, 
			Map<String, String> questionToAnswerMap) {
		this.id = id;
		this.submissionTime = submissionTime;
		this.questionToAnswerMap = questionToAnswerMap;
	}
	
	public String getId() {
		return id;
	}
	
	public long getSubmissionTime() {
		return this.submissionTime;
	}
	
	public Map<String, String> getQuestionToAnswerMap() {
		return questionToAnswerMap;
	}
}
