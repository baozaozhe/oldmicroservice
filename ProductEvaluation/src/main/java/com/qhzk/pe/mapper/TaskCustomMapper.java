package com.qhzk.pe.mapper;

import com.qhzk.pe.data.TaskData;
import com.qhzk.pe.utils.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TaskCustomMapper {
    /**
     * 获取总记录数评价任务
     * @param  task
     * @return
     */
    Long countTaskPageInfo(@Param("value") TaskData task);
    /**
     * 获取分页评价任务
     * @param  task
     * @return
     */
    List<TaskData> queryTaskPageInfo(@Param("page") PageInfo page, @Param("value") TaskData task);

    /**
    * 根据id获取评价任务信息
    * @param pkid
    * @return
    */
	TaskData selectByPrimaryKey(Long pkid);
    /**
    * 删除
    * @param pkid
    * @return
    */
    int deleteTaskByPrimaryKey(Long pkid);

    /**
     * 修改
     * @param val
     * @return
     */
    int updateByPrimaryKey(TaskData val);

    /**
     * 删除
     * @param pkid
     * @return
     */
    int stopTask(Long pkid);


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
    int insert(TaskData value);

}
