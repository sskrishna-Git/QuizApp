package com.quiz.internshala.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.internshala.entitys.Quiz;

public interface QuizeRepository extends JpaRepository<Quiz, Long> {

}
