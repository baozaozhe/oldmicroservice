package com.qhzk.pe.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.qhzk.pe.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;

import com.qhzk.pe.data.IndicatorVariablesValuesData;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.IndicatorVariablesValuesService;
import com.qhzk.pe.mapper.IndicatorVariablesValuesCustomMapper;

/**
 * 评价指标项值 Service实现类，评价指标项值 Service实现类
 * @author: Mr.Muxl
 * @date 2021-07-20
 */

@Service
public class IndicatorVariablesValuesServiceImpl implements IndicatorVariablesValuesService{
	@Resource
	private IndicatorVariablesValuesCustomMapper indicatorvariablesvaluescustommapper;

	@Override
	public boolean addIndicatorVariablesValues(IndicatorVariablesValuesData indicatorvariablesvaluesdata) {
		indicatorvariablesvaluesdata.setPkid(SnowflakeIdWorker.generateId());
		indicatorvariablesvaluesdata.setIsdelete("N");
		int count = indicatorvariablesvaluescustommapper.insert(indicatorvariablesvaluesdata);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delIndicatorVariablesValuesById(long id) {
		IndicatorVariablesValuesData indicatorvariablesvaluesdata = indicatorvariablesvaluescustommapper.selectByPrimaryKey(id);
		if(null !=indicatorvariablesvaluesdata){
			int count = indicatorvariablesvaluescustommapper.deleteLogicByPrimaryKey(id);
			if(count>0){
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean updateIndicatorVariablesValues(IndicatorVariablesValuesData indicatorvariablesvaluesdata) {
		int count = indicatorvariablesvaluescustommapper.updateByPrimaryKey(indicatorvariablesvaluesdata);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public  IndicatorVariablesValuesData getIndicatorVariablesValuesById(long id) {
		return indicatorvariablesvaluescustommapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<IndicatorVariablesValuesData> queryPageInfo(PageInfo page, IndicatorVariablesValuesData indicatorvariablesvaluesdata) {
		Long count = indicatorvariablesvaluescustommapper.countIndicatorVariablesValuesPageInfo(indicatorvariablesvaluesdata);
		page.setTotalCount(count.intValue());
		List<IndicatorVariablesValuesData> indicatorvariablesvaluess = indicatorvariablesvaluescustommapper.queryIndicatorVariablesValuesPageInfo(page,indicatorvariablesvaluesdata);
		page.setDates(indicatorvariablesvaluess);
		return page;
	}

	@Override
	public List<IndicatorVariablesValuesData> getAllIndicatorVariablesValuess(IndicatorVariablesValuesData indicatorvariablesvaluesdata) {
		List<IndicatorVariablesValuesData> indicatorvariablesvaluess = indicatorvariablesvaluescustommapper.queryIndicatorVariablesValuesPageInfo(null,indicatorvariablesvaluesdata);
		return  indicatorvariablesvaluess;
	}
	@Override
	public int batchDeleteInfo(List<String> infos) {
		return indicatorvariablesvaluescustommapper.batchLogicDeleteInfo(infos);
	}
}
