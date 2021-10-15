package com.qhzk.pe.mapper;

import com.qhzk.pe.data.TaskSpecimenData;
import com.qhzk.pe.utils.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TaskSpecimenCustomMapper {

    /**
     * 获取总记录数评价任务样品
     * @param  taskspecimen
     * @return
     */
    Long countTaskSpecimenPageInfo(@Param("value") TaskSpecimenData taskspecimen);
    /**
     * 获取分页评价任务样品
     * @param  taskspecimen
     * @return
     */
    List<TaskSpecimenData> queryTaskSpecimenPageInfo(@Param("page") PageInfo page,@Param("value") TaskSpecimenData taskspecimen);

    /**
     * 根据id获取评价任务样品信息
     * @param pkid
     * @return
     */
    TaskSpecimenData selectByPrimaryKey(Long pkid);
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
    int batchUpdateValues(@Param("values")List<TaskSpecimenData> values);
    /**
     * 批量修改
     * @param values
     * @return
     */
    int batchInsertValues(@Param("values")List<TaskSpecimenData> values);
    /**
     * 添加记录
     * @param value
     * @return
     */
    int insert(TaskSpecimenData value);

    /**
     * 修改记录
     * @param value
     * @return
     */
    int updateByPrimaryKey(TaskSpecimenData value);

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
     * 根据id获取评价专家信息
     * @param pkid
     * @return
     */
    List<TaskSpecimenData> selectByTaskid(Long pkid);
}
