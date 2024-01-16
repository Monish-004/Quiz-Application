package com.SpringBootProject.repository;

import com.SpringBootProject.entity.QuizzEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizzRepository extends JpaRepository<QuizzEntity,Integer> {
}
