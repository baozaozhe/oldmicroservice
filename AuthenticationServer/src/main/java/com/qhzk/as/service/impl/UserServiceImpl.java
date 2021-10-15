package com.qhzk.as.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qhzk.as.entity.User;
import com.qhzk.as.mapper.UserMapper;
import com.qhzk.as.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户信息 Service实现类，用户信息 Service实现类
 * @author: Mr.Muxl
 * @date 2021-08-04
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
	@Resource
	private UserMapper usercustommapper;
}
