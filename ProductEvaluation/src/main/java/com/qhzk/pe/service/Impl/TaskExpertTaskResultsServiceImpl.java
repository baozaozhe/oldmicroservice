package com.qhzk.pe.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.qhzk.pe.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;

import com.qhzk.pe.data.TaskExpertTaskResultsData;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.TaskExpertTaskResultsService;
import com.qhzk.pe.mapper.TaskExpertTaskResultsCustomMapper;

/**
 * 专家评价结果表 Service实现类，专家评价结果表 Service实现类
 * @author: Mr.Muxl
 * @date 2021-07-20
 */

@Service
public class TaskExpertTaskResultsServiceImpl implements TaskExpertTaskResultsService{
	@Resource
	private TaskExpertTaskResultsCustomMapper taskexperttaskresultscustommapper;

	@Override
	public boolean addTaskExpertTaskResults(TaskExpertTaskResultsData taskexperttaskresultsdata) {
		taskexperttaskresultsdata.setPkid(SnowflakeIdWorker.generateId());
		taskexperttaskresultsdata.setIsdelete("N");
		int count = taskexperttaskresultscustommapper.insert(taskexperttaskresultsdata);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delTaskExpertTaskResultsById(long id) {
		TaskExpertTaskResultsData taskexperttaskresultsdata = taskexperttaskresultscustommapper.selectByPrimaryKey(id);
		if(null !=taskexperttaskresultsdata){
			int count = taskexperttaskresultscustommapper.deleteLogicByPrimaryKey(id);
			if(count>0){
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean updateTaskExpertTaskResults(TaskExpertTaskResultsData taskexperttaskresultsdata) {
		int count = taskexperttaskresultscustommapper.updateByPrimaryKey(taskexperttaskresultsdata);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public  TaskExpertTaskResultsData getTaskExpertTaskResultsById(long id) {
		return taskexperttaskresultscustommapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<TaskExpertTaskResultsData> queryPageInfo(PageInfo page, TaskExpertTaskResultsData taskexperttaskresultsdata) {
		Long count = taskexperttaskresultscustommapper.countTaskExpertTaskResultsPageInfo(taskexperttaskresultsdata);
		page.setTotalCount(count.intValue());
		List<TaskExpertTaskResultsData> taskexperttaskresultss = taskexperttaskresultscustommapper.queryTaskExpertTaskResultsPageInfo(page,taskexperttaskresultsdata);
		page.setDates(taskexperttaskresultss);
		return page;
	}

	@Override
	public List<TaskExpertTaskResultsData> getAllTaskExpertTaskResultss(TaskExpertTaskResultsData taskexperttaskresultsdata) {
		List<TaskExpertTaskResultsData> taskexperttaskresultss = taskexperttaskresultscustommapper.queryTaskExpertTaskResultsPageInfo(null,taskexperttaskresultsdata);
		return  taskexperttaskresultss;
	}
	@Override
	public int batchDeleteInfo(List<String> infos) {
		return taskexperttaskresultscustommapper.batchLogicDeleteInfo(infos);
	}
}
