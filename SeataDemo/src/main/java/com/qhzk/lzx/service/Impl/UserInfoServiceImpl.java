package com.qhzk.lzx.service.Impl;

import com.qhzk.lzx.entity.UserInfo;
import com.qhzk.lzx.mapper.UserInfoMapper;
import com.qhzk.lzx.service.UserInfoService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Mr.Muxl
 * @create: 2021-08-02 11:27
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoMapper userInfomapper;
    @Override
    @GlobalTransactional(name = "default",rollbackFor = Exception.class)
    public boolean insert(UserInfo user) throws Exception {
        boolean a = userInfomapper.insert(user) > 0;
        return userInfomapper.insert(user) > 0;
//        try {
//            int b = 10/0;
//            System.out.println(b);
//            boolean a = userInfomapper.insert(user) > 0;
//            int C = 1/0;
//            return userInfomapper.insert(user) > 0;
//        }catch (Exception e){
//
//        }finally {
//            throw new Exception("sdfa");
//        }
    }
}
