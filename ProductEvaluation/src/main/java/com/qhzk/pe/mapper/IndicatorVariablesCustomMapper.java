package com.qhzk.pe.mapper;

import com.qhzk.pe.data.IndicatorVariablesData;
import com.qhzk.pe.utils.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IndicatorVariablesCustomMapper {
    /**
     * 获取总记录数评价指标项
     * @param  indicatorvariables
     * @return
     */
    Long countIndicatorVariablesPageInfo(@Param("value") IndicatorVariablesData indicatorvariables);
    /**
     * 获取分页评价指标项
     * @param  indicatorvariables
     * @return
     */
    List<IndicatorVariablesData> queryIndicatorVariablesPageInfo(@Param("page") PageInfo page, @Param("value") IndicatorVariablesData indicatorvariables);

    /**
    * 根据id获取评价指标项信息
    * @param pkid
    * @return
    */
	IndicatorVariablesData selectByPrimaryKey(Long pkid);
    /**
    * 删除
    * @param pkid
    * @return
    */
    int deleteIndicatorVariablesByPrimaryKey(Long pkid);

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
    int batchUpdateValues(@Param("values")List<IndicatorVariablesData> values);
    /**
     * 批量修改
     * @param values
     * @param pkid
     * @return
     */
    int batchInsertValues(@Param("values")List<IndicatorVariablesData> values,@Param("pkid")Long pkid);
    /**
     * 添加记录
     * @param value
     * @return
     */
    int insert(IndicatorVariablesData value);

    /**
     * 修改记录
     * @param value
     * @return
     */
    int updateByPrimaryKey(IndicatorVariablesData value);

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
