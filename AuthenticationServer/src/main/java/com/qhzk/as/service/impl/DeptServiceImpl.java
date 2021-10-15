package com.qhzk.as.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qhzk.as.entity.Dept;
import com.qhzk.as.entity.User;
import com.qhzk.as.mapper.DeptMapper;
import com.qhzk.as.mapper.UserMapper;
import com.qhzk.as.service.DeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门信息 Service实现类
 * @author: Mr.Muxl
 * @date 2021-08-05
 */

@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper,Dept> implements DeptService {
	@Resource
	private DeptMapper deptmapper;
	@Resource
	private UserMapper userMapper;

	@Override
	public List<Dept> queryDeptUsersById(long id, String currflag) {
		if("Y".equals(currflag)){
			List<Dept> depts = new ArrayList<>();
			Dept dept = deptmapper.selectById(id);
			List<User> users = userMapper.queryUsersByDId(id);
			if(null != users &&!users.isEmpty() ){
				dept.setUsers(users);
			}

			depts.add(dept);

			return  depts;
		}
		return deptmapper.queryDeptUsersById(id);
	}
}
