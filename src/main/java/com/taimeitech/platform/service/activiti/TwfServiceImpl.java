package com.taimeitech.platform.service.activiti;

import com.netflix.discovery.converters.Auto;
import com.taimeitech.platform.dto.PiDto;
import freemarker.template.utility.DateUtil;
import javassist.bytecode.stackmap.BasicBlock;
import org.activiti.engine.*;
import org.activiti.engine.impl.persistence.entity.SuspensionState;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.lang.StringUtils;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Component
public class TwfServiceImpl implements  TwfService {

    @Autowired  ProcessEngine processEngine;
    @Autowired  RepositoryService repositoryService;
    @Autowired  RuntimeService runtimeService;
    @Autowired  TaskService taskService;
    @Autowired  HistoryService historyService;
    @Autowired  IdentityService identityService;
    @Autowired  ManagementService managementService;
    @Autowired  FormService formService;
    @Autowired DpService dpService;

    @Override
    public ProcessInstance startProcessInstance(ProcessInstanceParam param) throws Exception {
        ProcessDefinition  processDefinition= pd(null, param.getBusinessKey(), null, null, param.getTenantid());
        ProcessInstance processInstance;
        if (processDefinition == null ) {
            String bpmnClasspath = "processes/leave/leave.bpmn";
            repositoryService.createDeployment().addClasspathResource(bpmnClasspath).deploy();
        }
        try{
            // 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
            identityService.setAuthenticatedUserId(param.getUserId());
            processInstance =  runtimeService.startProcessInstanceByKeyAndTenantId(param.getProcessDefinitionKey(), param.getBusinessKey(), param.getVaribales(), param.getTenantid());
        }
        finally {
            identityService.setAuthenticatedUserId(null);
        }
        return processInstance;
    }

    /**
     * 已部署流程列表
     */
    public ProcessDefinition pd(String pdid, String pdkey, SuspensionState suspensionstate, String category, String tenantid) {
        ProcessDefinitionQuery processDefinitionQuery = pdCond(pdid, pdkey, suspensionstate, category, tenantid, null);
        ProcessDefinition processDefinition = processDefinitionQuery.singleResult();
        return processDefinition;
    }


    /**
     * 已部署流程列表
     */
    public PageList<ProcessDefinition> pdList(String pdid, String pdkey, SuspensionState suspensionstate, String category, String tenantid, PageInfo pageinfo) {
        ProcessDefinitionQuery processDefinitionQuery = pdCond(pdid, pdkey, suspensionstate, category, tenantid, pageinfo);
        long count = processDefinitionQuery.count();
        List<ProcessDefinition> list = processDefinitionQuery.list();
        return new PageList<>(list, count);
    }

    private ProcessDefinitionQuery pdCond(String pdid, String pdkey, SuspensionState suspensionstate, String category, String tenantid, PageInfo pageinfo) {
        RepositoryService repositoryService = this.processEngine.getRepositoryService();
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        if (StringUtils.isNotEmpty(pdid)) {
            processDefinitionQuery = processDefinitionQuery.processDefinitionId(pdid);
        }
        if (StringUtils.isNotEmpty(pdkey) && StringUtils.isNotEmpty(category) && StringUtils.isNotEmpty(tenantid)) {
            processDefinitionQuery = processDefinitionQuery.processDefinitionKey(pdkey);
        }
        if (suspensionstate != null) {
            processDefinitionQuery = suspensionstate == SuspensionState.ACTIVE ? processDefinitionQuery.active() : processDefinitionQuery.suspended();
        }
        if (StringUtils.isNotEmpty(category)) {
            processDefinitionQuery = processDefinitionQuery.processDefinitionCategory(category);
        }
        if (StringUtils.isNotEmpty(tenantid)) {
            processDefinitionQuery = processDefinitionQuery.processDefinitionTenantId(tenantid);
        }

//        if (pageinfo != null && pageinfo.getSort() != null) {
//            Sort.Order order = pageinfo.getSort().iterator().next();
//            switch (StringUtils.dealEmpty(order.getProperty())) {
//                case "pdid":
//                    processDefinitionQuery = processDefinitionQuery.orderByProcessDefinitionId();
//                    break;
//                case "pdkey":
//                    processDefinitionQuery = processDefinitionQuery.orderByProcessDefinitionKey();
//                    break;
//                case "tenantid":
//                    processDefinitionQuery = processDefinitionQuery.orderByTenantId();
//                    break;
//                case "pdversion":
//                    processDefinitionQuery = processDefinitionQuery.orderByProcessDefinitionVersion();
//                    break;
//                default:
//                    // 需要手动扩展其它支持的排序数据项。
//                    break;
//            }
//            processDefinitionQuery = order.getDirection().equals(Sort.Direction.ASC) ? processDefinitionQuery.asc() : processDefinitionQuery.desc();
//        }
        return processDefinitionQuery;
    }

}
