package com.qhzk.pe.mapper;

import com.qhzk.pe.data.TaskSpecimenData;
import com.qhzk.pe.data.TaskStandardData;
import com.qhzk.pe.utils.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TaskStandardCustomMapper {
    /**
     * 获取总记录数评价任务使用标准
     * @param  taskstandard
     * @return
     */
    Long countTaskStandardPageInfo(@Param("value") TaskStandardData taskstandard);
    /**
     * 获取分页评价任务使用标准
     * @param  taskstandard
     * @return
     */
    List<TaskStandardData> queryTaskStandardPageInfo(@Param("page") PageInfo page, @Param("value") TaskStandardData taskstandard);

    /**
    * 根据id获取评价任务使用标准信息
    * @param pkid
    * @return
    */
	TaskStandardData selectByPrimaryKey(Long pkid);
    /**
     * 根据id获取评价专家信息
     * @param pkid
     * @return
     */
    List<TaskSpecimenData> selectByTaskid(Long pkid);
    /**
    * 删除
    * @param pkid
    * @return
    */
    int deleteLogicTaskStandardByPrimaryKey(Long pkid);

    /**
    * 批量修改
    * @param values
    * @return
    */
    int batchUpdateValues(@Param("values") List<TaskStandardData> values);
    /**
    * 批量修改
    * @param values
    * @return
    */
    int batchInsertValues(@Param("values") List<TaskStandardData> values);

    /**
     * 添加记录
     * @param val
     * @return
     */
    int insert(TaskStandardData val);

    /**
     * 修改记录
     * @param val
     * @return
     */
    int updateByPrimaryKey(TaskStandardData val);

    /**
     * 删除
     * @param pkid
     * @return
     */
    int deleteRealByPrimaryKey(Long pkid);
}
