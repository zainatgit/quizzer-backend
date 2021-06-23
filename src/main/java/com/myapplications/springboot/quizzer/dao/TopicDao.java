package com.myapplications.springboot.quizzer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapplications.springboot.quizzer.model.Topic;

public interface TopicDao extends JpaRepository<Topic, Integer>{

	
}
