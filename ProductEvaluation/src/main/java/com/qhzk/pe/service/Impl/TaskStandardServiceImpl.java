package com.qhzk.pe.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.qhzk.pe.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;

import com.qhzk.pe.data.TaskStandardData;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.TaskStandardService;
import com.qhzk.pe.mapper.TaskStandardCustomMapper;

/**
 * 评价任务使用标准 Service实现类，评价任务使用标准 Service实现类
 * @author: Mr.Muxl
 * @date 2021-06-30
 */

@Service
public class TaskStandardServiceImpl implements TaskStandardService{
	@Resource
	private TaskStandardCustomMapper taskstandardcustommapper;

	@Override
	public boolean addTaskStandard(TaskStandardData taskstandarddata) {
		taskstandarddata.setPkid(SnowflakeIdWorker.generateId());
		taskstandarddata.setIsdelete("N");
		int count = taskstandardcustommapper.insert(taskstandarddata);
		if(count>0){
			return true;
    	}
    	return false;
	}

	@Override
	public boolean delTaskStandardById(long id) {
		TaskStandardData taskstandarddata = taskstandardcustommapper.selectByPrimaryKey(id);
    	if(null !=taskstandarddata){
    		int count = taskstandardcustommapper.deleteRealByPrimaryKey(id);
			if(count>0){
				return true;
			}
			return false;
	    }
    	return false;
	}

	@Override
	public boolean updateTaskStandard(TaskStandardData taskstandarddata) {
		int count = taskstandardcustommapper.updateByPrimaryKey(taskstandarddata);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public  TaskStandardData getTaskStandardById(long id) {
		return taskstandardcustommapper.selectByPrimaryKey(id);
	}


	@Override
	public PageInfo<TaskStandardData> queryPageInfo(PageInfo page, TaskStandardData taskstandarddata) {
    	Long count = taskstandardcustommapper.countTaskStandardPageInfo(taskstandarddata);
    	page.setTotalCount(count.intValue());
    	List<TaskStandardData> taskstandards = taskstandardcustommapper.queryTaskStandardPageInfo(page,taskstandarddata);
        page.setDates(taskstandards);
        return page;
    }

    @Override
    public List<TaskStandardData> getAllTaskStandards(TaskStandardData taskstandarddata) {
         List<TaskStandardData> taskstandards = taskstandardcustommapper.queryTaskStandardPageInfo(null,taskstandarddata);
         return  taskstandards;
    }
}
