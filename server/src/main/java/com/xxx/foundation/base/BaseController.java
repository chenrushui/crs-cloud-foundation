package com.xxx.foundation.base;

import com.xxx.foundation.utils.CacheClient;
import com.xxx.foundation.utils.RequestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 2020/4/17 16:49
 * author:crs
 * Description:BaseController 处理公共逻辑请求头（请求头以及用户信息）
 */
public abstract class BaseController {

    //todo:通过token从redis中获取用户信息，比如doctorId，doctorEntity之类的医生信息

    @Autowired
    private CacheClient cacheClient;

    public BaseController() {
    }

    public HttpServletRequest getRequest() {
        return RequestUtils.getRequest();
    }

    public HttpServletResponse getResponse() {
        return RequestUtils.getResponse();
    }

    //存在可能获取两个ip地址的可能，一个内网ip一个外网ip。
    protected final String getIpAddr() {
        String ip = this.getRequest().getHeader("x-forwarded-for");
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = this.getRequest().getHeader("Proxy-Client-IP");
        }

        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = this.getRequest().getHeader("WL-Proxy-Client-IP");
        }

        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = this.getRequest().getRemoteAddr();
        }
        return ip;
    }

    /**
     * 产品线类型：productType： 1.云鹊医（默认值） 2云鹊健康
     *
     * @return
     */
    public Integer getProductType() {
        HttpServletRequest request = this.getRequest();
        String str = request.getHeader("productType");
        if (StringUtils.isNotEmpty(str)) {
            return Integer.parseInt(str);
        }
        return null;
    }

    /**
     * 终端来源 sourceType:1.android  2.ios  3.web  4.wechat(例如微信小程序) 5.h5
     *
     * @return
     */
    public Integer getSourceType() {
        HttpServletRequest request = this.getRequest();
        String str = request.getHeader("sourceType");
        if (StringUtils.isNotEmpty(str)) {
            return Integer.parseInt(str);
        }
        return null;
    }

    public BaseUser getBaseUser() {
        BaseUser baseUser = null;
        String token = getToken();
        if (StringUtils.isNotEmpty(token)) {
            baseUser = cacheClient.getToken(token, BaseUser.class);
        }
        if (baseUser == null) {
            throw new BaseException(BaseResult.INTERNAL_SERVER_ERROR);
        }
        return baseUser;
    }

    /**
     * 获取token
     *
     * @return
     */
    protected String getToken() {
        String token = this.getRequest().getHeader("token");
        return token;
    }

    /**
     * 对外提供缓存客户端
     *
     * @return
     */
    public CacheClient getCacheClient() {
        return cacheClient;
    }

}
