package com.myapplications.springboot.quizzer.uoo;

import java.util.HashMap;
import java.util.List;

public class SubmittedAnswers {

	private String topicId;
	private List<HashMap<String,String>> submission;

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public List<HashMap<String,String>> getSubmission() {
		return submission;
	}

	public void setSubmission(List<HashMap<String,String>> submission) {
		this.submission = submission;
	}
	
}
