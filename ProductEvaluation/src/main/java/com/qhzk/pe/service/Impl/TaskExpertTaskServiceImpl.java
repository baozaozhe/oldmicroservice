package com.qhzk.pe.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.qhzk.pe.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;

import com.qhzk.pe.data.TaskExpertTaskData;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.TaskExpertTaskService;
import com.qhzk.pe.mapper.TaskExpertTaskCustomMapper;

/**
 * 专家评价任务 Service实现类，专家评价任务 Service实现类
 * @author: Mr.Muxl
 * @date 2021-07-20
 */

@Service
public class TaskExpertTaskServiceImpl implements TaskExpertTaskService{
	@Resource
	private TaskExpertTaskCustomMapper taskexperttaskcustommapper;

	@Override
	public boolean addTaskExpertTask(TaskExpertTaskData taskexperttaskdata) {
		taskexperttaskdata.setPkid(SnowflakeIdWorker.generateId());
		taskexperttaskdata.setIsdelete("N");
		int count = taskexperttaskcustommapper.insert(taskexperttaskdata);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delTaskExpertTaskById(long id) {
		TaskExpertTaskData taskexperttaskdata = taskexperttaskcustommapper.selectByPrimaryKey(id);
		if(null !=taskexperttaskdata){
			int count = taskexperttaskcustommapper.deleteLogicByPrimaryKey(id);
			if(count>0){
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean updateTaskExpertTask(TaskExpertTaskData taskexperttaskdata) {
		int count = taskexperttaskcustommapper.updateByPrimaryKey(taskexperttaskdata);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public  TaskExpertTaskData getTaskExpertTaskById(long id) {
		return taskexperttaskcustommapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<TaskExpertTaskData> queryPageInfo(PageInfo page, TaskExpertTaskData taskexperttaskdata) {
		Long count = taskexperttaskcustommapper.countTaskExpertTaskPageInfo(taskexperttaskdata);
		page.setTotalCount(count.intValue());
		List<TaskExpertTaskData> taskexperttasks = taskexperttaskcustommapper.queryTaskExpertTaskPageInfo(page,taskexperttaskdata);
		page.setDates(taskexperttasks);
		return page;
	}

	@Override
	public List<TaskExpertTaskData> getAllTaskExpertTasks(TaskExpertTaskData taskexperttaskdata) {
		List<TaskExpertTaskData> taskexperttasks = taskexperttaskcustommapper.queryTaskExpertTaskPageInfo(null,taskexperttaskdata);
		return  taskexperttasks;
	}
	@Override
	public int batchDeleteInfo(List<String> infos) {
		return taskexperttaskcustommapper.batchLogicDeleteInfo(infos);
	}
}

