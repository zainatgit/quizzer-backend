package com.myapplications.springboot.quizzer.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapplications.springboot.quizzer.dao.OptionDao;
import com.myapplications.springboot.quizzer.dao.QuestionDao;
import com.myapplications.springboot.quizzer.dao.TopicDao;
import com.myapplications.springboot.quizzer.model.Options;
import com.myapplications.springboot.quizzer.model.Question;
import com.myapplications.springboot.quizzer.model.Topic;
import com.myapplications.springboot.quizzer.uoo.OptionsUIO;
import com.myapplications.springboot.quizzer.uoo.QuestionUIO;
import com.myapplications.springboot.quizzer.uoo.TopicQuestionOption;

@Service
public class TopicServiceImpl implements TopicService {

	private static final Logger logger = LoggerFactory.getLogger(TopicServiceImpl.class);
	
	@Autowired
	private TopicDao topicDao;
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private OptionDao optionDao;
	
	
	@Transactional
	@Override
	public List<Topic> get() {
		return topicDao.findAll();
	}

	@Transactional
	@Override
	public List<Topic> get(int topicId) {
		// TODO Auto-generated method stub
		return null;
		//return topicDao.get(topicId);
	}

	@Transactional
	@Override
	public boolean saveTopicQuestionOption(TopicQuestionOption topicQuestionOption) {
		
		
		
		try {
			//Setting topic
			Topic topic = new Topic();
			topic.setTopicTitle(topicQuestionOption.getTopicTitle());
			topic.setDescription(topicQuestionOption.getDescription());
			topic.setNoOfQuestion(topicQuestionOption.getNoOfQuestions());
			topic.setCreatedBy(topicQuestionOption.getCreatedBy());
			Topic savedTopic = topicDao.save(topic);
			logger.error("Topic Saved"+savedTopic.toString());
			//Setting Question
			for(QuestionUIO eachQuestion: topicQuestionOption.getQuestion()) {
				Question questionToSave = new Question();
				logger.error("Saving each Question	");
				logger.error("Title : " + eachQuestion.getQuestionTitle());
				logger.error("Correct Option : " + eachQuestion.getCorrectOption());
				logger.error("Topic in Question	" + savedTopic.getId());
				questionToSave.setQuestionTitle(eachQuestion.getQuestionTitle());
				questionToSave.setCorrectOptionSequence(eachQuestion.getCorrectOption());
				questionToSave.setTopic(savedTopic);
				Question savedQuestion = questionDao.save(questionToSave);
				logger.error("Question Saved"+savedQuestion.toString());
				//Setting Options
				for(OptionsUIO eachOption: eachQuestion.getOptions()) {
					Options optionToSave = new Options();
					logger.error("Saving each Option");
					optionToSave.setOptionTitle(eachOption.getOptionTitle());
					optionToSave.setOptionSequence(eachOption.getOptionSequence());
					optionToSave.setQuestion(savedQuestion);
					optionDao.save(optionToSave);
					logger.error("Option Saved"+optionToSave.toString());
				}
			}
			return true;
		}
		
		catch (Exception e) {
			logger.error("Exception occured "+e.getMessage(),e);
		}
		
		return false;
	}

	@Transactional
	@Override
	public void delete(Topic topic) {
		// TODO Auto-generated method stub
		
	}

}
