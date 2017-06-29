package com.taimeitech.platform;
import com.taimeitech.platform.service.activiti.ProcessInstanceParam;
import com.taimeitech.platform.service.activiti.TwfService;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActitiyTest {
    @Autowired
    TwfService twfService;

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
