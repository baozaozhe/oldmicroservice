package com.qhzk.pe.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.qhzk.pe.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;

import com.qhzk.pe.data.DictionaryData;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.DictionaryService;
import com.qhzk.pe.mapper.DictionaryCustomMapper;

/**
 * 字典管理 Service实现类，字典管理 Service实现类
 * @author: Mr.Muxl
 * @date 2021-06-29
 */

@Service
public class DictionaryServiceImpl implements DictionaryService{
	@Resource
	private DictionaryCustomMapper dictionarycustommapper;

	@Override
	public boolean addDictionary(DictionaryData dictionarydata) {
		dictionarydata.setPkid(SnowflakeIdWorker.generateId());
        dictionarydata.setIsdelete("N");
        int count = dictionarycustommapper.insert(dictionarydata);
        if(count>0){
            return true;
        }
        return false;
	}

	@Override
	public boolean delDictionaryById(long id) {
		DictionaryData dictionarydata = dictionarycustommapper.selectByPrimaryKey(id);
    	if(null !=dictionarydata){
    		int count = dictionarycustommapper.deleteLogicByPrimaryKey(id);
			if(count>0){
				return true;
			}
			return false;
	    }
    	return false;
	}

	@Override
	public boolean updateDictionary(DictionaryData dictionarydata) {
        int count = dictionarycustommapper.updateByPrimaryKey(dictionarydata);
        if(count>0){
            return true;
        }
        return false;
	}

	@Override
	public  DictionaryData getDictionaryById(long id) {
		return dictionarycustommapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<DictionaryData> queryPageInfo(PageInfo page, DictionaryData dictionarydata) {
    	Long count = dictionarycustommapper.countDictionaryPageInfo(dictionarydata);
    	page.setTotalCount(count.intValue());
    	List<DictionaryData> dictionarys = dictionarycustommapper.queryDictionaryPageInfo(page,dictionarydata);
        page.setDates(dictionarys);
        return page;
    }

    @Override
    public List<DictionaryData> getAllDictionarys(DictionaryData dictionarydata) {
         List<DictionaryData> dictionarys = dictionarycustommapper.queryDictionaryPageInfo(null,dictionarydata);
         return  dictionarys;
    }
    @Override
    public int batchDeleteInfo(List<String> infos) {
        return dictionarycustommapper.batchLogicDeleteInfo(infos);
    }

	@Override
	public List<DictionaryData> getEvaluatScopes(List<String> pcodes) {
		return dictionarycustommapper.getEvaluatScopes(pcodes);
	}

}
