package com.qhzk.as.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qhzk.as.entity.Ugroup;

import java.util.List;

/**
 * 用户组信息接口
 * @author: Mr.Muxl
 * @date 2021-08-05
 */
public interface UgroupService extends IService<Ugroup> {
    public List<Ugroup> queryUgroupUsersRoleById(long id, String currflag);
}
