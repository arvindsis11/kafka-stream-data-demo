package com.kafka.consumer.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.consumer.model.Response;
import com.kafka.consumer.repo.KafkaRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {

	@Autowired
	private KafkaRepo kafkaRepo;

	@KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(String message) {
		log.error(String.format("Message received in Kafka consumer: %s", message));
		System.out.println(String.format("Message received from Kafka: %s", message));

		Response newMessage = new Response();
		newMessage.setContent(message);
		newMessage.setTimestamp(new Date());
		kafkaRepo.save(newMessage);
	}
}
