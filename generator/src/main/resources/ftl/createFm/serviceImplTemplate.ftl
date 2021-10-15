package  com.qhzk.pe.service.impl.${objectNameLower}.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qhzk.pe.data.${objectName}Data;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.${objectName}Service;
import com.qhzk.pe.mapper.custom.${objectName}CustomMapper;

/**
 * ${title} Service实现类，${title} Service实现类
 * @author: Mr.Muxl
 * @date ${nowDate?string("yyyy-MM-dd")}
 */

@Service
public class ${objectName}ServiceImpl implements ${objectName}Service{
	@Resource
	private ${objectName}CustomMapper ${mapping}custommapper;

	@Override
	public boolean add${objectName}(${objectName}Data ${mapping}data) {
		${mapping}data.setIsdelete("N");
		int count = ${mapping}custommapper.insert(${mapping}data);
		if(count>0){
			return true;
    	}
    	return false;
	}

	@Override
	public boolean del${objectName}ById(long id) {
		${objectName}Data ${mapping}data = ${mapping}custommapper.selectByPrimaryKey(id);
    	if(null !=${mapping}data){
    		int count = ${mapping}custommapper.deleteLogicByPrimaryKey(id);
			if(count>0){
				return true;
			}
			return false;
	    }
    	return false;
	}

	@Override
	public boolean update${objectName}(${objectName}Data ${mapping}data) {
		int count = ${mapping}custommapper.updateByPrimaryKey(${mapping}data);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public  ${objectName}Data get${objectName}ById(long id) {
		return ${mapping}custommapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<${objectName}Data> queryPageInfo(PageInfo page, ${objectName}Data ${mapping}data) {
    	Long count = ${mapping}custommapper.count${objectName}PageInfo(${mapping}data);
    	page.setTotalCount(count.intValue());
    	List<${objectName}Data> ${mapping}s = ${mapping}custommapper.query${objectName}PageInfo(page,${mapping}data);
        page.setDates(${mapping}s);
        return page;
    }

    @Override
    public List<${objectName}Data> getAll${objectName}s(${objectName}Data ${mapping}data) {
         List<${objectName}Data> ${mapping}s = ${mapping}custommapper.query${objectName}PageInfo(null,${mapping}data);
         return  ${mapping}s;
    }
	@Override
	public int batchDeleteInfo(List<String> infos) {
		return ${mapping}custommapper.batchLogicDeleteInfo(infos);
	}
}
