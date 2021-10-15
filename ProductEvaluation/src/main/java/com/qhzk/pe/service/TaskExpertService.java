package com.qhzk.pe.service;

import java.util.List;

import com.qhzk.pe.data.TaskExpertData;
import com.qhzk.pe.utils.PageInfo;

/**
 * 评价专家表 接口，评价专家表接口
 * @author: Mr.Muxl
 * @date 2021-07-20
 */
public interface TaskExpertService {

	/**新增
	 * @param taskexpert
	 * @throws Exception
	 */
	public boolean addTaskExpert (TaskExpertData taskexpert);

	/**删除
	 * @param id
	 * @throws Exception
	 */
	public boolean delTaskExpertById (long id);

	/**修改
	 * @param taskexpert
	 * @throws Exception
	 */
	public boolean updateTaskExpert (TaskExpertData taskexpert);

	/**通过id获取数据
	 * @param id
	 * @throws Exception
	 */
	public TaskExpertData getTaskExpertById (long id);

	/**分页列表
	 * @param taskexpert
	 * @param page
	 * @throws Exception
	 */
	public PageInfo<TaskExpertData> queryPageInfo(PageInfo page, TaskExpertData taskexpert);

	/**列表
	 * @param taskexpert
	 * @throws Exception
	 */
	public List<TaskExpertData> getAllTaskExperts(TaskExpertData taskexpert);

	/**批量删除
	 * @param infos
	 * @throws Exception
	 */
	public int batchDeleteInfo(List<String> infos);
}
