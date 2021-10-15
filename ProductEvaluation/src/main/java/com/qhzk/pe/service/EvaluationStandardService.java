package com.qhzk.pe.service;

import java.util.List;

import com.qhzk.pe.data.EvaluationStandardData;
import com.qhzk.pe.utils.PageInfo;

/**
 * 评价标准 接口，评价标准接口
 * @author: Mr.Muxl
 * @date 2021-06-29
 */
public interface EvaluationStandardService {

	/**新增
	 * @param evaluationstandard
	 * @throws Exception
	 */
	public boolean addEvaluationStandard(EvaluationStandardData evaluationstandard);

	/**删除
	 * @param id
	 * @throws Exception
	 */
	public boolean delEvaluationStandardById(long id);

	/**修改
	 * @param evaluationstandard
	 * @throws Exception
	 */
	public boolean updateEvaluationStandard(EvaluationStandardData evaluationstandard);

	/**通过id获取数据
	 * @param id
	 * @throws Exception
	 */
	public EvaluationStandardData getEvaluationStandardById(long id);

	/**分页列表
	 * @param evaluationstandard
	 * @param page
	 * @throws Exception
	 */
	public PageInfo<EvaluationStandardData> queryPageInfo(PageInfo page, EvaluationStandardData evaluationstandard);

    /**列表
    * @param evaluationstandard
    * @throws Exception
    */
    public List<EvaluationStandardData> getAllEvaluationStandards(EvaluationStandardData evaluationstandard);

	/**批量删除
	 * @param infos
	 * @throws Exception
	 */
	public int batchDeleteInfo(List<String> infos);
	/**
	 * 列表
	 * @param mean scope
	 * @throws Exception
	 */
	public List<EvaluationStandardData> getEvalstandardByMeanAndScope( String mean,String scope);
}
