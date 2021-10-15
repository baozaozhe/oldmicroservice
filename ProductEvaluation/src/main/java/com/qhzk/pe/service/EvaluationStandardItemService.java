package com.qhzk.pe.service;

import java.util.List;

import com.qhzk.pe.data.EvaluationStandardItemData;
import com.qhzk.pe.utils.PageInfo;

/**
 * 评价标准明细 接口，评价标准明细接口
 * @author: Mr.Muxl
 * @date 2021-07-20
 */
public interface EvaluationStandardItemService {

	/**新增
	 * @param evaluationstandarditem
	 * @throws Exception
	 */
	public boolean addEvaluationStandardItem (EvaluationStandardItemData evaluationstandarditem);

	/**删除
	 * @param id
	 * @throws Exception
	 */
	public boolean delEvaluationStandardItemById (long id);

	/**修改
	 * @param evaluationstandarditem
	 * @throws Exception
	 */
	public boolean updateEvaluationStandardItem (EvaluationStandardItemData evaluationstandarditem);

	/**通过id获取数据
	 * @param id
	 * @throws Exception
	 */
	public EvaluationStandardItemData getEvaluationStandardItemById (long id);

	/**分页列表
	 * @param evaluationstandarditem
	 * @param page
	 * @throws Exception
	 */
	public PageInfo<EvaluationStandardItemData> queryPageInfo(PageInfo page, EvaluationStandardItemData evaluationstandarditem);

	/**列表
	 * @param evaluationstandarditem
	 * @throws Exception
	 */
	public List<EvaluationStandardItemData> getAllEvaluationStandardItems(EvaluationStandardItemData evaluationstandarditem);

	/**批量删除
	 * @param infos
	 * @throws Exception
	 */
	public int batchDeleteInfo(List<String> infos);
}
