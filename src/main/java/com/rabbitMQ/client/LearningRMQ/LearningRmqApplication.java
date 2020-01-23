package com.rabbitMQ.client.LearningRMQ;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningRmqApplication implements CommandLineRunner {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(LearningRmqApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//rabbitTemplate.convertAndSend("Hello World from my Program");
		//rabbitTemplate.convertAndSend("TestExchange","testRouting","Hello from program");

		Student student = new Student(1001L, "XZY");

		rabbitTemplate.convertAndSend("TestExchange","testRouting",student);

	}
}
