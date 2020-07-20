package com.rabbitMQ.controller;

import java.util.Optional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitMQ.entity.Student;
import com.rabbitMQ.services.StudentBO;

@RestController
public class ProducerController {
	
	@Autowired
	StudentBO studentBo;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@GetMapping("/")
	public String HealthCheck() {
		return "Rabbit Producer is Up & Running";
	}
	
	@GetMapping(value = {"/student/id/{stud_id}"},
			produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Student> getStudentId(@PathVariable Long stud_id){
		System.out.println("Student Id searched is : " + stud_id);
		Optional<Student> result = studentBo.findStudentById(stud_id);
		
		Student returnStud = result.empty() != null?result.get():null; 
		
		rabbitTemplate.convertAndSend("MyProgrammaticTopicExchange","topic",returnStud);

		return ResponseEntity.status(HttpStatus.OK).body(returnStud);
	}
	
	

}
