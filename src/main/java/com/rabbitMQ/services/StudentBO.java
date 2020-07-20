package com.rabbitMQ.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbitMQ.entity.Student;
import com.rabbitMQ.repository.StudentRepository;

@Service
public class StudentBO {
	
	@Autowired
	StudentRepository studentRepository;
	
	public Optional<Student> findStudentById(Long id) {
		return studentRepository.findById(id);
	}
	
	public List<Student> findStudentListByName(String name){
		return studentRepository.findByName(name);
	}

}
