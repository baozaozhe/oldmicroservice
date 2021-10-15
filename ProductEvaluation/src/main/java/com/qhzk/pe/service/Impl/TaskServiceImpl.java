package com.qhzk.pe.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.qhzk.pe.data.*;
import com.qhzk.pe.mapper.*;
import com.qhzk.pe.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;

import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.TaskService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 评价任务 Service实现类，评价任务 Service实现类
 * @author: Mr.Muxl
 * @date 2021-06-28
 */

@Service
public class TaskServiceImpl implements TaskService{
	@Resource
	private TaskCustomMapper taskcustommapper;
	@Resource
	private TaskExpertCustomMapper taskexpertcustommapper;
	@Resource
	private TaskSpecimenCustomMapper taskspecimencustommapper;
	@Resource
	private TaskStandardCustomMapper taskstandardcustommapper;
	@Resource
	private TaskExpertTaskCustomMapper taskexperttaskcustommapper;

	@Override
	public boolean addTask(TaskData taskdata) {
		taskdata.setPkid(SnowflakeIdWorker.generateId());
		taskdata.setIsdelete("N");
		int count = taskcustommapper.insert(taskdata);
		if(count>0){
			List<TaskExpertData> experts = taskdata.getExperts().stream().map(p -> {
				p.setPkid(SnowflakeIdWorker.generateId());
				p.setTaskid(taskdata.getPkid());
				return p;
			}).collect(Collectors.toList());

			List<TaskStandardData> standards = taskdata.getStandards().stream().map(p -> {
				p.setPkid(SnowflakeIdWorker.generateId());
				p.setTaskid(taskdata.getPkid());
				return p;
			}).collect(Collectors.toList());

			List<TaskSpecimenData> specimens = taskdata.getSpecimens().stream().map(p -> {
				p.setPkid(SnowflakeIdWorker.generateId());
				p.setTaskid(taskdata.getPkid());
				return p;
			}).collect(Collectors.toList());

			if(null != experts && !experts.isEmpty()){
				int eflag = taskexpertcustommapper.batchInsertValues(experts);
			}
			if(null != specimens && !specimens.isEmpty()){
				int tflag = taskspecimencustommapper.batchInsertValues(specimens);
			}
			if(null != standards && !standards.isEmpty()){
				int sflag = taskstandardcustommapper.batchInsertValues(standards);
			}
			return true;
    	}
    	return false;
	}

	@Override
	public boolean delTaskById(long id) {
		TaskData taskdata = taskcustommapper.selectByPrimaryKey(id);
    	if(null !=taskdata){
    		int count = taskcustommapper.deleteTaskByPrimaryKey(id);
			if(count>0){
				return true;
			}
			return false;
	    }
    	return false;
	}

	@Override
	public boolean updateTask(TaskData taskdata) {
		int count = taskcustommapper.updateByPrimaryKey(taskdata);
		if(count>0){
			List<TaskExpertData> experts = taskdata.getExperts();
			List<TaskStandardData> standards = taskdata.getStandards();
			List<TaskSpecimenData> specimens = taskdata.getSpecimens();
			if(null != experts && !experts.isEmpty()){
				int eflag = taskexpertcustommapper.batchUpdateValues(experts);
			}
			if(null != specimens && !specimens.isEmpty()){
				int tflag = taskspecimencustommapper.batchUpdateValues(specimens);
			}
			if(null != standards && !standards.isEmpty()){
				int sflag = taskstandardcustommapper.batchUpdateValues(standards);
			}
			return true;
		}
		return false;
	}

	@Override
	public  TaskData getTaskById(long id) {
		return taskcustommapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<TaskData> queryPageInfo(PageInfo page, TaskData taskdata) {
    	Long count = taskcustommapper.countTaskPageInfo(taskdata);
    	page.setTotalCount(count.intValue());
    	List<TaskData> tasks = taskcustommapper.queryTaskPageInfo(page,taskdata);
        page.setDates(tasks);
        return page;
    }

    @Override
    public List<TaskData> getAllTasks(TaskData taskdata) {
         List<TaskData> tasks = taskcustommapper.queryTaskPageInfo(null,taskdata);
         return  tasks;
    }

	@Override
	@Transactional
	public boolean putPublishTask(long id) {
		TaskData taskdata = taskcustommapper.selectByPrimaryKey(id);
		if(null != taskdata){
			taskdata.setStatus("2");
			if(taskcustommapper.updateByPrimaryKey(taskdata)>0){
				List<TaskSpecimenData> specimens = taskdata.getSpecimens();
				List<TaskStandardData> standards = taskdata.getStandards();
				List<TaskExpertData> experts = taskdata.getExperts();
				if(null != specimens && !specimens.isEmpty()){
					List<TaskExpertTaskData> expertasks = new ArrayList<TaskExpertTaskData>();
					if("sp".equals(taskdata.getEvaluationmodel())){//单人模式
						for (TaskExpertData expert:experts) {
							for (TaskSpecimenData specimen:specimens) {
								TaskExpertTaskData expertask = new TaskExpertTaskData();
								expertask.setPkid(SnowflakeIdWorker.generateId());
								expertask.setTaskid(taskdata.getPkid());
								expertask.setTasktype(taskdata.getTasktype());
								expertask.setStarttime(taskdata.getStarttime());
								expertask.setEndtime(taskdata.getEndtime());
								expertask.setStatus("1");
								expertask.setMeans(taskdata.getMeans());
								expertask.setEvaluationmodel(taskdata.getEvaluationmodel());

								expertask.setExpertid(expert.getExpertid());
								expertask.setUserid(expert.getUserid());
								expertask.setUsertype(expert.getUsertype());
								expertask.setUsername(expert.getUsername());
								expertask.setFullname(expert.getFullname());
								expertask.setTelephone(expert.getTelephone());

								expertask.setSpecimenid(specimen.getSpecimenid());
								expertask.setSpecode(specimen.getSpecode());
								expertask.setSpename(specimen.getSpename());
								expertasks.add(expertask);
							}
						}
					}
					if("sm".equals(taskdata.getEvaluationmodel())){//共享模式
						for (TaskSpecimenData specimen:specimens) {
							TaskExpertTaskData expertask = new TaskExpertTaskData();
							expertask.setPkid(SnowflakeIdWorker.generateId());
							expertask.setTaskid(taskdata.getPkid());
							expertask.setTasktype(taskdata.getTasktype());
							expertask.setStarttime(taskdata.getStarttime());
							expertask.setEndtime(taskdata.getEndtime());
							expertask.setStatus("1");
							expertask.setMeans(taskdata.getMeans());
							expertask.setEvaluationmodel(taskdata.getEvaluationmodel());
							expertask.setSpecimenid(specimen.getSpecimenid());
							expertask.setSpecode(specimen.getSpecode());
							expertask.setSpename(specimen.getSpename());
							expertasks.add(expertask);
						}
					}
					if("mm".equals(taskdata.getEvaluationmodel())){//会议模式
						for (TaskSpecimenData specimen:specimens) {
							TaskExpertTaskData expertask = new TaskExpertTaskData();
							expertask.setPkid(SnowflakeIdWorker.generateId());
							expertask.setTaskid(taskdata.getPkid());
							expertask.setTasktype(taskdata.getTasktype());
							expertask.setStarttime(taskdata.getStarttime());
							expertask.setEndtime(taskdata.getEndtime());
							expertask.setStatus("1");
							expertask.setMeans(taskdata.getMeans());
							expertask.setEvaluationmodel(taskdata.getEvaluationmodel());
							expertask.setSpecimenid(specimen.getSpecimenid());
							expertask.setSpecode(specimen.getSpecode());
							expertask.setSpename(specimen.getSpename());
							expertasks.add(expertask);
						}
					}
					if(null != expertasks && !expertasks.isEmpty()){
						int i = taskexperttaskcustommapper.batchInsertValues(expertasks, taskdata.getPkid());
						return true;
					}else{
						return true;
					}
				}

			}
		}
		return false;
	}

	@Override
	public List<TaskExpertTaskData> getCurrentUserTask(long userid, String status) {
		//获取当前用户任务列表
		List<TaskData> taskData = taskexpertcustommapper.getCurrentUserTask(userid);
		if(null == taskData && taskData.isEmpty()){
			return null;
		}
		TaskExpertTaskData e = new TaskExpertTaskData();
		e.setUserid(userid);
		//获取专家任务
		return taskexperttaskcustommapper.queryTaskExpertTaskPageInfo(null,e);
	}

	@Override
	public boolean stopTask(long id) {
		if(taskcustommapper.stopTask(id) > 0){
			return true;
		}
		return false;
	}
	@Override
	public int batchDeleteInfo(List<String> infos) {
		return taskcustommapper.batchLogicDeleteInfo(infos);
	}
}
