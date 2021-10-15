package com.qhzk.as.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qhzk.as.entity.Permissions;

import java.util.List;

/**
 * 权限信息接口
 * @author: Mr.Muxl
 * @date 2021-08-05
 */
public interface PermissionsService extends IService<Permissions> {
    /**
     * 根据角色id获取权限列表
     * @param id
     * @return
     */
    public  List<Permissions> getRolesPermissByRid(long id);
}
