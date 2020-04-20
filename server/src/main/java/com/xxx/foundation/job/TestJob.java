package com.xxx.foundation.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

/**
 * Created on 2020/4/20 15:40
 * author:crs
 * Description: 1)Value的值和当前类名相同
 */
@Component
@JobHandler(value = "TestJob")
public class TestJob extends IJobHandler {

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        XxlJobLogger.log("job start----");
        //todo：处理业务逻辑

        XxlJobLogger.log("job end----");
        return SUCCESS;
    }
}
