package com.taimeitech.platform.service.activiti;

import org.activiti.engine.repository.Deployment;

/**
 * Created by yanjie.miao on 2017/6/29.
 */
public interface DpService {
    Deployment dpRun(String pdkey, String category, String tenantid);
}
