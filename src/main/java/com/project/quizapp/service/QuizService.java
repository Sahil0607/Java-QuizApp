package com.project.quizapp.service;

import com.project.quizapp.dao.Questiondao;
import com.project.quizapp.dao.Quizdao;
import com.project.quizapp.model.Question;
import com.project.quizapp.model.Quiz;
import com.project.quizapp.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    Quizdao quizDao;

    @Autowired
    Questiondao questionDao;


//    public String createQuiz(String category, Integer noOfQuestions, String title) {
//        List<Question> questions = questionDao.findRandomQuestionByCategory(category, noOfQuestions);
//
//        Quiz quiz = new Quiz();
//        quiz.setTitle(category);
//        quiz.setQuestions(questions);
//        if (quiz.getQuestions() == null || quiz.getQuestions().isEmpty()) {
//            return "No questions found for the specified category.";
//        }
//
//        quizDao.save(quiz);
//
//        return "Quiz created successfully with title: " + title + " and category: " + category;
//    }

    public String createQuiz(String category, Integer noOfQuestions, String title) {
        List<Question> questions = questionDao.findRandomQuestionByCategory(category, noOfQuestions);
        if (questions == null || questions.isEmpty()) {
            throw new RuntimeException("No questions found for the specified category: " + category);
        }

        Quiz quiz = new Quiz();
        quiz.setTitle(title); // not category — fixed this bug
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return "Quiz created successfully with title: " + title + " and category: " + category;
    }
}
