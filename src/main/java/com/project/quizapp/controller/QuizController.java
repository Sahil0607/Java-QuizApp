package com.project.quizapp.controller;
import com.project.quizapp.service.QuizService;
import com.project.quizapp.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
