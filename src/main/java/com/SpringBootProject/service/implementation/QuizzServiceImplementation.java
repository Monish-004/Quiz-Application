package com.SpringBootProject.service.implementation;

import com.SpringBootProject.POJO.DTO.Question;
import com.SpringBootProject.entity.QuestionEntity;
import com.SpringBootProject.entity.QuizzEntity;
import com.SpringBootProject.repository.QuestionRepository;
import com.SpringBootProject.repository.QuizzRepository;
import com.SpringBootProject.service.QuizzService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuizzServiceImplementation implements QuizzService
{
    private QuizzRepository quizzDao;
    private QuestionRepository questionRepository;

    @Override
    public ResponseEntity<String> createQuizz(String Category, int numOfQns, String title)
    {
        List<QuestionEntity> qEntity = questionRepository.findQuestionsByCategory (
                Category,numOfQns );

        QuizzEntity quizz = new QuizzEntity();
        quizz.setTitle(title);
        quizz.setQuestions(qEntity);
        quizzDao.save(quizz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Question>> fetchQuizQuestions(Integer id) {
        Optional<QuizzEntity> quiz = quizzDao.findById(id);
        List<QuestionEntity> qnFromDB = quiz.get().getQuestions();
        List<Question> questionForUsers = new ArrayList<>();
        for(QuestionEntity q : qnFromDB)
        {
            Question qn = new Question(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionForUsers.add(qn);
        }
        return new ResponseEntity<>(questionForUsers,HttpStatus.OK);
    }

    @Override
    public void deleteQuestions(Integer id) {
        quizzDao.deleteById(id);
    }
}
