package com.myapplications.springboot.quizzer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapplications.springboot.quizzer.model.Topic;
import com.myapplications.springboot.quizzer.service.TopicService;
import com.myapplications.springboot.quizzer.uoo.TopicQuestionOption;

@RestController
@RequestMapping("/api")
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@GetMapping("/topics")
	public ResponseEntity<List<Topic>> get(){
		List<Topic> topic = topicService.get();
		return ResponseEntity.status(HttpStatus.OK)
		        .body(topic);
	}
	
	@GetMapping("/topics/{id}")
	public ResponseEntity<List<Topic>> get(@PathVariable("id") int id){
		List<Topic> topicList = topicService.get(id);
		if(topicList.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK)
			        .body(topicList);
		} else {
			return ResponseEntity.notFound().build();
		}
		
		//return topicService.get(id);
	}
	
	@PostMapping("/topicQuestionOption")
	public ResponseEntity<?> save(@RequestBody TopicQuestionOption topicQuestionOption) {
		if(topicService.saveTopicQuestionOption(topicQuestionOption)) {
			 return new ResponseEntity<String>("SUCCESS", HttpStatus.CREATED);
		}else {
			 return new ResponseEntity<String>("FAILED",HttpStatus.EXPECTATION_FAILED);
		}
	}
}
