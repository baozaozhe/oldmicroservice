package com.qhzk.as.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qhzk.as.entity.UserUgroup;
import com.qhzk.as.mapper.UserUgroupMapper;
import com.qhzk.as.service.UserUgroupService;
import org.springframework.stereotype.Service;

/**
 * 用户组-用户关联信息 Service实现类
 * @author: Mr.Muxl
 * @date 2021-08-05
 */

@Service
public class UserUgroupServiceImpl extends ServiceImpl<UserUgroupMapper,UserUgroup> implements UserUgroupService {
	@Resource
	private UserUgroupMapper userugroupmapper;
}
