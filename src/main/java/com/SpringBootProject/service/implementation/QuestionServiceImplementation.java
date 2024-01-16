package com.SpringBootProject.service.implementation;


import com.SpringBootProject.entity.QuestionEntity;
import com.SpringBootProject.repository.QuestionRepository;
import com.SpringBootProject.service.QuestionService;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuestionServiceImplementation implements QuestionService
{
    private QuestionRepository questionRepository;
    @Override
    // CREATE QUESTION REST API
    public String createQuestion(QuestionEntity questionEntity)
    {
        questionRepository.save(questionEntity);
        return "success";
    }
    @Override
    // CREATE ALL QUESTION REST API
    public List<QuestionEntity> createAllQuestions(List<QuestionEntity> allQuestion) {
        return questionRepository.saveAll(allQuestion);
    }
    @Override
    public QuestionEntity getQuestionsById(Integer getQuestionsBasedOnId) {
        Optional<QuestionEntity> fetchingById = questionRepository.findById(getQuestionsBasedOnId);
        return fetchingById.get();
    }
    @Override
    // FETCH ALL QUESTIONS REST API
    public ResponseEntity<List<QuestionEntity>> getListOfQuestions()
    {
        try
        {
            List<QuestionEntity> allQuestions = questionRepository.findAll();
            return new ResponseEntity<>(allQuestions, HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);


    }
    @Override
    public List<QuestionEntity> fetchQuestionsByCategory(String categoryQuestions)
    {
        try
        {
            List<QuestionEntity> questionsBasedOnCategory = questionRepository.findQuestionsByCategory(categoryQuestions);
            return questionsBasedOnCategory;
        }
        catch (Exception e)
        {
            return (new ArrayList<>());
        }

    }


}
