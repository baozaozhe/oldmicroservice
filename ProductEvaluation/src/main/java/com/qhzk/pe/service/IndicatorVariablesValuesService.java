package com.qhzk.pe.service;

import java.util.List;

import com.qhzk.pe.data.IndicatorVariablesValuesData;
import com.qhzk.pe.utils.PageInfo;

/**
 * 评价指标项值 接口，评价指标项值接口
 * @author: Mr.Muxl
 * @date 2021-07-20
 */
public interface IndicatorVariablesValuesService {

	/**新增
	 * @param indicatorvariablesvalues
	 * @throws Exception
	 */
	public boolean addIndicatorVariablesValues (IndicatorVariablesValuesData indicatorvariablesvalues);

	/**删除
	 * @param id
	 * @throws Exception
	 */
	public boolean delIndicatorVariablesValuesById (long id);

	/**修改
	 * @param indicatorvariablesvalues
	 * @throws Exception
	 */
	public boolean updateIndicatorVariablesValues (IndicatorVariablesValuesData indicatorvariablesvalues);

	/**通过id获取数据
	 * @param id
	 * @throws Exception
	 */
	public IndicatorVariablesValuesData getIndicatorVariablesValuesById (long id);

	/**分页列表
	 * @param indicatorvariablesvalues
	 * @param page
	 * @throws Exception
	 */
	public PageInfo<IndicatorVariablesValuesData> queryPageInfo(PageInfo page, IndicatorVariablesValuesData indicatorvariablesvalues);

	/**列表
	 * @param indicatorvariablesvalues
	 * @throws Exception
	 */
	public List<IndicatorVariablesValuesData> getAllIndicatorVariablesValuess(IndicatorVariablesValuesData indicatorvariablesvalues);

	/**批量删除
	 * @param infos
	 * @throws Exception
	 */
	public int batchDeleteInfo(List<String> infos);
}
