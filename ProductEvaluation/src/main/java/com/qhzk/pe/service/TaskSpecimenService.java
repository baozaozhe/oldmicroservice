package com.qhzk.pe.service;

import java.util.List;

import com.qhzk.pe.data.TaskSpecimenData;
import com.qhzk.pe.utils.PageInfo;

/**
 * 评价标准明细 接口，评价标准明细接口
 * @author: Mr.Muxl
 * @date 2021-06-30
 */
public interface TaskSpecimenService {

	/**新增
	 * @param taskspecimen
	 * @throws Exception
	 */
	public boolean addTaskSpecimen(TaskSpecimenData taskspecimen);

	/**删除
	 * @param id
	 * @throws Exception
	 */
	public boolean delTaskSpecimenById(long id);

	/**修改
	 * @param taskspecimen
	 * @throws Exception
	 */
	public boolean updateTaskSpecimen(TaskSpecimenData taskspecimen);

	/**通过id获取数据
	 * @param id
	 * @throws Exception
	 */
	public TaskSpecimenData getTaskSpecimenById(long id);

	/**分页列表
	 * @param taskspecimen
	 * @param page
	 * @throws Exception
	 */
	public PageInfo<TaskSpecimenData> queryPageInfo(PageInfo page, TaskSpecimenData taskspecimen);

    /**列表
    * @param taskspecimen
    * @throws Exception
    */
    public List<TaskSpecimenData> getAllTaskSpecimens(TaskSpecimenData taskspecimen);
	/**批量删除
	 * @param infos
	 * @throws Exception
	 */
	public int batchDeleteInfo(List<String> infos);
}
