package com.qhzk.pe.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.qhzk.pe.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;

import com.qhzk.pe.data.AttributesData;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.AttributesService;
import com.qhzk.pe.mapper.AttributesCustomMapper;

/**
 * 扩展属性 Service实现类，扩展属性 Service实现类
 * @author: Mr.Muxl
 * @date 2021-07-19
 */

@Service
public class AttributesServiceImpl implements AttributesService{
	@Resource
	private AttributesCustomMapper attributescustommapper;

	@Override
	public boolean addAttributes(AttributesData attributesdata) {
		attributesdata.setPkid(SnowflakeIdWorker.generateId());
		attributesdata.setIsdelete("N");
		int count = attributescustommapper.insert(attributesdata);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delAttributesById(long id) {
		AttributesData attributesdata = attributescustommapper.selectByPrimaryKey(id);
		if(null !=attributesdata){
			int count = attributescustommapper.deleteRealByPrimaryKey(id);
			if(count>0){
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean updateAttributes(AttributesData attributesdata) {
		int count = attributescustommapper.updateByPrimaryKey(attributesdata);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public  AttributesData getAttributesById(long id) {
		return attributescustommapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<AttributesData> queryPageInfo(PageInfo page, AttributesData attributesdata) {
		Long count = attributescustommapper.countAttributesPageInfo(attributesdata);
		page.setTotalCount(count.intValue());
		List<AttributesData> attributess = attributescustommapper.queryAttributesPageInfo(page,attributesdata);
		page.setDates(attributess);
		return page;
	}

	@Override
	public List<AttributesData> getAllAttributess(AttributesData attributesdata) {
		List<AttributesData> attributess = attributescustommapper.queryAttributesPageInfo(null,attributesdata);
		return  attributess;
	}
	@Override
	public int batchDeleteInfo(List<String> infos) {
		return attributescustommapper.batchLogicDeleteInfo(infos);
	}
}
