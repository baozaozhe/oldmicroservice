package com.qhzk.pe.service;

import java.util.List;

import com.qhzk.pe.data.TaskExpertTaskResultsData;
import com.qhzk.pe.utils.PageInfo;

/**
 * 专家评价结果表 接口，专家评价结果表接口
 * @author: Mr.Muxl
 * @date 2021-07-20
 */
public interface TaskExpertTaskResultsService {

	/**新增
	 * @param taskexperttaskresults
	 * @throws Exception
	 */
	public boolean addTaskExpertTaskResults (TaskExpertTaskResultsData taskexperttaskresults);

	/**删除
	 * @param id
	 * @throws Exception
	 */
	public boolean delTaskExpertTaskResultsById (long id);

	/**修改
	 * @param taskexperttaskresults
	 * @throws Exception
	 */
	public boolean updateTaskExpertTaskResults (TaskExpertTaskResultsData taskexperttaskresults);

	/**通过id获取数据
	 * @param id
	 * @throws Exception
	 */
	public TaskExpertTaskResultsData getTaskExpertTaskResultsById (long id);

	/**分页列表
	 * @param taskexperttaskresults
	 * @param page
	 * @throws Exception
	 */
	public PageInfo<TaskExpertTaskResultsData> queryPageInfo(PageInfo page, TaskExpertTaskResultsData taskexperttaskresults);

	/**列表
	 * @param taskexperttaskresults
	 * @throws Exception
	 */
	public List<TaskExpertTaskResultsData> getAllTaskExpertTaskResultss(TaskExpertTaskResultsData taskexperttaskresults);

	/**批量删除
	 * @param infos
	 * @throws Exception
	 */
	public int batchDeleteInfo(List<String> infos);
}
