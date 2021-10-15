package com.qhzk.pe.service;

import java.util.List;

import com.qhzk.pe.data.ExpertData;
import com.qhzk.pe.utils.PageInfo;


/**
 * 专家表 接口，专家表接口
 * @author: Mr.Muxl
 * @date 2021-07-20
 */
public interface ExpertService {

	/**新增
	 * @param expert
	 * @throws Exception
	 */
	public boolean addExpert (ExpertData expert);

	/**删除
	 * @param id
	 * @throws Exception
	 */
	public boolean delExpertById (long id);

	/**修改
	 * @param expert
	 * @throws Exception
	 */
	public boolean updateExpert (ExpertData expert);

	/**通过id获取数据
	 * @param id
	 * @throws Exception
	 */
	public ExpertData getExpertById (long id);

	/**分页列表
	 * @param expert
	 * @param page
	 * @throws Exception
	 */
	public PageInfo<ExpertData> queryPageInfo(PageInfo page, ExpertData expert);

	/**列表
	 * @param expert
	 * @throws Exception
	 */
	public List<ExpertData> getAllExperts(ExpertData expert);

	/**批量删除
	 * @param infos
	 * @throws Exception
	 */
	public int batchDeleteInfo(List<String> infos);
}
