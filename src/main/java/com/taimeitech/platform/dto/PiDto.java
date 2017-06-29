package com.taimeitech.platform.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.Map;

public class PiDto {

    @ApiModelProperty(value = "userId")
    private String userId ;

    @ApiModelProperty(value = "pdid")
    private String pdid;

    @ApiModelProperty(value = "pdkey")
    private String pdkey;

    @ApiModelProperty(value = "bizid")
    private String bizid;

    @ApiModelProperty(value = "category")
    private String category;

    @ApiModelProperty(value = "tenantid")
    private String tenantid;

    @ApiModelProperty(value = "tenantid")
    private Map<String, Object> vars;

    public Map<String, Object> getVars() {
        return vars;
    }

    public void setVars(Map<String, Object> vars) {
        this.vars = vars;
    }

    public String getPdid() {
        return pdid;
    }

    public void setPdid(String pdid) {
        this.pdid = pdid;
    }

    public String getPdkey() {
        return pdkey;
    }

    public void setPdkey(String pdkey) {
        this.pdkey = pdkey;
    }

    public String getBizid() {
        return bizid;
    }

    public void setBizid(String bizid) {
        this.bizid = bizid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTenantid() {
        return tenantid;
    }

    public void setTenantid(String tenantid) {
        this.tenantid = tenantid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
