package com.qhzk.lzx.controller;

import com.qhzk.lzx.common.CommonResult;
import com.qhzk.lzx.entity.UserInfo;
import com.qhzk.lzx.service.UserInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Mr.Muxl
 * @create: 2021-08-02 11:25
 **/
@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Resource
    private UserInfoService userinfoservice;

    @RequestMapping(value = "/add", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult<UserInfo> getAttributesById() throws Exception {
        UserInfo user =  new UserInfo("0001","大魏天龙","18388723001");
        if (!userinfoservice.insert(user)) {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"失败");
        }
        return new CommonResult<>( HttpStatus.OK.value(),"成功");
    }
}
