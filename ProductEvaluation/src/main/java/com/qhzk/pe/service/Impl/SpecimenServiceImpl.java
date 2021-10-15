package com.qhzk.pe.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.qhzk.pe.data.SpecimenAttrsData;
import com.qhzk.pe.data.SpecimenData;
import com.qhzk.pe.mapper.SpecimenCustomMapper;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;

import com.qhzk.pe.service.SpecimenService;

/**
 * 样品管理 Service实现类，样品管理 Service实现类
 * @author: Mr.Muxl
 * @date 2021-06-23
 */

@Service
public class SpecimenServiceImpl implements SpecimenService{
	@Resource
	private SpecimenCustomMapper specimencustommapper;
	@Override
	public boolean addSpecimen(SpecimenData specimendata) {
		specimendata.setPkid(SnowflakeIdWorker.generateId());
		specimendata.setIsdelete("N");
		int count = specimencustommapper.insert(specimendata);
		if(count>0){
			if(!specimendata.getAttrsdatas().isEmpty() && specimendata.getAttrsdatas().size()>0){
				//修改每个项的属性扩展值
				List<SpecimenAttrsData> attrsdatas = specimendata.getAttrsdatas().stream().map(p -> {
					p.setPkid(SnowflakeIdWorker.generateId());
					p.setSpeid(specimendata.getPkid());
					return p;
				}).collect(Collectors.toList());
				int i = specimencustommapper.batchInsertSpeattrs(attrsdatas);
				return true;
			}else{
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delSpecimenById(long id) {
		SpecimenData specimenData = specimencustommapper.selectByPrimaryKey(id);
		List<SpecimenAttrsData> specimenAttrsDatas = specimencustommapper.querySpecimenAttrs(id);
		if(null !=specimenData){
			int count = specimencustommapper.deleteSpecimenByPrimaryKey(id);
			if(count>0){
				if("fs".equals(specimenData.getSpetype())){
					if(specimenAttrsDatas.isEmpty()|| specimenAttrsDatas.size()<=0){
						return  true;
					}
					int i = specimencustommapper.deleteSpeattrsBySpeid(id);
					if(i>0){
						return  true;
					}
				}else {
					return  true;
				}
			}

		}

		return false;
	}

	@Override
	public boolean updateSpecimen(SpecimenData specimendata) {
		int count = specimencustommapper.updateByPrimaryKey(specimendata);
		if(count>0){
			if(null != specimendata.getAttrsdatas() && !specimendata.getAttrsdatas().isEmpty()){
				//修改每个项的属性扩展值
				List<SpecimenAttrsData> attrsdatas = specimendata.getAttrsdatas();
				List<SpecimenAttrsData> updateattr= new ArrayList<>();
				List<SpecimenAttrsData> insertattr= new ArrayList<>();
				for(SpecimenAttrsData s : attrsdatas){
					if(null == s.getPkid()){
						s.setPkid(SnowflakeIdWorker.generateId());
						insertattr.add(s);
					}else {
						updateattr.add(s);
					}
				}
				if(null != updateattr && !updateattr.isEmpty()){
					int i = specimencustommapper.batchUpdateSpeattrs(updateattr);
				}
				if(null != insertattr && !insertattr.isEmpty()){
					int i = specimencustommapper.batchInsertSpeattrs(insertattr);
				}
				return true;
			}else{
				return true;
			}
		}
		return false;
	}

	@Override
	public SpecimenData getSpecimenById(long id) {
		return specimencustommapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<SpecimenData> queryPageInfo(PageInfo page, SpecimenData specimen) {
		Long count = specimencustommapper.countSpecimenPageInfo(specimen);
		page.setTotalCount(count.intValue());
		List<SpecimenData> specimens = specimencustommapper.querySpecimenPageInfo(page,specimen);
		page.setDates(specimens);
		return page;
    }

	@Override
	public List<SpecimenData> getAllSpecimes(SpecimenData specimen) {
		List<SpecimenData> specimens = specimencustommapper.querySpecimenPageInfo(null,specimen);
		return  specimens;
	}

	@Override
	public int batchDeleteInfo(List<String> infos) {
		return specimencustommapper.batchLogicDeleteInfo(infos);
	}

}
