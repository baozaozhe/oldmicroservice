package com.qhzk.pe.mapper;

import com.qhzk.pe.data.DictionaryData;
import com.qhzk.pe.utils.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DictionaryCustomMapper {
    /**
     * 获取总记录数字典管理
     * @param  dictionary
     * @return
     */
    Long countDictionaryPageInfo(@Param("value") DictionaryData dictionary);
    /**
     * 获取分页字典管理
     * @param  dictionary
     * @return
     */
    List<DictionaryData> queryDictionaryPageInfo(@Param("page") PageInfo page,@Param("value") DictionaryData dictionary);

    /**
     * 根据id获取字典管理信息
     * @param pkid
     * @return
     */
    DictionaryData selectByPrimaryKey(Long pkid);
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
    int batchUpdateValues(@Param("values")List<DictionaryData> values);
    /**
     * 批量修改
     * @param values
     * @param pkid
     * @return
     */
    int batchInsertValues(@Param("values")List<DictionaryData> values,@Param("pkid")Long pkid);
    /**
     * 添加记录
     * @param value
     * @return
     */
    int insert(DictionaryData value);

    /**
     * 修改记录
     * @param value
     * @return
     */
    int updateByPrimaryKey(DictionaryData value);

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
    /**
     * 获取评价标准适用范围
     * @param pcodes
     * @return
     */
    List<DictionaryData> getEvaluatScopes( @Param("pcodes") List<String> pcodes);
}
