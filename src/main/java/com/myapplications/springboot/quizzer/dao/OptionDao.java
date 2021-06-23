package com.myapplications.springboot.quizzer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapplications.springboot.quizzer.model.Options;


public interface OptionDao extends JpaRepository<Options, Integer>{

}
