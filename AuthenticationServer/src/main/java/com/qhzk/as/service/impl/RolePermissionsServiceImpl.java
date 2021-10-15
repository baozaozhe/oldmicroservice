package com.qhzk.as.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qhzk.as.entity.RolePermissions;
import com.qhzk.as.mapper.RolePermissionsMapper;
import com.qhzk.as.service.RolePermissionsService;
import org.springframework.stereotype.Service;

/**
 * 用户组-角色关联信息 Service实现类
 * @author: Mr.Muxl
 * @date 2021-08-05
 */

@Service
public class RolePermissionsServiceImpl extends ServiceImpl<RolePermissionsMapper,RolePermissions> implements RolePermissionsService {
	@Resource
	private RolePermissionsMapper rolepermissionsmapper;
}
