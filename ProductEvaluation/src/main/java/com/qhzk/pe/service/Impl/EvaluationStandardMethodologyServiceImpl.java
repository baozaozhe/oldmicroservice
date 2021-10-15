package com.qhzk.pe.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.qhzk.pe.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;

import com.qhzk.pe.data.EvaluationStandardMethodologyData;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.EvaluationStandardMethodologyService;
import com.qhzk.pe.mapper.EvaluationStandardMethodologyCustomMapper;

/**
 * 评价标准适用评价方法 Service实现类，评价标准适用评价方法 Service实现类
 * @author: Mr.Muxl
 * @date 2021-07-20
 */

@Service
public class EvaluationStandardMethodologyServiceImpl implements EvaluationStandardMethodologyService{
	@Resource
	private EvaluationStandardMethodologyCustomMapper evaluationstandardmethodologycustommapper;

	@Override
	public boolean addEvaluationStandardMethodology(EvaluationStandardMethodologyData evaluationstandardmethodologydata) {
		evaluationstandardmethodologydata.setPkid(SnowflakeIdWorker.generateId());
		evaluationstandardmethodologydata.setIsdelete("N");
		int count = evaluationstandardmethodologycustommapper.insert(evaluationstandardmethodologydata);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delEvaluationStandardMethodologyById(long id) {
		EvaluationStandardMethodologyData evaluationstandardmethodologydata = evaluationstandardmethodologycustommapper.selectByPrimaryKey(id);
		if(null !=evaluationstandardmethodologydata){
			int count = evaluationstandardmethodologycustommapper.deleteLogicByPrimaryKey(id);
			if(count>0){
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean updateEvaluationStandardMethodology(EvaluationStandardMethodologyData evaluationstandardmethodologydata) {
		int count = evaluationstandardmethodologycustommapper.updateByPrimaryKey(evaluationstandardmethodologydata);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public  EvaluationStandardMethodologyData getEvaluationStandardMethodologyById(long id) {
		return evaluationstandardmethodologycustommapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<EvaluationStandardMethodologyData> queryPageInfo(PageInfo page, EvaluationStandardMethodologyData evaluationstandardmethodologydata) {
		Long count = evaluationstandardmethodologycustommapper.countEvaluationStandardMethodologyPageInfo(evaluationstandardmethodologydata);
		page.setTotalCount(count.intValue());
		List<EvaluationStandardMethodologyData> evaluationstandardmethodologys = evaluationstandardmethodologycustommapper.queryEvaluationStandardMethodologyPageInfo(page,evaluationstandardmethodologydata);
		page.setDates(evaluationstandardmethodologys);
		return page;
	}

	@Override
	public List<EvaluationStandardMethodologyData> getAllEvaluationStandardMethodologys(EvaluationStandardMethodologyData evaluationstandardmethodologydata) {
		List<EvaluationStandardMethodologyData> evaluationstandardmethodologys = evaluationstandardmethodologycustommapper.queryEvaluationStandardMethodologyPageInfo(null,evaluationstandardmethodologydata);
		return  evaluationstandardmethodologys;
	}
	@Override
	public int batchDeleteInfo(List<String> infos) {
		return evaluationstandardmethodologycustommapper.batchLogicDeleteInfo(infos);
	}
}
