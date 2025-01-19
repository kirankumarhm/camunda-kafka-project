//package com.example.workflow.service;
//import java.util.logging.Logger;
//
//import org.camunda.bpm.engine.RuntimeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//import com.example.workflow.model.Message;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@Service
//public class KafkaConsumerService {
//	private final Logger LOGGER = Logger.getLogger(KafkaConsumerService.class.getName());
//
//    @Autowired
//    private RuntimeService runtimeService;
//
//    private final ObjectMapper objectMapper = new ObjectMapper();
//    
//    @KafkaListener(topics = "myReciveTopic", groupId = "myGroup")
//    public void listen(String jsonString) throws JsonMappingException, JsonProcessingException {
//    	// Parse the JSON message
//    	// Convert the JSON string to a Message object
//        Message msg = objectMapper.readValue(jsonString, Message.class);
//        
//        // Extract the composite ID
//        String compositeID = msg.getCompositeID();
//        
//        // Log the composite ID
//        LOGGER.info("Received message with compositeID: " + compositeID);
//        
//        // Correlate the message in Camunda
//        runtimeService.createMessageCorrelation(compositeID)
//                      .processInstanceVariableEquals("compositeID", compositeID)
//                      .setVariable("correlatedPayload", msg.getPayload()	)
////                      .setVariable("processedPayload", correlatedPayload)
//                      .correlate();
//    }
//
//
//}
