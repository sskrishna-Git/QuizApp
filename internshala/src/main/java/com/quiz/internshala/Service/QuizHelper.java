package com.quiz.internshala.Service;

import org.springframework.stereotype.Component;

import com.quiz.internshala.Repository.QuizeRepository;
import com.quiz.internshala.entitys.Quiz;

@Component
public class QuizHelper {

	private final QuizeRepository quizRepository;

    public QuizHelper(QuizeRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz findQuizById(Long quizId) {
        return quizRepository.findById(quizId).orElse(null);
    }
	
}
