package com.qhzk.pe.service;

import java.util.List;

import com.qhzk.pe.data.TaskExpertTaskData;
import com.qhzk.pe.utils.PageInfo;

/**
 * 专家评价任务 接口，专家评价任务接口
 * @author: Mr.Muxl
 * @date 2021-07-20
 */
public interface TaskExpertTaskService {

	/**新增
	 * @param taskexperttask
	 * @throws Exception
	 */
	public boolean addTaskExpertTask (TaskExpertTaskData taskexperttask);

	/**删除
	 * @param id
	 * @throws Exception
	 */
	public boolean delTaskExpertTaskById (long id);

	/**修改
	 * @param taskexperttask
	 * @throws Exception
	 */
	public boolean updateTaskExpertTask (TaskExpertTaskData taskexperttask);

	/**通过id获取数据
	 * @param id
	 * @throws Exception
	 */
	public TaskExpertTaskData getTaskExpertTaskById (long id);

	/**分页列表
	 * @param taskexperttask
	 * @param page
	 * @throws Exception
	 */
	public PageInfo<TaskExpertTaskData> queryPageInfo(PageInfo page, TaskExpertTaskData taskexperttask);

	/**列表
	 * @param taskexperttask
	 * @throws Exception
	 */
	public List<TaskExpertTaskData> getAllTaskExpertTasks(TaskExpertTaskData taskexperttask);

	/**批量删除
	 * @param infos
	 * @throws Exception
	 */
	public int batchDeleteInfo(List<String> infos);
}
