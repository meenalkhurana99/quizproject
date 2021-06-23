package com.meenalkhurana.quiz.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.meenalkhurana.quiz.model.Question;

public class RandomQuestionAllocationStrategyImpl implements IQuestionsAllocationStrategy
{
	@Override
	public Set<Question> getQuestionsForQuiz(Map<String, Question> questionsMap) {
		List<String> questionIds = new ArrayList<>(questionsMap.keySet());
		
		Collections.shuffle(questionIds);
		Set<String> randomSet = new HashSet<String>(questionIds.subList(0, 1));
		
		Set<Question> questions = new LinkedHashSet<>();
		for(String id : randomSet) {
			questions.add(questionsMap.get(id));
		}
		
		return questions;
	}

}
