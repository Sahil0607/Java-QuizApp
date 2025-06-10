package com.project.quizapp.service;

import com.project.quizapp.dao.Questiondao;
import com.project.quizapp.dao.Quizdao;
import com.project.quizapp.model.Question;
import com.project.quizapp.model.QuestionWrapper;
import com.project.quizapp.model.Quiz;
import com.project.quizapp.model.SubmitResponse;
import com.project.quizapp.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {
    @Autowired
    Quizdao quizDao;

    @Autowired
    Questiondao questionDao;

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

    public List<QuestionWrapper> getQuizQuestions(Integer id) {
        ValidationUtils.requirePositive(id, "Quiz ID must be positive");

        Quiz quiz = quizDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found for ID: " + id));

        List<Question> questionsFromDB = quiz.getQuestions();
        if (questionsFromDB == null || questionsFromDB.isEmpty()) {
            throw new RuntimeException("No questions found for quiz ID: " + id);
        }

        List<QuestionWrapper> questionsForUsers = questionsFromDB.stream()
                .map(q -> new QuestionWrapper(
                        q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4()))
                .toList();

        return questionsForUsers;
    }

    public Integer submitQuiz(Integer id, List<SubmitResponse> answers) {
        Quiz quiz = quizDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found for ID: " + id));

        List<Question> questions = quiz.getQuestions();
        if (questions == null || questions.isEmpty()) {
            throw new RuntimeException("No questions found for quiz ID: " + id);
        }

        // Map question IDs to their corresponding Question for fast lookup
        Map<Integer, Question> questionMap = questions.stream()
                .collect(Collectors.toMap(Question::getId, q -> q));

        int score = 0;
        for (SubmitResponse answer : answers) {
            Question question = questionMap.get(answer.getId());
            if (question == null) {
                throw new RuntimeException("Question not found for ID: " + answer.getId());
            }
            if (question.getRightAnswer().equals(answer.getResponse())) {
                score++;
            }
        }

        return score;
    }
}
