package com.meenalkhurana.quiz;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

import com.meenalkhurana.quiz.controller.QuizController;
import com.meenalkhurana.quiz.model.Question;
import com.meenalkhurana.quiz.model.Quiz;

/**
 * Unit test for simple App.
 */
public class MainTest 
{
	QuizController quizController = QuizController.getInstance();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        Set<String> question1Options = new LinkedHashSet<>();
        question1Options.add("Delhi");
        question1Options.add("Mumbai");
        question1Options.add("Bangalore");
        question1Options.add("Bhopal");
        
        Question question1 = quizController.createQuestion("meenal", "What is the capital of India?", question1Options);
        System.out.println("Question created: " + question1.toString());
        quizController.setAnswerToQuestion(question1.getQuestion(), "Delhi");
        
        Set<String> question2Options = new LinkedHashSet<>();
        question2Options.add("Lion");
        question2Options.add("Leopard");
        question2Options.add("Tiger");
        question2Options.add("Elephant");
        
        Question question2 = quizController.createQuestion("meenal", "Which is the national animal of India", question2Options);
        System.out.println("Question created: " + question2.toString());
        quizController.setAnswerToQuestion(question2.getQuestion(), "Tiger");
        
        Quiz quiz = quizController.createQuiz();
        assertNotNull(question1);
        assertNotNull(question2);
        assertNotNull(quiz);
    }
}
