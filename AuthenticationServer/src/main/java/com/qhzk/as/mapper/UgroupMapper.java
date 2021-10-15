package com.qhzk.as.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qhzk.as.entity.Ugroup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UgroupMapper extends BaseMapper<Ugroup> {
    //根据当前用户组id获取当前及其下用户组的用户
    List<Ugroup> queryUgroupUsersById(long id);
}
