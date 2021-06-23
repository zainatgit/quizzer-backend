package com.myapplications.springboot.quizzer.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="question")
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="question_title")
	private String questionTitle;
	
	@Column(name="correct_option_sequence")
	private char correctOptionSequence;
	
	@ManyToOne
	@JoinColumn(name="topic_id")
	private Topic topic;
	
	@OneToMany(mappedBy="question")
	private List<Options> options;
	
	
	public int getId() {
		return id;
	}


	@JsonManagedReference
	public List<Options> getOptions() {
		return options;
	}

	public void setOptions(List<Options> options) {
		this.options = options;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public char getCorrectOptionSequence() {
		return correctOptionSequence;
	}

	public void setCorrectOptionSequence(char correctOptionSequence) {
		this.correctOptionSequence = correctOptionSequence;
	}

	@JsonBackReference
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}


	@Override
	public String toString() {
		return "Question [id=" + id + ", questionTitle=" + questionTitle + ", correctOptionSequence="
				+ correctOptionSequence + ", topic=" + topic + ", options=" + options + "]";
	}

	
}
