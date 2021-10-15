package com.qhzk.as.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qhzk.as.entity.Ugroup;
import com.qhzk.as.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    //根据部门id获取当前部门下的员工
    List<User> queryUsersByDId ( long deptid);
    //根据用户组id获取当前用户组下的用户
    List<User> queryUsersByUId(long ugroupid);
}
