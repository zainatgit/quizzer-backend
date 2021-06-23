package com.myapplications.springboot.quizzer.dao;

import java.util.List;
import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.myapplications.springboot.quizzer.model.Question;



public interface QuestionDao extends JpaRepository<Question, Integer>{
	
	
	
	@Query(value = "select q from Question q where q.topic.id=:topicId")
	List<Question> questionByTopicId(@Param("topicId") int topicId);
	
	
	/*
	 * 
	 * @Query(value = "select q from Question q where q.topic.id=:topicId")
	Optional<Question> submission(SubmittedAnswers submittedAnswers);
	
	
	 * @Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
User findUserByUserStatusAndUserName(@Param("status") Integer userStatus, 
  @Param("name") String userName);
	 * 
	 */
}
