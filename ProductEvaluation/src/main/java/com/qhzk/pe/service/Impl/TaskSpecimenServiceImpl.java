package com.qhzk.pe.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.qhzk.pe.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;

import com.qhzk.pe.data.TaskSpecimenData;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.TaskSpecimenService;
import com.qhzk.pe.mapper.TaskSpecimenCustomMapper;


/**
 * 评价任务样品 Service实现类，评价任务样品 Service实现类
 * @author: Mr.Muxl
 * @date 2021-07-20
 */

@Service
public class TaskSpecimenServiceImpl implements TaskSpecimenService{
	@Resource
	private TaskSpecimenCustomMapper taskspecimencustommapper;

	@Override
	public boolean addTaskSpecimen(TaskSpecimenData taskspecimendata) {
		taskspecimendata.setPkid(SnowflakeIdWorker.generateId());
		taskspecimendata.setIsdelete("N");
		int count = taskspecimencustommapper.insert(taskspecimendata);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delTaskSpecimenById(long id) {
		TaskSpecimenData taskspecimendata = taskspecimencustommapper.selectByPrimaryKey(id);
		if(null !=taskspecimendata){
			int count = taskspecimencustommapper.deleteLogicByPrimaryKey(id);
			if(count>0){
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean updateTaskSpecimen(TaskSpecimenData taskspecimendata) {
		int count = taskspecimencustommapper.updateByPrimaryKey(taskspecimendata);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public  TaskSpecimenData getTaskSpecimenById(long id) {
		return taskspecimencustommapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<TaskSpecimenData> queryPageInfo(PageInfo page, TaskSpecimenData taskspecimendata) {
		Long count = taskspecimencustommapper.countTaskSpecimenPageInfo(taskspecimendata);
		page.setTotalCount(count.intValue());
		List<TaskSpecimenData> taskspecimens = taskspecimencustommapper.queryTaskSpecimenPageInfo(page,taskspecimendata);
		page.setDates(taskspecimens);
		return page;
	}

	@Override
	public List<TaskSpecimenData> getAllTaskSpecimens(TaskSpecimenData taskspecimendata) {
		List<TaskSpecimenData> taskspecimens = taskspecimencustommapper.queryTaskSpecimenPageInfo(null,taskspecimendata);
		return  taskspecimens;
	}
	@Override
	public int batchDeleteInfo(List<String> infos) {
		return taskspecimencustommapper.batchLogicDeleteInfo(infos);
	}
}
