// package com.example.workflow.controller;

// import java.util.Arrays;
// import java.util.List;
// import java.util.UUID;

// import org.camunda.bpm.engine.RuntimeService;
// import org.camunda.bpm.engine.variable.Variables;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.workflow.service.KafkaProducerService;

// @RestController
// public class KafkaController {

// 	@Autowired
//     private RuntimeService runtimeService;
	

//     @GetMapping("/send")
//     public String sendMessage(@RequestParam("message") String message) {
        
//         runtimeService.startProcessInstanceByKey("Process_1cdkvje");
        
//         return "Message sent to Kafka topic!";
//     }
// }
