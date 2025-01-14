package com.example.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;


@Service("updateJobWithSucess")
public class UpdateJobWithSucess implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Object variable = execution.getVariable("correlatedPayload");
        System.out.println("UpdateJobWithSucess: " + variable);
	}

}
