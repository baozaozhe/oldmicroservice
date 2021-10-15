package com.qhzk.pe.mapper;

import com.qhzk.pe.data.EvaluationStandardItemData;
import com.qhzk.pe.utils.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EvaluationStandardItemCustomMapper {
    /**
     * 获取总记录数评价标准明细
     * @param  evaluationstandarditem
     * @return
     */
    Long countEvaluationStandardItemPageInfo(@Param("value") EvaluationStandardItemData evaluationstandarditem);
    /**
     * 获取分页评价标准明细
     * @param  evaluationstandarditem
     * @return
     */
    List<EvaluationStandardItemData> queryEvaluationStandardItemPageInfo(@Param("page") PageInfo page,@Param("value") EvaluationStandardItemData evaluationstandarditem);

    /**
     * 根据id获取评价标准明细信息
     * @param pkid
     * @return
     */
    EvaluationStandardItemData selectByPrimaryKey(Long pkid);
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
    int batchUpdateValues(@Param("values")List<EvaluationStandardItemData> values);
    /**
     * 批量修改
     * @param values
     * @param pkid
     * @return
     */
    int batchInsertValues(@Param("values")List<EvaluationStandardItemData> values,@Param("pkid")Long pkid);
    /**
     * 添加记录
     * @param value
     * @return
     */
    int insert(EvaluationStandardItemData value);

    /**
     * 修改记录
     * @param value
     * @return
     */
    int updateByPrimaryKey(EvaluationStandardItemData value);

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
