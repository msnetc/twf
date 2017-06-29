package com.taimeitech.platform.service.activiti;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DpServiceImpl implements DpService {

    @Autowired
    ProcessEngine processEngine;

    @Autowired
    RepositoryService repositoryService;
    @Autowired
    RuntimeService runtimeService;
    @Autowired
    TaskService taskService;
    @Autowired
    HistoryService historyService;
    @Autowired  IdentityService identityService;
    @Autowired  ManagementService managementService;
    @Autowired  FormService formService;

    public Deployment dpRun(String pdkey, String category, String tenantid) {
        RepositoryService repositoryService = this.processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment().category(category).tenantId(tenantid).addClasspathResource("/processes/processReport.bpmn20.xml").deploy();
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();
        repositoryService.setProcessDefinitionCategory(processDefinition.getId(), category);
        return deployment;
    }
}
