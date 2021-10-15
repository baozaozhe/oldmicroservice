package com.qhzk.as.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qhzk.as.entity.Role;
import com.qhzk.as.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    //根据用户组id获取当前用户组下的角色
    List<Role> queryRolesByRId(long ugroupid);
}
