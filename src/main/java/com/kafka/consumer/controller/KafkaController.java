package com.kafka.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.consumer.model.Response;
import com.kafka.consumer.repo.KafkaRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/kafka")
public class KafkaController {
//experimental feature
	@Autowired
	private KafkaRepo kafkaRepo;

	@GetMapping("/messages")
	public List<Response> getAllMessages() {
		return kafkaRepo.findAll();
	}
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<?> deleteAll(){
		kafkaRepo.deleteAll();
		return ResponseEntity.status(HttpStatus.OK).body("deleted all events");
	}

}
