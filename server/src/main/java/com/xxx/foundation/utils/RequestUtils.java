package com.xxx.foundation.utils;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 2020/4/17 16:53
 * author:crs
 * Description:RequestUtils 请求失败
 */
public class RequestUtils {

    public RequestUtils() {
    }

    //获取当前请求Request
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return servletRequestAttributes.getRequest();
    }

    public static HttpServletResponse getResponse() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return servletRequestAttributes.getResponse();
    }

    public static ServletContext getServletContext() {
        ServletContext context = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        return context;
    }


}
