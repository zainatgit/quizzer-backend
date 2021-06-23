package com.myapplications.springboot.quizzer.uoo;

import java.util.List;

public class QuestionUIO {

	private String questionTitle;
	
	private char correctOption;
	
	private List<OptionsUIO> options;

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public char getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(char correctOption) {
		this.correctOption = correctOption;
	}

	public List<OptionsUIO> getOptions() {
		return options;
	}

	public void setOptions(List<OptionsUIO> options) {
		this.options = options;
	}
	
	
}
