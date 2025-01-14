package com.example.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class RpdInitializeDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        List<Map<String, String>> subjectList = new ArrayList<Map<String, String>>();

        for (int i = 1; i <= 5; i++) {
            Map<String, String> subject = new HashMap<>();
            subject.put("id", "RPD - " + i);
//            subject.put("name", "Subject " + i);
            subjectList.add(subject);
        }
        execution.setVariable("rpdList", subjectList);

    }
}
