package com.taimeitech.platform.service.activiti;

import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.Map;

public interface TwfService {

    ProcessInstance startProcessInstance(ProcessInstanceParam param) throws Exception;
}
