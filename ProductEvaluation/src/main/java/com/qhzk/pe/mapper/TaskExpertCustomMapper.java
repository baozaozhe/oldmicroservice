package com.qhzk.pe.mapper;

import com.qhzk.pe.data.TaskData;
import com.qhzk.pe.data.TaskExpertData;
import com.qhzk.pe.data.TaskSpecimenData;
import com.qhzk.pe.utils.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TaskExpertCustomMapper {
    /**
     * 获取总记录数评价专家表
     * @param  taskexpert
     * @return
     */
    Long countTaskExpertPageInfo(@Param("value") TaskExpertData taskexpert);
    /**
     * 获取分页评价专家表
     * @param  taskexpert
     * @return
     */
    List<TaskExpertData> queryTaskExpertPageInfo(@Param("page") PageInfo page,@Param("value") TaskExpertData taskexpert);

    /**
     * 根据id获取评价专家表信息
     * @param pkid
     * @return
     */
    TaskExpertData selectByPrimaryKey(Long pkid);
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
    int batchUpdateValues(@Param("values")List<TaskExpertData> values);
    /**
     * 批量修改
     * @param values
     * @return
     */
    int batchInsertValues(@Param("values")List<TaskExpertData> values);
    /**
     * 添加记录
     * @param value
     * @return
     */
    int insert(TaskExpertData value);

    /**
     * 修改记录
     * @param value
     * @return
     */
    int updateByPrimaryKey(TaskExpertData value);

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
     * 根据用户id获取评价任务信息
     * @param userid
     * @return
     */
    List<TaskData> getCurrentUserTask(Long userid);
    /**
     * 根据Taskid获取评价任务信息
     * @param pkid
     * @return
     */
    List<TaskData> selectByTaskid(Long pkid);
}
