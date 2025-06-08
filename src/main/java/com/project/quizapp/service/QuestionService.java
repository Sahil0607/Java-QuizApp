package com.project.quizapp.service;

import com.project.quizapp.dao.Questiondao;
import com.project.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    Questiondao questionDao;


    public String loadAllQuestions(List<Question> questionList) {
        if (questionList == null || questionList.isEmpty()) {
            throw new IllegalArgumentException("Question list cannot be null or empty.");
        }

        List<Question> saved = questionDao.saveAll(questionList);
        if (saved == null || saved.isEmpty()) {
            throw new RuntimeException("Failed to save questions.");
        }

        return "All questions loaded successfully";
    }

//     public List<Question> getAllQuestions() {
//         return questionDao.findAll();
//     }

    public List<Question> getAllQuestions() {
        List<Question> questions = questionDao.findAll();
        if (questions == null || questions.isEmpty()) {
            throw new RuntimeException("No questions found.");
        }
        return questions;
    }

    public List<Question> getQuestionsByCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category must not be empty");
        }

        List<Question> questions = questionDao.findByCategory(category);
        if (questions == null || questions.isEmpty()) {
            throw new RuntimeException("No questions found for category: " + category);
        }

        return questions;
    }

    public String addQuestion(Question question) {
        if (question == null) {
            throw new IllegalArgumentException("Question cannot be null");
        }

        Question saved = questionDao.save(question);
        if (saved == null) {
            throw new RuntimeException("Failed to add question");
        }
        return "Question added successfully";
    }

    public String deleteQuestion(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        if (!questionDao.existsById(id)) {
            throw new RuntimeException("Question not found with ID: " + id);
        }

        questionDao.deleteById(id);
        return "Question deleted successfully";
    }

    public String deleteAllQuestions() {
        questionDao.deleteAll();
        return "All questions deleted successfully";
    }

    public String updateQuestion(Integer id, Question question) {
        if (id == null || question == null) {
            throw new IllegalArgumentException("ID and Question must not be null");
        }

        Optional<Question> existing = questionDao.findById(id);
        if (existing.isEmpty()) {
            throw new RuntimeException("Question not found with ID: " + id);
        }

        Question existingQuestion = existing.get();
        existingQuestion.setQuestionTitle(question.getQuestionTitle());
        existingQuestion.setOption1(question.getOption1());
        existingQuestion.setOption2(question.getOption2());
        existingQuestion.setOption3(question.getOption3());
        existingQuestion.setOption4(question.getOption4());
        existingQuestion.setRightAnswer(question.getRightAnswer());
        existingQuestion.setDifficultyLevel(question.getDifficultyLevel());
        existingQuestion.setCategory(question.getCategory());

        questionDao.save(existingQuestion);
        return "Question updated successfully";
    }

}
