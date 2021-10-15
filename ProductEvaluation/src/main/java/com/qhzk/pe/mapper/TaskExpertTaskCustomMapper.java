package com.qhzk.pe.mapper;

import com.qhzk.pe.data.TaskData;
import com.qhzk.pe.data.TaskExpertTaskData;
import com.qhzk.pe.utils.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface TaskExpertTaskCustomMapper {
    /**
     * 获取总记录数专家评价任务
     * @param  taskexperttask
     * @return
     */
    Long countTaskExpertTaskPageInfo(@Param("value") TaskExpertTaskData taskexperttask);
    /**
     * 获取分页专家评价任务
     * @param  taskexperttask
     * @return
     */
    List<TaskExpertTaskData> queryTaskExpertTaskPageInfo(@Param("page") PageInfo page,@Param("value") TaskExpertTaskData taskexperttask);

    /**
     * 根据id获取专家评价任务信息
     * @param pkid
     * @return
     */
    TaskExpertTaskData selectByPrimaryKey(Long pkid);
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
    int batchUpdateValues(@Param("values")List<TaskExpertTaskData> values);
    /**
     * 批量修改
     * @param values
     * @param pkid
     * @return
     */
    int batchInsertValues(@Param("values")List<TaskExpertTaskData> values,@Param("pkid")Long pkid);
    /**
     * 添加记录
     * @param value
     * @return
     */
    int insert(TaskExpertTaskData value);

    /**
     * 修改记录
     * @param value
     * @return
     */
    int updateByPrimaryKey(TaskExpertTaskData value);

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
