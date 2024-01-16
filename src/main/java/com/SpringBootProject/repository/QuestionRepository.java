package com.SpringBootProject.repository;


import com.SpringBootProject.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionEntity,Integer>
{
    List<QuestionEntity> findQuestionsByCategory(String categoryQuestions);
    @Query(value = "SELECT * FROM question q where q.category=? ORDER BY RAND() LIMIT ?",nativeQuery = true)
    List<QuestionEntity> findQuestionsByCategory(String category,int numOfQns);
}
