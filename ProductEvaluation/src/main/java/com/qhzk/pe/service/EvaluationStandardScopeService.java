package com.qhzk.pe.service;

import java.util.List;

import com.qhzk.pe.data.EvaluationStandardScopeData;
import com.qhzk.pe.utils.PageInfo;

/**
 * 评价标准适用范围 接口，评价标准适用范围接口
 * @author: Mr.Muxl
 * @date 2021-07-20
 */
public interface EvaluationStandardScopeService {

	/**新增
	 * @param evaluationstandardscope
	 * @throws Exception
	 */
	public boolean addEvaluationStandardScope (EvaluationStandardScopeData evaluationstandardscope);

	/**删除
	 * @param id
	 * @throws Exception
	 */
	public boolean delEvaluationStandardScopeById (long id);

	/**修改
	 * @param evaluationstandardscope
	 * @throws Exception
	 */
	public boolean updateEvaluationStandardScope (EvaluationStandardScopeData evaluationstandardscope);

	/**通过id获取数据
	 * @param id
	 * @throws Exception
	 */
	public EvaluationStandardScopeData getEvaluationStandardScopeById (long id);

	/**分页列表
	 * @param evaluationstandardscope
	 * @param page
	 * @throws Exception
	 */
	public PageInfo<EvaluationStandardScopeData> queryPageInfo(PageInfo page, EvaluationStandardScopeData evaluationstandardscope);

	/**列表
	 * @param evaluationstandardscope
	 * @throws Exception
	 */
	public List<EvaluationStandardScopeData> getAllEvaluationStandardScopes(EvaluationStandardScopeData evaluationstandardscope);

	/**批量删除
	 * @param infos
	 * @throws Exception
	 */
	public int batchDeleteInfo(List<String> infos);
}
