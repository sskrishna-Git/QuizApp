package com.quiz.internshala.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.internshala.Service.QuizeService;
import com.quiz.internshala.entitys.Quiz;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {
	
	private final QuizeService quizService;

    public QuizController(QuizeService quizService) {
        this.quizService = quizService;
    }
    
    @PostMapping("/create")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        Quiz createdQuiz = quizService.createQuiz(quiz);
        return ResponseEntity.ok(createdQuiz);
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long quizId) {
        Quiz quiz = quizService.getQuizById(quizId);
        if (quiz == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(quiz);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        return ResponseEntity.ok(quizzes);
    }
    
    @PostMapping("/{quizId}/start")
    public ResponseEntity<String> startQuiz(@PathVariable Long quizId) {
        quizService.startQuiz(quizId);
        return ResponseEntity.ok("Quiz started successfully.");
    }

	
}
