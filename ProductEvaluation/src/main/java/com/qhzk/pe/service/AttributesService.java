package com.qhzk.pe.service;

import java.util.List;

import com.qhzk.pe.data.AttributesData;
import com.qhzk.pe.utils.PageInfo;

/**
 * 扩展属性 接口，扩展属性接口
 * @author: Mr.Muxl
 * @date 2021-07-19
 */
public interface AttributesService {

	/**新增
	 * @param attributes
	 * @throws Exception
	 */
	public boolean addAttributes (AttributesData attributes);

	/**删除
	 * @param id
	 * @throws Exception
	 */
	public boolean delAttributesById (long id);

	/**修改
	 * @param attributes
	 * @throws Exception
	 */
	public boolean updateAttributes (AttributesData attributes);

	/**通过id获取数据
	 * @param id
	 * @throws Exception
	 */
	public AttributesData getAttributesById (long id);

	/**分页列表
	 * @param attributes
	 * @param page
	 * @throws Exception
	 */
	public PageInfo<AttributesData> queryPageInfo(PageInfo page, AttributesData attributes);

	/**列表
	 * @param attributes
	 * @throws Exception
	 */
	public List<AttributesData> getAllAttributess(AttributesData attributes);

	/**批量删除
	 * @param infos
	 * @throws Exception
	 */
	public int batchDeleteInfo(List<String> infos);
}
