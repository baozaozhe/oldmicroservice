package com.qhzk.pe.service;

import java.util.List;

import com.qhzk.pe.data.EvaluationStandardMethodologyData;
import com.qhzk.pe.utils.PageInfo;

/**
 * 评价标准适用评价方法 接口，评价标准适用评价方法接口
 * @author: Mr.Muxl
 * @date 2021-07-20
 */
public interface EvaluationStandardMethodologyService {

	/**新增
	 * @param evaluationstandardmethodology
	 * @throws Exception
	 */
	public boolean addEvaluationStandardMethodology (EvaluationStandardMethodologyData evaluationstandardmethodology);

	/**删除
	 * @param id
	 * @throws Exception
	 */
	public boolean delEvaluationStandardMethodologyById (long id);

	/**修改
	 * @param evaluationstandardmethodology
	 * @throws Exception
	 */
	public boolean updateEvaluationStandardMethodology (EvaluationStandardMethodologyData evaluationstandardmethodology);

	/**通过id获取数据
	 * @param id
	 * @throws Exception
	 */
	public EvaluationStandardMethodologyData getEvaluationStandardMethodologyById (long id);

	/**分页列表
	 * @param evaluationstandardmethodology
	 * @param page
	 * @throws Exception
	 */
	public PageInfo<EvaluationStandardMethodologyData> queryPageInfo(PageInfo page, EvaluationStandardMethodologyData evaluationstandardmethodology);

	/**列表
	 * @param evaluationstandardmethodology
	 * @throws Exception
	 */
	public List<EvaluationStandardMethodologyData> getAllEvaluationStandardMethodologys(EvaluationStandardMethodologyData evaluationstandardmethodology);

	/**批量删除
	 * @param infos
	 * @throws Exception
	 */
	public int batchDeleteInfo(List<String> infos);
}
