package com.qhzk.pe.mapper.custom;

import com.qhzk.pe.data.${objectName}Data;
import com.qhzk.pe.utils.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ${objectName}CustomMapper {
    /**
     * 获取总记录数${title}
     * @param  ${mapping}
     * @return
     */
    Long count${objectName}PageInfo(@Param("value") ${objectName}Data ${mapping});
    /**
     * 获取分页${title}
     * @param  ${mapping}
     * @return
     */
    List<${objectName}Data> query${objectName}PageInfo(@Param("page") PageInfo page,@Param("value") ${objectName}Data ${mapping});

    /**
    * 根据id获取${title}信息
    * @param pkid
    * @return
    */
	${objectName}Data selectByPrimaryKey(Long pkid);
    /**
    * 逻辑删除
    * @param pkid
    * @return
    */
    int deleteLogicByPrimaryKey(Long pkid);

    /**
    * 批量修改
    * @param values
    * @return
    */
    int batchUpdateValues(@Param("values")List<${objectName}Data> values);
    /**
    * 批量修改
    * @param values
    * @param pkid
    * @return
    */
    int batchInsertValues(@Param("values")List<${objectName}Data> values,@Param("pkid")Long pkid);
    /**
    * 添加记录
    * @param value
    * @return
    */
    int insert(${objectName}Data value);

    /**
    * 修改记录
    * @param value
    * @return
    */
    int updateByPrimaryKey(${objectName}Data value);

    /**
    * 删除
    * @param pkid
    * @return
    */
    int deleteRealByPrimaryKey(Long pkid);

    /**
    * 批量逻辑删除Speattrs
    * @param infos
    * @return
    */
    int batchLogicDeleteInfo(@Param("infos")List<String> infos);

    /**
    * 批量真实删除Speattrs
    * @param infos
    * @return
    */
    int batchRealDeleteInfo(@Param("infos")List<String> infos);
}
