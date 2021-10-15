package com.qhzk.as.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qhzk.as.entity.RoleUser;
import com.qhzk.as.entity.UserRoles;

/**
 * 用户-角色关联信息接口
 * @author: Mr.Muxl
 * @date 2021-08-05
 */
public interface RoleUserService extends IService<RoleUser> {
    /**
     * 根据用户id获取用户的角色列表
     * @param id
     * @param type
     * @return
     */
    public UserRoles getUserRolesByUid(long id,String type);
}
