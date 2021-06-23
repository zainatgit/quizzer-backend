package com.myapplications.springboot.quizzer.service;

import java.util.List;

import com.myapplications.springboot.quizzer.model.Options;
import com.myapplications.springboot.quizzer.model.Question;
import com.myapplications.springboot.quizzer.uoo.SubmittedAnswers;

public interface QuestionService {

	List<Question> get();
	
	List<Question> get(int topicId);
	
	List<Question> getQuestionWithOptions(int topicId);
	
	boolean save(Question question);
	
	void delete(Question question);
	
	int submission(SubmittedAnswers submittedAnswers);
}
