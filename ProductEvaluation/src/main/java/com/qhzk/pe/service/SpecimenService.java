package com.qhzk.pe.service;

import java.util.List;

import com.qhzk.pe.data.SpecimenData;
import com.qhzk.pe.utils.PageInfo;

/**
 * 样品管理 接口，样品管理接口
 * @author: Mr.Muxl
 * @date 2021-06-23
 */
public interface SpecimenService {

	/**新增
	 * @param specimen
	 * @throws Exception
	 */
	public boolean addSpecimen(SpecimenData specimen);

	/**删除
	 * @param id
	 * @throws Exception
	 */
	public boolean delSpecimenById(long id);

	/**修改
	 * @param specimen
	 * @throws Exception
	 */
	public boolean updateSpecimen(SpecimenData specimen);

	/**通过id获取数据
	 * @param id
	 * @throws Exception
	 */
	public SpecimenData getSpecimenById(long id);
	/**分页列表
	 * @param specimen
	 * @param page
	 * @throws Exception
	 */
	public PageInfo<SpecimenData> queryPageInfo(PageInfo page, SpecimenData specimen);

	/**列表
	 * @param specimen
	 * @throws Exception
	 */
	public List<SpecimenData> getAllSpecimes(SpecimenData specimen);

	/**批量删除
	 * @param infos
	 * @throws Exception
	 */
	public int batchDeleteInfo(List<String> infos);

}
