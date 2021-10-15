package com.qhzk.as.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qhzk.as.entity.DeptUser;
import com.qhzk.as.mapper.DeptUserMapper;
import com.qhzk.as.service.DeptUserService;
import org.springframework.stereotype.Service;

/**
 * 部门-用户 Service实现类
 * @author: Mr.Muxl
 * @date 2021-08-05
 */

@Service
public class DeptUserServiceImpl extends ServiceImpl<DeptUserMapper,DeptUser> implements DeptUserService {
	@Resource
	private DeptUserMapper deptusermapper;
}
