package com.project.quizapp.controller;
import com.project.quizapp.model.QuestionWrapper;
import com.project.quizapp.model.SubmitResponse;
import com.project.quizapp.service.QuizService;
import com.project.quizapp.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,
                                     @RequestParam Integer noOfQuestions,
                                     @RequestParam String title) {
        ValidationUtils.requireNonEmpty(category, "Category must not be empty");
        ValidationUtils.requireNonEmpty(title, "Title must not be empty");
        ValidationUtils.requirePositive(noOfQuestions, "Number of questions must be positive");

        String result = quizService.createQuiz(category, noOfQuestions, title);
        return ResponseEntity.ok(result); // Returns 200 OK if successful
    }

    @GetMapping("getQuizQuestions/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
        ValidationUtils.requirePositive(id, "Quiz ID must be positive");
        List<QuestionWrapper> result = quizService.getQuizQuestions(id);
        return ResponseEntity.ok(result); // Returns 200 OK with quiz data
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<SubmitResponse> answers) {
        ValidationUtils.requirePositive(id, "Quiz ID must be positive");
        ValidationUtils.requireNonEmptyList(answers, "Answers must not be empty");

        Integer result = quizService.submitQuiz(id, answers);
        return ResponseEntity.ok(result);
    }
}
