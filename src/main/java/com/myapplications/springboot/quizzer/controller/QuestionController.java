package com.myapplications.springboot.quizzer.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapplications.springboot.quizzer.model.Options;
import com.myapplications.springboot.quizzer.model.Question;
import com.myapplications.springboot.quizzer.service.QuestionService;
import com.myapplications.springboot.quizzer.uoo.SubmittedAnswers;

@RestController
@RequestMapping("/api")
public class QuestionController {

	
	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/questions")
	public ResponseEntity<?> get(){
		List<Question> question = questionService.get();
		return ResponseEntity.status(HttpStatus.OK)
		        .body(question);
	}
	
	@GetMapping("/questions/{id}")
	public ResponseEntity<?> get(@PathVariable("id") int topicId){
		List<Question> questionList = questionService.get(topicId);
		for(Question eachquestion : questionList) {
			eachquestion.setCorrectOptionSequence('x');
		}
		if(questionList.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK)
			        .body(questionList);
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
	@GetMapping("/questionsWithOptions/{id}")
	public ResponseEntity<?> getQuestionWithOptions(@PathVariable("id") int topicId){
		logger.info("Entered in getQuestionWithOptions() ");
		List<Question> questionList = questionService.getQuestionWithOptions(topicId);
		
		for(Question eachquestion : questionList) {
			eachquestion.setCorrectOptionSequence('x');
		}
		if(questionList.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK)
			        .body(questionList);
		} else {
			return ResponseEntity.notFound().build();
		}
		
		//return questionService.get(id);
	}
	
	@PostMapping("/questions")
	public ResponseEntity<?> save(@RequestBody Question question) {
		if(questionService.save(question)) {
			 return new ResponseEntity<String>("SUCCESS", HttpStatus.CREATED);
		}else {
			 return new ResponseEntity<String>("FAILED",HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PostMapping("/submitQuiz")
	public ResponseEntity<?> submit(@RequestBody SubmittedAnswers submitAnswers) {
		logger.info("Entered in submit() ");
		logger.info("Size "+submitAnswers.getSubmission().size());
		int points = questionService.submission(submitAnswers);
		//submitAnswers.getAnswers().forEach((key,value)->{System.out.println(key+" "+value);});
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		result.put("points", points);
		return ResponseEntity.status(HttpStatus.OK)
		        .body(result);
	}
}
