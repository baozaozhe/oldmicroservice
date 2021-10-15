package com.qhzk.pe.mapper;

import com.qhzk.pe.data.SpecimenAttrsData;
import com.qhzk.pe.data.SpecimenData;
import com.qhzk.pe.utils.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SpecimenCustomMapper {
    /**
     * 获取总记录数样品+详细信息
     * @param specimen
     * @return
     */
    Long countSpecimenPageInfo(@Param("value") SpecimenData specimen);
    /**
     * 获取分页样品+详细信息
     * @param specimen
     * @return
     */
    List<SpecimenData> querySpecimenPageInfo(@Param("page") PageInfo page,@Param("value") SpecimenData specimen);

    /**
     * 详细品扩展属性信息
     * @param spkid
     * @return
     */
    List<SpecimenAttrsData> querySpecimenAttrs(Long spkid);

    /**
     * 根据id获取样品+详细信息
     * @param pkid
     * @return
     */
    SpecimenData selectByPrimaryKey(Long pkid);

    /**
     * 批量修改
     * @param attrsdatas
     * @return
     */
    int batchUpdateSpeattrs(@Param("attrsdatas")List<SpecimenAttrsData> attrsdatas);
    /**
     * 批量修改
     * @param attrsdatas
     * @return
     */
    int batchInsertSpeattrs(@Param("attrsdatas")List<SpecimenAttrsData> attrsdatas);
    /**
     * 删除
     * @param pkid
     * @return
     */
    int deleteSpecimenByPrimaryKey(Long pkid);
    /**
     * 删除Speattrs
     * @param speid
     * @return
     */
    int deleteSpeattrsBySpeid(Long speid);

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
     * 添加记录
     * @param value
     * @return
     */
    int insert(SpecimenData value);

    /**
     * 修改记录
     * @param value
     * @return
     */
    int updateByPrimaryKey(SpecimenData value);

}
