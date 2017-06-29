package com.taimeitech.platform.service.appoint;


import com.taimeitech.framework.common.dto.ActionResult;
import com.taimeitech.platform.dto.AppointExecution;

/**
 * Created by devin on 2017/4/7.
 */
public interface AppointService {
    //预约图书
    AppointExecution insertAppoint(long bookId, long studentId);

    ActionResult getAppoint(long bookId, long studentId);

}
