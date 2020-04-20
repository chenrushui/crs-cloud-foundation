package com.xxx.foundation.client;

import com.xxx.foundation.common.base.BaseResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created on 2020/4/20 11:21
 * author:crs
 * Description:测试ControllerFeign接口
 */

//todo:服务名称可以从eureka上获得
@FeignClient(name = "8090-cloud-foundation")
public interface TestClient {

    /**
     * 注意,定义此接口时,@RequestParam("xxx")和@ReqeustHead("xxx")必须写value.
     *
     *
     * @return
     */
    @GetMapping("/base/test/swagger")
    BaseResponse testSwagger();


}
