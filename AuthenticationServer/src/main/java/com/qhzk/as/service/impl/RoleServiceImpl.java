package com.qhzk.as.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qhzk.as.entity.Role;
import com.qhzk.as.mapper.RoleMapper;
import com.qhzk.as.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * 角色信息 Service实现类
 * @author: Mr.Muxl
 * @date 2021-08-05
 */

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements RoleService {
	@Resource
	private RoleMapper rolemapper;
}
