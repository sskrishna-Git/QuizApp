package com.quiz.internshala.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.internshala.entitys.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
