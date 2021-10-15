package com.qhzk.pe.service;

import java.util.List;

import com.qhzk.pe.data.TaskData;
import com.qhzk.pe.data.TaskExpertTaskData;
import com.qhzk.pe.utils.PageInfo;

/**
 * 评价任务 接口，评价任务接口
 * @author: Mr.Muxl
 * @date 2021-06-28
 */
public interface TaskService {

	/**新增
	 * @param task
	 * @throws Exception
	 */
	public boolean addTask(TaskData task);

	/**删除
	 * @param id
	 * @throws Exception
	 */
	public boolean delTaskById(long id);

	/**修改
	 * @param task
	 * @throws Exception
	 */
	public boolean updateTask(TaskData task);

	/**通过id获取数据
	 * @param id
	 * @throws Exception
	 */
	public TaskData getTaskById(long id);

	/**分页列表
	 * @param task
	 * @param page
	 * @throws Exception
	 */
	public PageInfo<TaskData> queryPageInfo(PageInfo page, TaskData task);

    /**列表
    * @param task
    * @throws Exception
    */
    public List<TaskData> getAllTasks(TaskData task);

	/**
	 * 发布任务
	 * @param id
	 * @throws Exception
	 */
	public boolean putPublishTask(long id);

	/**列表
	 * @param userid
	 * @throws Exception
	 */
	public List<TaskExpertTaskData> getCurrentUserTask(long userid, String status);
	/**终止任务
	 * @param id
	 * @throws Exception
	 */
	public boolean stopTask(long id);
	/**批量删除
	 * @param infos
	 * @throws Exception
	 */
	public int batchDeleteInfo(List<String> infos);

}
