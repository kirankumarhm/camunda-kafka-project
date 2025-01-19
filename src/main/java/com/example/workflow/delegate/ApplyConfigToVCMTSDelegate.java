package com.example.workflow.delegate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workflow.model.Message;
import com.example.workflow.service.KafkaProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;



@Service("applyConfigToVCMTSDelegate")
public class ApplyConfigToVCMTSDelegate implements JavaDelegate {
	private final Logger LOGGER = Logger.getLogger(ApplyConfigToVCMTSDelegate.class.getName());
	
    @Autowired
    private KafkaProducerService kafkaProducerService;

    @SuppressWarnings("unchecked")
	@Override
    public void execute(DelegateExecution execution) throws JsonProcessingException {
        String workflowInstanceId = execution.getProcessInstanceId();
        
        Map<String, String> rpdMap =  (Map<String, String>) execution.getVariable("rpdMap");
        String compositeID = workflowInstanceId + "_" + rpdMap.get("id");

        System.out.println("compositeID: " + compositeID);

        // Generate a random message payload
        String messagePayload = UUID.randomUUID().toString();

        // Set the composite ID as a process variable
        execution.setVariable("compositeID", compositeID);

       

        String correlatedPayload = (String) execution.getVariable("correlatedPayload");
//        if (correlatedPayload != null) {
//        	execution.setVariable("isMessageRecived", true);
//        }else {
//        	execution.setVariable("isMessageRecived", false);
//        }
        LOGGER.info("Received correlated payload: " + correlatedPayload);

		if (correlatedPayload == null) {
			 // Log the composite ID and message payload
	        LOGGER.info("Publishing message with compositeID: " + compositeID + " and payload: " + messagePayload);
			// Publish the random message to Kafka
			LOGGER.warning("No correlated payload found");
			Message message = new Message(compositeID, messagePayload);
			try {
				kafkaProducerService.sendMessage(message);
			} catch (JsonProcessingException e) {
				System.out.println("Error: " + e.getMessage());
				e.printStackTrace();
			}
//			return;
			
		}else {
			// Process the correlated payload as needed
	        // For example, you can log it, update other process variables, or perform business logic
	        // Example: Update a process variable with the correlated payload
			LOGGER.info("Processing correlated payload: " + correlatedPayload);	
	        execution.setVariable("processedPayload", correlatedPayload);
	        
		}
        
        
        
    }
}
