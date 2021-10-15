package com.qhzk.pe.service;

import java.util.List;

import com.qhzk.pe.data.DictionaryData;
import com.qhzk.pe.utils.PageInfo;

/**
 * 字典管理 接口，字典管理接口
 * @author: Mr.Muxl
 * @date 2021-06-29
 */
public interface DictionaryService {

	/**新增
	 * @param dictionary
	 * @throws Exception
	 */
	public boolean addDictionary(DictionaryData dictionary);

	/**删除
	 * @param id
	 * @throws Exception
	 */
	public boolean delDictionaryById(long id);

	/**修改
	 * @param dictionary
	 * @throws Exception
	 */
	public boolean updateDictionary(DictionaryData dictionary);

	/**通过id获取数据
	 * @param id
	 * @throws Exception
	 */
	public DictionaryData getDictionaryById(long id);


	/**分页列表
	 * @param dictionary
	 * @param page
	 * @throws Exception
	 */
	public PageInfo<DictionaryData> queryPageInfo(PageInfo page, DictionaryData dictionary);

    /**列表
    * @param dictionary
    * @throws Exception
    */
    public List<DictionaryData> getAllDictionarys(DictionaryData dictionary);
	/**批量删除
	 * @param infos
	 * @throws Exception
	 */
	public int batchDeleteInfo(List<String> infos);

	/**
	 * 获取评价标准适用范围
	 * @param pcodes
	 * @return
	 */
	public List<DictionaryData> getEvaluatScopes( List<String> pcodes);
}
