package com.qhzk.as.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qhzk.as.entity.CompanyUser;
import com.qhzk.as.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyUserMapper extends BaseMapper<CompanyUser> {
    List<User> queryCompanyUsersById(long id);
    List<User> queryCompanyUsersByIds(List<Long> s);
}
