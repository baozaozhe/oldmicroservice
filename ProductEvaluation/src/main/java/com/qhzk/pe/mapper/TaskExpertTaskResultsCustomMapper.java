package com.qhzk.pe.mapper;

import com.qhzk.pe.data.TaskExpertTaskResultsData;
import com.qhzk.pe.utils.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TaskExpertTaskResultsCustomMapper {
    /**
     * 获取总记录数专家评价结果表
     * @param  taskexperttaskresults
     * @return
     */
    Long countTaskExpertTaskResultsPageInfo(@Param("value") TaskExpertTaskResultsData taskexperttaskresults);
    /**
     * 获取分页专家评价结果表
     * @param  taskexperttaskresults
     * @return
     */
    List<TaskExpertTaskResultsData> queryTaskExpertTaskResultsPageInfo(@Param("page") PageInfo page,@Param("value") TaskExpertTaskResultsData taskexperttaskresults);

    /**
     * 根据id获取专家评价结果表信息
     * @param pkid
     * @return
     */
    TaskExpertTaskResultsData selectByPrimaryKey(Long pkid);
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
    int batchUpdateValues(@Param("values")List<TaskExpertTaskResultsData> values);
    /**
     * 批量修改
     * @param values
     * @param pkid
     * @return
     */
    int batchInsertValues(@Param("values")List<TaskExpertTaskResultsData> values,@Param("pkid")Long pkid);
    /**
     * 添加记录
     * @param value
     * @return
     */
    int insert(TaskExpertTaskResultsData value);

    /**
     * 修改记录
     * @param value
     * @return
     */
    int updateByPrimaryKey(TaskExpertTaskResultsData value);

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
