package com.qhzk.as.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qhzk.as.entity.Permissions;
import com.qhzk.as.mapper.PermissionsMapper;
import com.qhzk.as.service.PermissionsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限信息 Service实现类
 * @author: Mr.Muxl
 * @date 2021-08-05
 */

@Service
public class PermissionsServiceImpl extends ServiceImpl<PermissionsMapper,Permissions> implements PermissionsService {
	@Resource
	private PermissionsMapper permissionsmapper;

	@Override
	public List<Permissions> getRolesPermissByRid(long id) {
		return permissionsmapper.getRolesPermissByRid(id);
	}
}
