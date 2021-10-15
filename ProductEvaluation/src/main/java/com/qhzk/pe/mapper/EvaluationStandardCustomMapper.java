package com.qhzk.pe.mapper;

import com.qhzk.pe.data.EvaluationStandardData;
import com.qhzk.pe.data.EvaluationStandardItemData;
import com.qhzk.pe.data.EvaluationStandardMethodologyData;
import com.qhzk.pe.data.EvaluationStandardScopeData;
import com.qhzk.pe.utils.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EvaluationStandardCustomMapper {
    /**
     * 获取总记录数评价标准
     * @param  evaluationstandard
     * @return
     */
    Long countEvaluationStandardPageInfo(@Param("value") EvaluationStandardData evaluationstandard);
    /**
     * 获取分页评价标准
     * @param  evaluationstandard
     * @return
     */
    List<EvaluationStandardData> queryEvaluationStandardPageInfo(@Param("page") PageInfo page, @Param("value") EvaluationStandardData evaluationstandard);

    /**
    * 根据id获取评价标准信息
    * @param pkid
    * @return
    */
	EvaluationStandardData selectByPrimaryKey(Long pkid);
    /**
    * 删除
    * @param pkid
    * @return
    */
    int deleteEvaluationStandardByPrimaryKey(Long pkid);

    /**
     * 批量修改 评价标准适用范围
     * @param values
     * @return
     */
    int batchUpdateScopeValues(@Param("values")List<EvaluationStandardScopeData> values);
    /**
     * 批量添加 评价标准适用范围
     * @param values
     * @param
     * @return
     */
    int batchInsertScopeValues(@Param("values")List<EvaluationStandardScopeData> values);


    /**
     * 批量修改评价标准明细
     * @param values
     * @return
     */
    int batchUpdateItemValues(@Param("values")List<EvaluationStandardItemData> values);
    /**
     * 批量添加评价标准明细
     * @param values
     * @param
     * @return
     */
    int batchInsertItemValues(@Param("values")List<EvaluationStandardItemData> values);
    /**
     * 添加记录
     * @param value
     * @return
     */
    int insert(EvaluationStandardData value);

    /**
     * 修改记录
     * @param value
     * @return
     */
    int updateByPrimaryKey(EvaluationStandardData value);
    /**
     * 修改标准适用方法
     * @param val
     * @return
     */
    int updateMethodoValues(@Param("val")EvaluationStandardMethodologyData val);
    /**
     * 添加标准适用方法
     * @param val
     * @param
     * @return
     */
    int insertMethodoValues(@Param("value")EvaluationStandardMethodologyData val);
    /**
     * 批量真实删除Speattrs
     * @param infos
     * @return
     */
    int batchRealDeleteInfo(@Param("infos")List<String> infos);
    /**
     * 根据评价对象、方法获取标准
     * @param mean scope
     * @return
     */
    List<EvaluationStandardData> getEvalstandardByMeanAndScope(@Param("mean")String mean, @Param("scope")String scope);
}
