package com.kafka.consumer.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kafka.consumer.model.Response;

public interface KafkaRepo extends MongoRepository<Response, String> {
}
