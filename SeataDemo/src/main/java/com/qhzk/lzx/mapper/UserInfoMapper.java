package com.qhzk.lzx.mapper;

import com.qhzk.lzx.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {
    int insert(UserInfo user);
}
