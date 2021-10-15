package com.qhzk.as.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qhzk.as.entity.UgroupRole;
import com.qhzk.as.mapper.UgroupRoleMapper;
import com.qhzk.as.service.UgroupRoleService;
import org.springframework.stereotype.Service;

/**
 * 用户组-角色关联信息 Service实现类
 * @author: Mr.Muxl
 * @date 2021-08-05
 */

@Service
public class UgroupRoleServiceImpl extends ServiceImpl<UgroupRoleMapper,UgroupRole> implements UgroupRoleService {
	@Resource
	private UgroupRoleMapper ugrouprolemapper;
}
