package com.rabbitMQ.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rabbitMQ.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	public Optional<Student> findById(Long id);
	public List<Student> findByName(String name);
}
