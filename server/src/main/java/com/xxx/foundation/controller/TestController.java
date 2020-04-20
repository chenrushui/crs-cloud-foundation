package com.xxx.foundation.controller;

import com.xxx.foundation.base.BaseController;
import com.xxx.foundation.base.BaseException;
import com.xxx.foundation.common.base.BaseResponse;
import com.xxx.foundation.common.base.BaseResult;
import com.xxx.foundation.entity.TestEntity;
import com.xxx.foundation.utils.CacheClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2020/4/20 13:38
 * author:crs
 * Description:主要用于测试封装的组件是否可用
 */
@Api(description = "测试基础资源")
@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

    @ApiOperation(value="测试swagger的封装")
    @GetMapping("/swagger")
    public BaseResponse testSwagger() {
        TestEntity testEntity = new TestEntity(1,"crs");
        return BaseResponse.toResponse(testEntity);
    }

    @ApiOperation(value="测试全局异常的封装")
    @GetMapping("/exception")
    public BaseResponse testException() {
        throw new BaseException(BaseResult.INTERNAL_SERVER_ERROR);
    }

    @ApiOperation(value="测试Cache的封装")
    @GetMapping("/cache")
    public BaseResponse testCache() {
        CacheClient cacheClient = super.getCacheClient();
        return BaseResponse.toResponse(cacheClient);
    }








}
