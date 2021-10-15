package com.qhzk.as.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qhzk.as.entity.Dept;

import java.util.List;

/**
 * 部门信息接口
 * @author: Mr.Muxl
 * @date 2021-08-05
 */
public interface DeptService extends IService<Dept> {
    public  List<Dept> queryDeptUsersById(long id, String currflag);
}
