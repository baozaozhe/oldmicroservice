package com.qhzk.pe.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.qhzk.pe.data.EvaluationStandardItemData;
import com.qhzk.pe.data.EvaluationStandardMethodologyData;
import com.qhzk.pe.data.EvaluationStandardScopeData;
import com.qhzk.pe.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;

import com.qhzk.pe.data.EvaluationStandardData;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.EvaluationStandardService;
import com.qhzk.pe.mapper.EvaluationStandardCustomMapper;

/**
 * 评价标准 Service实现类，评价标准 Service实现类
 * @author: Mr.Muxl
 * @date 2021-06-29
 */

@Service
public class EvaluationStandardServiceImpl implements EvaluationStandardService{
	@Resource
	private EvaluationStandardCustomMapper evaluationstandardcustommapper;

	@Override
	public boolean addEvaluationStandard(EvaluationStandardData evaluationstandarddata) {
		evaluationstandarddata.setPkid(SnowflakeIdWorker.generateId());
		evaluationstandarddata.setIsdelete("N");
		int count = evaluationstandardcustommapper.insert(evaluationstandarddata);
		if(count>0){
			List<EvaluationStandardItemData> items = evaluationstandarddata.getItems().stream().map(p -> {
				p.setPkid(SnowflakeIdWorker.generateId());
				p.setStandardid(evaluationstandarddata.getPkid());
				return p;
			}).collect(Collectors.toList());

			List<EvaluationStandardScopeData> scopes = evaluationstandarddata.getScopes().stream().map(p -> {
				p.setPkid(SnowflakeIdWorker.generateId());
				p.setStandardid(evaluationstandarddata.getPkid());
				return p;
			}).collect(Collectors.toList());

			EvaluationStandardMethodologyData method = evaluationstandarddata.getMethod();
			method.setPkid(SnowflakeIdWorker.generateId());
			method.setStandardid(evaluationstandarddata.getPkid());

			if(null != items && !items.isEmpty() ){
				int iflag = evaluationstandardcustommapper.batchInsertItemValues(items);
			}
			if(null != scopes && !scopes.isEmpty() ){
				int cflag = evaluationstandardcustommapper.batchInsertScopeValues(scopes);
			}
			if(null != method ){
				int imflag = evaluationstandardcustommapper.insertMethodoValues(method);
			}
			return true;
    	}
    	return false;
	}

	@Override
	public boolean delEvaluationStandardById(long id) {
		EvaluationStandardData evaluationstandarddata = evaluationstandardcustommapper.selectByPrimaryKey(id);
    	if(null !=evaluationstandarddata){
    		int count = evaluationstandardcustommapper.deleteEvaluationStandardByPrimaryKey(id);
			if(count>0){
				return true;
			}
			return false;
	    }
    	return false;
	}

	@Override
	public boolean updateEvaluationStandard(EvaluationStandardData evaluationstandarddata) {
		int count = evaluationstandardcustommapper.updateByPrimaryKey(evaluationstandarddata);
		if(count>0){
			List<EvaluationStandardItemData> items = evaluationstandarddata.getItems();
			List<EvaluationStandardScopeData> scopes = evaluationstandarddata.getScopes();
			EvaluationStandardMethodologyData method = evaluationstandarddata.getMethod();
			int iflag = evaluationstandardcustommapper.batchUpdateItemValues(items);
			int cflag = evaluationstandardcustommapper.batchUpdateScopeValues(scopes);
			int imflag = evaluationstandardcustommapper.updateMethodoValues(method);
			return true;
		}
		return false;
	}

	@Override
	public  EvaluationStandardData getEvaluationStandardById(long id) {
		return evaluationstandardcustommapper.selectByPrimaryKey(id);
	}
	@Override
	public PageInfo<EvaluationStandardData> queryPageInfo(PageInfo page, EvaluationStandardData evaluationstandarddata) {
    	Long count = evaluationstandardcustommapper.countEvaluationStandardPageInfo(evaluationstandarddata);
    	page.setTotalCount(count.intValue());
    	List<EvaluationStandardData> evaluationstandards = evaluationstandardcustommapper.queryEvaluationStandardPageInfo(page,evaluationstandarddata);
        page.setDates(evaluationstandards);
        return page;
    }

    @Override
    public List<EvaluationStandardData> getAllEvaluationStandards(EvaluationStandardData evaluationstandarddata) {
         List<EvaluationStandardData> evaluationstandards = evaluationstandardcustommapper.queryEvaluationStandardPageInfo(null,evaluationstandarddata);
         return  evaluationstandards;
    }
	@Override
	public int batchDeleteInfo(List<String> infos) {
		return evaluationstandardcustommapper.batchRealDeleteInfo(infos);
	}

	@Override
	public List<EvaluationStandardData> getEvalstandardByMeanAndScope(String mean, String scope) {
		return evaluationstandardcustommapper.getEvalstandardByMeanAndScope(mean,scope);
	}
}
