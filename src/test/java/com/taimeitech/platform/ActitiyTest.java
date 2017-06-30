package com.taimeitech.platform;
import com.taimeitech.platform.service.activiti.DpService;
import com.taimeitech.platform.service.activiti.ProcessInstanceParam;
import com.taimeitech.platform.service.activiti.TwfService;
import org.activiti.engine.*;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActitiyTest {
    @Autowired
    TwfService twfService;

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
    @Autowired
    DpService dpService;

    @Test
    public void can_auto_deployee(){
        List<ProcessDefinition> definitions = repositoryService.createProcessDefinitionQuery().list();
        long cnt = repositoryService.createProcessDefinitionQuery().count();
        Assert.assertTrue(cnt > 1);
    }

    @Test
    public void can_start_processInstance(){
        ProcessInstanceParam param = new ProcessInstanceParam();
        param.setUserId("henry");
        param.setBusinessKey("form1");
        param.setProcessDefinitionKey("leave");
        try{
          ProcessInstance pi = twfService.startProcessInstance(param);
        }
        catch (Exception ex){
          String msg = ex.getMessage();
        }
    }
}
