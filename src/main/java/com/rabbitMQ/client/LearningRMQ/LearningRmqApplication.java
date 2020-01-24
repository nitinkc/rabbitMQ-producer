package com.rabbitMQ.client.LearningRMQ;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

		rabbitTemplate.convertAndSend("MyProgrammaticTopicExchange",
				"topic",
				"**************** Hello from program ****************");

		Student student = new Student(1001L, "XZY");
		rabbitTemplate.convertAndSend("MyProgrammaticTopicExchange","topic",student.toString());

		//Sending Parallel Stream to the Messaging Queue
		IntStream range2 = IntStream.rangeClosed(1, 10);
		int[] intList = range2.parallel().toArray();

		for (int x : intList) {
			Thread.sleep(1000);
			rabbitTemplate.convertAndSend("MyProgrammaticTopicExchange","topic",Integer.toString(x));
		}

	}
}
