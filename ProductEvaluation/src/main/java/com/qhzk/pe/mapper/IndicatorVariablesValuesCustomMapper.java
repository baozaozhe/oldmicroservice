package com.qhzk.pe.mapper;

import com.qhzk.pe.data.IndicatorVariablesValuesData;
import com.qhzk.pe.utils.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IndicatorVariablesValuesCustomMapper {
    /**
     * 获取总记录数评价指标项值
     * @param  indicatorvariablesvalues
     * @return
     */
    Long countIndicatorVariablesValuesPageInfo(@Param("value") IndicatorVariablesValuesData indicatorvariablesvalues);
    /**
     * 获取分页评价指标项值
     * @param  indicatorvariablesvalues
     * @return
     */
    List<IndicatorVariablesValuesData> queryIndicatorVariablesValuesPageInfo(@Param("page") PageInfo page,@Param("value") IndicatorVariablesValuesData indicatorvariablesvalues);

    /**
     * 根据id获取评价指标项值信息
     * @param pkid
     * @return
     */
    IndicatorVariablesValuesData selectByPrimaryKey(Long pkid);
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
    int batchUpdateValues(@Param("values")List<IndicatorVariablesValuesData> values);
    /**
     * 批量修改
     * @param values
     * @return
     */
    int batchInsertValues(@Param("values")List<IndicatorVariablesValuesData> values);
    /**
     * 添加记录
     * @param value
     * @return
     */
    int insert(IndicatorVariablesValuesData value);

    /**
     * 修改记录
     * @param value
     * @return
     */
    int updateByPrimaryKey(IndicatorVariablesValuesData value);

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
