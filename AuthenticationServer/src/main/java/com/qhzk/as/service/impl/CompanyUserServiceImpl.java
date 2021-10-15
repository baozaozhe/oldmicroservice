package com.qhzk.as.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qhzk.as.entity.CompanyUser;
import com.qhzk.as.entity.User;
import com.qhzk.as.mapper.CompanyUserMapper;
import com.qhzk.as.service.CompanyUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公司-用户 Service实现类
 * @author: Mr.Muxl
 * @date 2021-08-05
 */

@Service
public class CompanyUserServiceImpl extends ServiceImpl<CompanyUserMapper,CompanyUser> implements CompanyUserService {
	@Resource
	private CompanyUserMapper companyusermapper;

	@Override
	public List<User> queryCompanyUsersById(long id) {
		return companyusermapper.queryCompanyUsersById(id);
	}
}
