package com.SpringBootProject.controller;

import com.SpringBootProject.POJO.DTO.Question;
import com.SpringBootProject.entity.QuestionEntity;
import com.SpringBootProject.service.QuizzService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/quizz")
public class QuizzController
{
    private QuizzService quizzService;

    // http://localhost:8080/api/quizz/create?category=Python&numOfQns=5&title=Pquizz
    @PostMapping("create")
    public ResponseEntity<String> createQuizz(@RequestParam String category, @RequestParam int numOfQns, @RequestParam String title)
    {
        return quizzService.createQuizz(category,numOfQns,title);
    }

    // http://localhost:8080/api/quizz/get/1
    @GetMapping("get/{id}")
    public ResponseEntity<List<Question>>fetchQuizQuestions(@PathVariable Integer id)
    {
        return quizzService.fetchQuizQuestions(id);
    }

    // http://localhost:8080/api/quizz/delete/2
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestions(@PathVariable Integer id)
    {
        quizzService.deleteQuestions(id);
        return new ResponseEntity<>("Question Deleted Successfully", HttpStatus.OK);
    }
}
