package com.example.workflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.workflow.model.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaProducerService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Value("${spring.kafka.topic.name}")
	private String topicName;

	private final ObjectMapper objectMapper = new ObjectMapper();

	public void sendMessage(String message) {
		kafkaTemplate.send(topicName, message);
	}

	public void sendMessage(Message message) throws JsonProcessingException {
		// Create a JSON object with the composite ID and message payload
		String jsonMessage = objectMapper.writeValueAsString(message);
		kafkaTemplate.send(topicName, message.compositeID, jsonMessage);
	}



}
