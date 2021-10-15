package com.qhzk.pe.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.qhzk.pe.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;

import com.qhzk.pe.data.TaskExpertData;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.TaskExpertService;
import com.qhzk.pe.mapper.TaskExpertCustomMapper;

/**
 * 评价专家表 Service实现类，评价专家表 Service实现类
 * @author: Mr.Muxl
 * @date 2021-07-20
 */

@Service
public class TaskExpertServiceImpl implements TaskExpertService{
	@Resource
	private TaskExpertCustomMapper taskexpertcustommapper;

	@Override
	public boolean addTaskExpert(TaskExpertData taskexpertdata) {
		taskexpertdata.setPkid(SnowflakeIdWorker.generateId());
		taskexpertdata.setIsdelete("N");
		int count = taskexpertcustommapper.insert(taskexpertdata);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delTaskExpertById(long id) {
		TaskExpertData taskexpertdata = taskexpertcustommapper.selectByPrimaryKey(id);
		if(null !=taskexpertdata){
			int count = taskexpertcustommapper.deleteLogicByPrimaryKey(id);
			if(count>0){
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean updateTaskExpert(TaskExpertData taskexpertdata) {
		int count = taskexpertcustommapper.updateByPrimaryKey(taskexpertdata);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public  TaskExpertData getTaskExpertById(long id) {
		return taskexpertcustommapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<TaskExpertData> queryPageInfo(PageInfo page, TaskExpertData taskexpertdata) {
		Long count = taskexpertcustommapper.countTaskExpertPageInfo(taskexpertdata);
		page.setTotalCount(count.intValue());
		List<TaskExpertData> taskexperts = taskexpertcustommapper.queryTaskExpertPageInfo(page,taskexpertdata);
		page.setDates(taskexperts);
		return page;
	}

	@Override
	public List<TaskExpertData> getAllTaskExperts(TaskExpertData taskexpertdata) {
		List<TaskExpertData> taskexperts = taskexpertcustommapper.queryTaskExpertPageInfo(null,taskexpertdata);
		return  taskexperts;
	}
	@Override
	public int batchDeleteInfo(List<String> infos) {
		return taskexpertcustommapper.batchLogicDeleteInfo(infos);
	}
}
