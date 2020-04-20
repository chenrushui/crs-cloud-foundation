package com.xxx.foundation.utils;

import com.xxx.foundation.base.BaseUser;
import org.springframework.stereotype.Component;

/**
 * Created on 2020/4/17 17:11
 * author:crs
 * Description:主要用于实例化CacheClient客户端。
 */
@Component
public class CacheClient {

    //todo:从redis中获取用户信息,这个函数需要单独进行封装。
    public BaseUser getToken(String token, Class<BaseUser> baseUserClass) {
        //通过用户id获取用户属性集合Map
        //通过ObjectMapper的读写操作进行获取对象实例
        return new BaseUser();
    }
}
