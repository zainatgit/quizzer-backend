package com.myapplications.springboot.quizzer.service;

import java.util.List;

import com.myapplications.springboot.quizzer.model.Topic;
import com.myapplications.springboot.quizzer.uoo.TopicQuestionOption;

public interface TopicService {

	List<Topic> get();
	
	List<Topic> get(int topicId);
	
	boolean saveTopicQuestionOption(TopicQuestionOption topicQuestionOption);
	
	void delete(Topic topic);
}
