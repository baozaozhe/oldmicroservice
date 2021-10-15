package com.qhzk.pe.service.${objectNameLower};

import java.util.List;

import com.qhzk.pe.data.${objectName}Data;
import com.qhzk.pe.utils.PageInfo;

/**
 * ${title} 接口，${title}接口
 * @author: Mr.Muxl
 * @date ${nowDate?string("yyyy-MM-dd")}
 */
public interface ${objectName}Service {

	/**新增
	 * @param ${mapping}
	 * @throws Exception
	 */
	public boolean add${objectName} (${objectName}Data ${mapping});

	/**删除
	 * @param id
	 * @throws Exception
	 */
	public boolean del${objectName}ById (long id);

	/**修改
	 * @param ${mapping}
	 * @throws Exception
	 */
	public boolean update${objectName} (${objectName}Data ${mapping});

	/**通过id获取数据
	 * @param id
	 * @throws Exception
	 */
	public ${objectName}Data get${objectName}ById (long id);

	/**分页列表
	 * @param ${mapping}
	 * @param page
	 * @throws Exception
	 */
	public PageInfo<${objectName}Data> queryPageInfo(PageInfo page, ${objectName}Data ${mapping});

    /**列表
    * @param ${mapping}
    * @throws Exception
    */
    public List<${objectName}Data> getAll${objectName}s(${objectName}Data ${mapping});

	/**批量删除
	* @param infos
	* @throws Exception
	*/
	public int batchDeleteInfo(List<String> infos);
}
