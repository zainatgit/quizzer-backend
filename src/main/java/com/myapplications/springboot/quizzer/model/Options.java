package com.myapplications.springboot.quizzer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="options")
public class Options {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="option_title")
	private String optionTitle;
	
	@ManyToOne
	@JoinColumn(name="question_id")
	private Question question;
	
	@Column(name="option_sequence")
	private char optionSequence;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOptionTitle() {
		return optionTitle;
	}

	public void setOptionTitle(String optionTitle) {
		this.optionTitle = optionTitle;
	}

	@JsonBackReference
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public char getOptionSequence() {
		return optionSequence;
	}

	public void setOptionSequence(char optionSequence) {
		this.optionSequence = optionSequence;
	}

	@Override
	public String toString() {
		return "Options [id=" + id + ", optionTitle=" + optionTitle + ", question=" + question + ", optionSequence="
				+ optionSequence + "]";
	}

	
	
	
}
