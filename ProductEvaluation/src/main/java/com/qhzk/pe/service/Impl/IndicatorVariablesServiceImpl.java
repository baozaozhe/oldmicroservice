package com.qhzk.pe.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.qhzk.pe.data.IndicatorVariablesValuesData;
import com.qhzk.pe.mapper.IndicatorVariablesValuesCustomMapper;
import com.qhzk.pe.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;

import com.qhzk.pe.data.IndicatorVariablesData;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.IndicatorVariablesService;
import com.qhzk.pe.mapper.IndicatorVariablesCustomMapper;

/**
 * 评价指标项 Service实现类，评价指标项 Service实现类
 * @author: Mr.Muxl
 * @date 2021-06-29
 */

@Service
public class IndicatorVariablesServiceImpl implements IndicatorVariablesService{
	@Resource
	private IndicatorVariablesCustomMapper indicatorvariablescustommapper;
	@Resource
	private IndicatorVariablesValuesCustomMapper indicatorvariablesvaluescustommapper;

	@Override
	public boolean addIndicatorVariables(IndicatorVariablesData indicatorvariablesdata) {
		indicatorvariablesdata.setPkid(SnowflakeIdWorker.generateId());
		indicatorvariablesdata.setIsdelete("N");
		int count = indicatorvariablescustommapper.insert(indicatorvariablesdata);
		if(count>0){
			List<IndicatorVariablesValuesData> values = indicatorvariablesdata.getValues().stream().map(p -> {
				p.setPkid(SnowflakeIdWorker.generateId());
				p.setItemid(indicatorvariablesdata.getPkid());
				return p;
			}).collect(Collectors.toList());

			if(null !=values && !values.isEmpty()){
				int i = indicatorvariablesvaluescustommapper.batchInsertValues(values);
				return true;
			}
    	}
    	return false;
	}

	@Override
	public boolean delIndicatorVariablesById(long id) {
		IndicatorVariablesData indicatorvariablesdata = indicatorvariablescustommapper.selectByPrimaryKey(id);
    	if(null !=indicatorvariablesdata){
    		int count = indicatorvariablescustommapper.deleteIndicatorVariablesByPrimaryKey(id);
			if(count>0){
				return true;
			}
			return false;
	    }
    	return false;
	}

	@Override
	public boolean updateIndicatorVariables(IndicatorVariablesData indicatorvariablesdata) {
		int count = indicatorvariablescustommapper.updateByPrimaryKey(indicatorvariablesdata);
		if(count>0){
			List<IndicatorVariablesValuesData> values = indicatorvariablesdata.getValues();
			if(null !=values && !values.isEmpty()){
				int i = indicatorvariablesvaluescustommapper.batchUpdateValues(values);
				if(i>0){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public  IndicatorVariablesData getIndicatorVariablesById(long id) {
		return indicatorvariablescustommapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<IndicatorVariablesData> queryPageInfo(PageInfo page, IndicatorVariablesData indicatorvariablesdata) {
    	Long count = indicatorvariablescustommapper.countIndicatorVariablesPageInfo(indicatorvariablesdata);
    	page.setTotalCount(count.intValue());
    	List<IndicatorVariablesData> indicatorvariabless = indicatorvariablescustommapper.queryIndicatorVariablesPageInfo(page,indicatorvariablesdata);
        page.setDates(indicatorvariabless);
        return page;
    }

    @Override
    public List<IndicatorVariablesData> getAllIndicatorVariabless(IndicatorVariablesData indicatorvariablesdata) {
         List<IndicatorVariablesData> indicatorvariabless = indicatorvariablescustommapper.queryIndicatorVariablesPageInfo(null,indicatorvariablesdata);
         return  indicatorvariabless;
    }
	@Override
	public int batchDeleteInfo(List<String> infos) {
		return indicatorvariablescustommapper.batchLogicDeleteInfo(infos);
	}
}
