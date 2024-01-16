package com.SpringBootProject.service;


import com.SpringBootProject.entity.QuestionEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionService
{
    // CREATE QUESTION REST API
    String createQuestion(QuestionEntity questionEntity);

    // CREATE ALL QUESTIONS REST API
    List<QuestionEntity> createAllQuestions(List<QuestionEntity> allQuestion);

    // FETCH A QUESTION BY ID REST API
    QuestionEntity getQuestionsById(Integer getQuestionsBasedOnId);

    // FETCH ALL QUESTIONS REST API
    ResponseEntity<List<QuestionEntity>> getListOfQuestions();

    // FETCH LIST OF QUESTIONS BASED ON CATEGORY REST API
    List<QuestionEntity> fetchQuestionsByCategory(String categoryQuestions);
}
