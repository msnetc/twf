package com.taimeitech.platform.api.appoint;

import com.taimeitech.platform.service.activiti.ProcessInstanceParam;
import com.taimeitech.platform.service.activiti.TwfService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@RestController
public class ActvitiController {
    @Autowired
    TwfService twfService;

    @ApiOperation(value = "启动流程")
    @RequestMapping(value="/api/Actviti/startPi", method= RequestMethod.POST )
    public  String startProcessInstance(@ApiParam("param") ProcessInstanceParam param) throws Exception{
        ProcessInstance pi = twfService.startProcessInstance(param);
        return pi.getId();
    }
}
