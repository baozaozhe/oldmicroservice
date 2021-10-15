package com.qhzk.pe.feignclient;

import com.qhzk.pe.config.FeignSupportConfig;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description: 用户接口
 * @author: Mr.Muxl
 * @create: 2021-07-13 10:23
 **/
@Component
@FeignClient(value = "GATEWAYSERVER",configuration = FeignSupportConfig.class)
public interface AuthServerFeignClient {
    /**
     * 验证token是否存在
     * @return
     */
    @RequestMapping(value = "/as/user/tokenIsExist",method = RequestMethod.GET)
    public String tokenIsExist(@RequestParam(value = "token",required = true) String token);
}
