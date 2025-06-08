package com.project.quizapp.controller;

import com.project.quizapp.model.Question;
import com.project.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("/loadAllQuestions")
    public ResponseEntity<String> loadAllQuestions(@RequestBody List<Question> questionList) {
        String result = questionService.loadAllQuestions(questionList);
        return ResponseEntity.ok(result); // Returns 200 OK if successful
    }

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = questionService.getAllQuestions();
        return ResponseEntity.ok(questions); // 200 OK
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
        List<Question> questions = questionService.getQuestionsByCategory(category);
        return ResponseEntity.ok(questions); // 200 OK
    };

    @PostMapping("/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        String result = questionService.addQuestion(question);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/deleteQuestion/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer id) {
        String result = questionService.deleteQuestion(id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/deleteAllQuestions")
    public ResponseEntity<String> deleteAllQuestions() {
        String result = questionService.deleteAllQuestions();
        return ResponseEntity.ok(result);
    }

    @PutMapping("/updateQuestion/{id}")
    public ResponseEntity<String> updateQuestion(@PathVariable Integer id, @RequestBody Question question) {
        String result = questionService.updateQuestion(id, question);
        return ResponseEntity.ok(result);
    }

}
