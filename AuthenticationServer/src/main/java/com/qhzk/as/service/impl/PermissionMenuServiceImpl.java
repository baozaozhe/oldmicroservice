package com.qhzk.as.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qhzk.as.entity.PermissionMenu;
import com.qhzk.as.mapper.PermissionMenuMapper;
import com.qhzk.as.service.PermissionMenuService;
import org.springframework.stereotype.Service;

/**
 * 权限-菜单信息 Service实现类
 * @author: Mr.Muxl
 * @date 2021-08-05
 */

@Service
public class PermissionMenuServiceImpl extends ServiceImpl<PermissionMenuMapper,PermissionMenu> implements PermissionMenuService {
	@Resource
	private PermissionMenuMapper permissionmenumapper;
}
