package com.example.workflow.controller;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.workflow.model.Message;

@RestController
public class MessageCorrelationController {

    @Autowired
    private RuntimeService runtimeService;

    @PostMapping("/correlate")
    public void correlateMessage(@RequestBody Message payload) {
        runtimeService.createMessageCorrelation(payload.getCompositeID())
                      .processInstanceVariableEquals("compositeID", payload.getCompositeID())
                      .setVariable("correlatedPayload", payload.getPayload())
                      .correlate();
    }
}


