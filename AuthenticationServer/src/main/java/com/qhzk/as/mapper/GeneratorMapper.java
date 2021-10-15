package com.qhzk.as.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qhzk.as.entity.ColumnInfo;
import com.qhzk.as.entity.Tables;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Mr.Muxl
 * @create: 2021-08-26 16:20
 **/
@Mapper
public interface GeneratorMapper {
    List<Tables> getTables(@Param("name") String name);
    List<ColumnInfo> queryColumnInfos(@Param("name") String name);
}
