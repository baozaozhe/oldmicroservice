package com.qhzk.pe.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.qhzk.pe.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;

import com.qhzk.pe.data.ExpertData;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.ExpertService;
import com.qhzk.pe.mapper.ExpertCustomMapper;

/**
 * 专家表 Service实现类，专家表 Service实现类
 * @author: Mr.Muxl
 * @date 2021-07-20
 */

@Service
public class ExpertServiceImpl implements ExpertService{
	@Resource
	private ExpertCustomMapper expertcustommapper;

	@Override
	public boolean addExpert(ExpertData expertdata) {
		expertdata.setPkid(SnowflakeIdWorker.generateId());
		expertdata.setIsdelete("N");
		int count = expertcustommapper.insert(expertdata);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delExpertById(long id) {
		ExpertData expertdata = expertcustommapper.selectByPrimaryKey(id);
		if(null !=expertdata){
			int count = expertcustommapper.deleteLogicByPrimaryKey(id);
			if(count>0){
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean updateExpert(ExpertData expertdata) {
		int count = expertcustommapper.updateByPrimaryKey(expertdata);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public  ExpertData getExpertById(long id) {
		return expertcustommapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<ExpertData> queryPageInfo(PageInfo page, ExpertData expertdata) {
		Long count = expertcustommapper.countExpertPageInfo(expertdata);
		page.setTotalCount(count.intValue());
		List<ExpertData> experts = expertcustommapper.queryExpertPageInfo(page,expertdata);
		page.setDates(experts);
		return page;
	}

	@Override
	public List<ExpertData> getAllExperts(ExpertData expertdata) {
		List<ExpertData> experts = expertcustommapper.queryExpertPageInfo(null,expertdata);
		return  experts;
	}
	@Override
	public int batchDeleteInfo(List<String> infos) {
		return expertcustommapper.batchLogicDeleteInfo(infos);
	}
}
