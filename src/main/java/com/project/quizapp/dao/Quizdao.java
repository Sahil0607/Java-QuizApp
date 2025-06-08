package com.project.quizapp.dao;

import com.project.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Quizdao extends JpaRepository<Quiz, Integer> {
    // Additional query methods can be defined here if needed
}
