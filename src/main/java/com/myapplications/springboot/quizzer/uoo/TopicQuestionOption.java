package com.myapplications.springboot.quizzer.uoo;

import java.util.List;

public class TopicQuestionOption {

	private String topicTitle;
	
	private String description;
	
	private int noOfQuestions;
	
	private String createdBy;
	
	private List<QuestionUIO> question;

	public String getTopicTitle() {
		return topicTitle;
	}

	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNoOfQuestions() {
		return noOfQuestions;
	}

	public void setNoOfQuestions(int noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}

	public List<QuestionUIO> getQuestion() {
		return question;
	}

	public void setQuestion(List<QuestionUIO> question) {
		this.question = question;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
}
