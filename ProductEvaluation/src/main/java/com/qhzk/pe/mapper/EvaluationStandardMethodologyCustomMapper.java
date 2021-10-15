package com.qhzk.pe.mapper;

import com.qhzk.pe.data.EvaluationStandardMethodologyData;
import com.qhzk.pe.utils.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EvaluationStandardMethodologyCustomMapper {
    /**
     * 获取总记录数评价标准适用评价方法
     * @param  evaluationstandardmethodology
     * @return
     */
    Long countEvaluationStandardMethodologyPageInfo(@Param("value") EvaluationStandardMethodologyData evaluationstandardmethodology);
    /**
     * 获取分页评价标准适用评价方法
     * @param  evaluationstandardmethodology
     * @return
     */
    List<EvaluationStandardMethodologyData> queryEvaluationStandardMethodologyPageInfo(@Param("page") PageInfo page,@Param("value") EvaluationStandardMethodologyData evaluationstandardmethodology);

    /**
     * 根据id获取评价标准适用评价方法信息
     * @param pkid
     * @return
     */
    EvaluationStandardMethodologyData selectByPrimaryKey(Long pkid);
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
    int batchUpdateValues(@Param("values")List<EvaluationStandardMethodologyData> values);
    /**
     * 批量修改
     * @param values
     * @param pkid
     * @return
     */
    int batchInsertValues(@Param("values")List<EvaluationStandardMethodologyData> values,@Param("pkid")Long pkid);
    /**
     * 添加记录
     * @param value
     * @return
     */
    int insert(EvaluationStandardMethodologyData value);

    /**
     * 修改记录
     * @param value
     * @return
     */
    int updateByPrimaryKey(EvaluationStandardMethodologyData value);

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
