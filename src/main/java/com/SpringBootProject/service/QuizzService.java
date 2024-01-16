package com.SpringBootProject.service;

import com.SpringBootProject.POJO.DTO.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizzService
{
    ResponseEntity<String> createQuizz(String Category,int numOfQns,String title);

    ResponseEntity<List<Question>> fetchQuizQuestions(Integer id);

    void deleteQuestions(Integer id);
}
