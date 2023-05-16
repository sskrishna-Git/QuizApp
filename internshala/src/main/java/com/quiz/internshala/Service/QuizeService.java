package com.quiz.internshala.Service;

import java.util.List;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import com.quiz.internshala.Repository.QuizeRepository;
import com.quiz.internshala.entitys.Quiz;

@Service
public class QuizeService {

	private QuizeRepository quizeRepository;
	
	private TaskScheduler taskScheduler;
	
	
	public QuizeService(QuizeRepository quizeRepository) {
		this.quizeRepository = quizeRepository;
	}
	
	

    public Quiz createQuiz(Quiz quiz) {
        // Implement any additional business logic if needed
        return quizeRepository.save(quiz);
    }

    public Quiz getQuizById(Long quizId) {
        return quizeRepository.findById(quizId).orElse(null);
    }

    public List<Quiz> getAllQuizzes() {
        return quizeRepository.findAll();
    }
    public void startQuiz(Long quizId) {
        Quiz quiz = quizeRepository.findById(quizId).orElse(null);
        if (quiz != null) {
            // Schedule the quiz end task
            taskScheduler.schedule(() -> endQuiz(quizId), quiz.getEndTime());
        }
    }



	private Object endQuiz(Long quizId) {
		// TODO Auto-generated method stub
		return null;
	}
}
