package com.qhzk.as.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qhzk.as.entity.Permissions;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionsMapper extends BaseMapper<Permissions> {
    /**
     * 根据角色id获取权限列表
     * @param id
     * @return
     */
    List<Permissions> getRolesPermissByRid(long id);
}
