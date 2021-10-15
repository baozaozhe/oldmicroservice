package com.qhzk.pe.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.qhzk.pe.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;

import com.qhzk.pe.data.EvaluationStandardScopeData;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.EvaluationStandardScopeService;
import com.qhzk.pe.mapper.EvaluationStandardScopeCustomMapper;

/**
 * 评价标准适用范围 Service实现类，评价标准适用范围 Service实现类
 * @author: Mr.Muxl
 * @date 2021-07-20
 */

@Service
public class EvaluationStandardScopeServiceImpl implements EvaluationStandardScopeService{
	@Resource
	private EvaluationStandardScopeCustomMapper evaluationstandardscopecustommapper;

	@Override
	public boolean addEvaluationStandardScope(EvaluationStandardScopeData evaluationstandardscopedata) {
		evaluationstandardscopedata.setPkid(SnowflakeIdWorker.generateId());
		evaluationstandardscopedata.setIsdelete("N");
		int count = evaluationstandardscopecustommapper.insert(evaluationstandardscopedata);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delEvaluationStandardScopeById(long id) {
		EvaluationStandardScopeData evaluationstandardscopedata = evaluationstandardscopecustommapper.selectByPrimaryKey(id);
		if(null !=evaluationstandardscopedata){
			int count = evaluationstandardscopecustommapper.deleteLogicByPrimaryKey(id);
			if(count>0){
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean updateEvaluationStandardScope(EvaluationStandardScopeData evaluationstandardscopedata) {
		int count = evaluationstandardscopecustommapper.updateByPrimaryKey(evaluationstandardscopedata);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public  EvaluationStandardScopeData getEvaluationStandardScopeById(long id) {
		return evaluationstandardscopecustommapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<EvaluationStandardScopeData> queryPageInfo(PageInfo page, EvaluationStandardScopeData evaluationstandardscopedata) {
		Long count = evaluationstandardscopecustommapper.countEvaluationStandardScopePageInfo(evaluationstandardscopedata);
		page.setTotalCount(count.intValue());
		List<EvaluationStandardScopeData> evaluationstandardscopes = evaluationstandardscopecustommapper.queryEvaluationStandardScopePageInfo(page,evaluationstandardscopedata);
		page.setDates(evaluationstandardscopes);
		return page;
	}

	@Override
	public List<EvaluationStandardScopeData> getAllEvaluationStandardScopes(EvaluationStandardScopeData evaluationstandardscopedata) {
		List<EvaluationStandardScopeData> evaluationstandardscopes = evaluationstandardscopecustommapper.queryEvaluationStandardScopePageInfo(null,evaluationstandardscopedata);
		return  evaluationstandardscopes;
	}
	@Override
	public int batchDeleteInfo(List<String> infos) {
		return evaluationstandardscopecustommapper.batchLogicDeleteInfo(infos);
	}
}
