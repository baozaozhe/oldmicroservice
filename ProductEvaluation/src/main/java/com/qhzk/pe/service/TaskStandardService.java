package com.qhzk.pe.service;

import java.util.List;

import com.qhzk.pe.data.TaskStandardData;
import com.qhzk.pe.utils.PageInfo;

/**
 * 评价任务使用标准 接口，评价任务使用标准接口
 * @author: Mr.Muxl
 * @date 2021-06-30
 */
public interface TaskStandardService {

	/**新增
	 * @param taskstandard
	 * @throws Exception
	 */
	public boolean addTaskStandard(TaskStandardData taskstandard);

	/**删除
	 * @param id
	 * @throws Exception
	 */
	public boolean delTaskStandardById(long id);

	/**修改
	 * @param taskstandard
	 * @throws Exception
	 */
	public boolean updateTaskStandard(TaskStandardData taskstandard);

	/**通过id获取数据
	 * @param id
	 * @throws Exception
	 */
	public TaskStandardData getTaskStandardById(long id);


	/**分页列表
	 * @param taskstandard
	 * @param page
	 * @throws Exception
	 */
	public PageInfo<TaskStandardData> queryPageInfo(PageInfo page, TaskStandardData taskstandard);

    /**列表
    * @param taskstandard
    * @throws Exception
    */
    public List<TaskStandardData> getAllTaskStandards(TaskStandardData taskstandard);

}
