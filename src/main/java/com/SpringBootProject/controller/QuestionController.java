package com.SpringBootProject.controller;


import com.SpringBootProject.entity.QuestionEntity;
import com.SpringBootProject.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api")
public class QuestionController
{
    private QuestionService questionService;

    // CREATE QUESTION REST API
    // http://localhost:8080/api/postQuestions
    @PostMapping("postQuestions")
    public ResponseEntity<String> createQuestion(@RequestBody QuestionEntity questionEntity)
    {
        return new ResponseEntity<>(questionService.createQuestion(questionEntity),
                HttpStatus.CREATED);
    }

    // CREATE LIST OF QUESTION REST API
    // http://localhost:8080/api/postAllQuestions
    @PostMapping("postAllQuestions")
    public ResponseEntity<List<QuestionEntity>> createAllQuestions(@RequestBody List<QuestionEntity> allQuestion)
    {
        List<QuestionEntity> allQuestions = questionService.createAllQuestions(allQuestion);
        return new ResponseEntity<>(allQuestions,HttpStatus.CREATED);
    }

    // FETCH A QUESTION BASED ON ID
    // http://localhost:8080/api/fetchQuestionsBasedOnId/2
    @GetMapping("fetchQuestionsBasedOnId/{id}")
    public ResponseEntity<QuestionEntity> getQuestionsById(@PathVariable("id") Integer getQuestionsBasedOnId)
    {
        QuestionEntity basedOnId = questionService.getQuestionsById(getQuestionsBasedOnId);
        return new ResponseEntity<>(basedOnId,HttpStatus.OK);
    }
    // FETCH A LIST OF QUESTION REST API
    // http://localhost:8080/api/fetchAllQuestions
    @GetMapping("fetchAllQuestions")
    public ResponseEntity<List<QuestionEntity>> getListOfQuestions()
    {
        return questionService.getListOfQuestions();
    }

    // FETCH LIST OF QUESTIONS BASEDD ON CATEGORY REST API
    // http://localhost:8080/api/fetchListOfQuestions/category/Java or Python or C
    @GetMapping("fetchListOfQuestions/category/{category}")
    public ResponseEntity<List<QuestionEntity>> fetchQuestionsByCategory(@PathVariable("category") String categoryQuestions)
    {
        List<QuestionEntity> fetchCategoryOfQuestions = questionService.fetchQuestionsByCategory(categoryQuestions);
        return new ResponseEntity<>(fetchCategoryOfQuestions,HttpStatus.OK);
    }
}
