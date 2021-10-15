package com.qhzk.as.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qhzk.as.entity.Role;
import com.qhzk.as.entity.RoleUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleUserMapper extends BaseMapper<RoleUser> {
    /**
     * 根据用户id获取用户关联的角色列表
     */
     List<Role> getUserRolesByUid(long id);
    /**
     * 根据用户id获取用户组关联的角色列表
     */
    List<Role> getUserGroupRolesByUid(long id);
}
