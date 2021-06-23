package com.myapplications.springboot.quizzer.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapplications.springboot.quizzer.controller.QuestionController;
import com.myapplications.springboot.quizzer.dao.QuestionDao;

import com.myapplications.springboot.quizzer.model.Question;
import com.myapplications.springboot.quizzer.uoo.SubmittedAnswers;


@Service
public class QuestionServiceImpl implements QuestionService {

	private static final Logger logger = LoggerFactory.getLogger(QuestionService.class);
	
	@Autowired
	private QuestionDao questionDao;
	
	@Override
	public List<Question> get() {
		return questionDao.findAll();
	}

	@Override
	public List<Question> get(int topicId) {
		List<Question> questionList = questionDao.questionByTopicId(topicId);
		return questionList;
		//return question.get();
	}

	@Override
	public boolean save(Question question) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(Question question) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Question> getQuestionWithOptions(int topicId) {
		// TODO Auto-generated method stub
		return null;
		//return questionDao.getQuestionWithOptions(topicId);
	}

	@Override
	public int submission(SubmittedAnswers submittedAnswers) {
		// TODO Auto-generated method stub
		logger.info("Entered in submission() in QuestionService");
		List<Question> questionList = questionDao.questionByTopicId(Integer.parseInt(submittedAnswers.getTopicId()));
		int points = 0;
		for(Question eachQuestion : questionList) {
			String id = Integer.toString(eachQuestion.getId());
			String correctSequence = Character.toString(eachQuestion.getCorrectOptionSequence());
			for(HashMap<String, String> eachAnswer : submittedAnswers.getSubmission()) {
				if(eachAnswer.containsKey(String.valueOf(eachQuestion.getId()))) {
					logger.info("Key matched "+eachQuestion.getId());
					if(eachAnswer.get(String.valueOf(eachQuestion.getId())).equals(String.valueOf(eachQuestion.getCorrectOptionSequence()))) {
						points++;
					}
				}
			}
		}
		return points;
	}


	
	
	
}
