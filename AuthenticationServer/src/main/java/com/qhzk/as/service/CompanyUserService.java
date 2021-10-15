package com.qhzk.as.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qhzk.as.entity.CompanyUser;
import com.qhzk.as.entity.User;

import java.util.List;

/**
 * 公司-用户接口
 * @author: Mr.Muxl
 * @date 2021-08-05
 */
public interface CompanyUserService extends IService<CompanyUser> {
   public List<User> queryCompanyUsersById(long id);
}
