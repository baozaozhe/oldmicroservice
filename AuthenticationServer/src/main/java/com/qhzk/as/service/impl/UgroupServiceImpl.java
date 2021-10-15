package com.qhzk.as.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qhzk.as.entity.Role;
import com.qhzk.as.entity.Ugroup;
import com.qhzk.as.entity.User;
import com.qhzk.as.mapper.RoleMapper;
import com.qhzk.as.mapper.UgroupMapper;
import com.qhzk.as.mapper.UserMapper;
import com.qhzk.as.service.UgroupService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户组信息 Service实现类
 * @author: Mr.Muxl
 * @date 2021-08-05
 */

@Service
public class UgroupServiceImpl extends ServiceImpl<UgroupMapper,Ugroup> implements UgroupService {
	@Resource
	private UgroupMapper ugroupmapper;
	@Resource
	private UserMapper usermapper;
	@Resource
	private RoleMapper rolemapper;

	@Override
	public List<Ugroup> queryUgroupUsersRoleById(long id, String currflag) {
		if("Y".equals(currflag)){
			List<Ugroup> ugroups = new ArrayList<>();
			Ugroup ugroup = ugroupmapper.selectById(id);

			List<User> users = usermapper.queryUsersByUId(id);
			if(null != users &&!users.isEmpty() ){
				ugroup.setUsers(users);
			}

			List<Role> roles = rolemapper.queryRolesByRId(id);
			if(null != roles &&!roles.isEmpty() ){
				ugroup.setRoles(roles);
			}

			ugroups.add(ugroup);
			return  ugroups;
		}
		return ugroupmapper.queryUgroupUsersById(id);
	}
}
