package com.qhzk.as.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qhzk.as.entity.Role;
import com.qhzk.as.entity.RoleUser;
import com.qhzk.as.entity.UserRoles;
import com.qhzk.as.mapper.RoleUserMapper;
import com.qhzk.as.service.RoleUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户-角色关联信息 Service实现类
 * @author: Mr.Muxl
 * @date 2021-08-05
 */

@Service
public class RoleUserServiceImpl extends ServiceImpl<RoleUserMapper,RoleUser> implements RoleUserService {
	@Resource
	private RoleUserMapper roleusermapper;

	/**
	 * 根据用户id获取用户的角色列表
	 * @param id
	 * @param type
	 * @return
	 */
	@Override
	public UserRoles getUserRolesByUid(long id, String type) {

		UserRoles roles = new UserRoles();

		if("A".equals(type)){//查询全部角色
			List<Role> ur = roleusermapper.getUserRolesByUid(id);
			List<Role> ug = roleusermapper.getUserGroupRolesByUid(id);
			roles.setRoles(ur);
			roles.setUgroups(ug);
		}
		else if("R".equals(type)){//R查询用户关联角色
			List<Role> ur = roleusermapper.getUserRolesByUid(id);
			roles.setRoles(ur);
		}
		else if("U".equals(type)){//U 查询用户组角色
			List<Role> ug = roleusermapper.getUserGroupRolesByUid(id);
			roles.setUgroups(ug);
		}
		return roles;
	}
}
