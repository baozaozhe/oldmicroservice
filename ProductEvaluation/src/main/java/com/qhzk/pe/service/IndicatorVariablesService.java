package com.qhzk.pe.service;

import java.util.List;

import com.qhzk.pe.data.IndicatorVariablesData;
import com.qhzk.pe.utils.PageInfo;

/**
 * 评价指标项 接口，评价指标项接口
 * @author: Mr.Muxl
 * @date 2021-06-29
 */
public interface IndicatorVariablesService {

	/**新增
	 * @param indicatorvariables
	 * @throws Exception
	 */
	public boolean addIndicatorVariables(IndicatorVariablesData indicatorvariables);

	/**删除
	 * @param id
	 * @throws Exception
	 */
	public boolean delIndicatorVariablesById(long id);

	/**修改
	 * @param indicatorvariables
	 * @throws Exception
	 */
	public boolean updateIndicatorVariables(IndicatorVariablesData indicatorvariables);

	/**通过id获取数据
	 * @param id
	 * @throws Exception
	 */
	public IndicatorVariablesData getIndicatorVariablesById(long id);
	/**分页列表
	 * @param indicatorvariables
	 * @param page
	 * @throws Exception
	 */
	public PageInfo<IndicatorVariablesData> queryPageInfo(PageInfo page, IndicatorVariablesData indicatorvariables);

    /**列表
    * @param indicatorvariables
    * @throws Exception
    */
    public List<IndicatorVariablesData> getAllIndicatorVariabless(IndicatorVariablesData indicatorvariables);
	/**批量删除
	 * @param infos
	 * @throws Exception
	 */
	public int batchDeleteInfo(List<String> infos);
}
