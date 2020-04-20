package com.xxx.foundation.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created on 2020/4/15 17:13
 * author:crs
 * Description:获取当前激活的配置环境
 */

@Component
public class SpringContextActive implements ApplicationContextAware {

    private static ApplicationContext context;

    //获取当前环境变量
    public static String getActiveProfile() {
        return context.getEnvironment().getActiveProfiles()[0];
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;

    }
}
