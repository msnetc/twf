package com.taimeitech.platform.service.activiti;

import java.util.Map;
import io.swagger.annotations.ApiModelProperty;
/**
 * Created by yanjie.miao on 2017/6/29.
 */
public class ProcessInstanceParam {

//    @ApiModelProperty(value = "userid")
    private String userId;
//    @ApiModelProperty(value = "组合Id")
    private String tenantid;
//    @ApiModelProperty(value = "bpmn中定义的processkey")
    private String processDefinitionKey;
//    @ApiModelProperty(value = "businesskey")
    private String businessKey;

    private Map<String, Object> varibales;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTenantid() {
        return tenantid;
    }

    public void setTenantid(String tenantid) {
        this.tenantid = tenantid;
    }

    public String getProcessDefinitionKey() {
        return processDefinitionKey;
    }

    public void setProcessDefinitionKey(String processDefinitionKey) {
        this.processDefinitionKey = processDefinitionKey;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public Map<String, Object> getVaribales() {
        return varibales;
    }

    public void setVaribales(Map<String, Object> varibales) {
        this.varibales = varibales;
    }
}
