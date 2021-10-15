package com.qhzk.pe.controller.evalresult;

import com.qhzk.pe.common.CommonResult;
import com.qhzk.pe.data.TaskExpertTaskData;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.TaskExpertTaskService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 专家评价任务控制器类，专家评价任务资源管理
 * @author: Mr.Muxl
 * @date 2021-07-20
 */
@RestController
@RequestMapping("/taskexperttask")
@Api(value = "/taskexperttask", description = "专家评价任务")
public class TaskExpertTaskApiController {

    @Resource
    private TaskExpertTaskService taskexperttaskService;

    @RequestMapping(value = "/queryPageInfo/{pageno}",method = RequestMethod.POST)
    @ApiOperation(notes = "专家评价任务分页", httpMethod = "POST", value = "专家评价任务分页列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = TaskExpertTaskData.class)
    public CommonResult<PageInfo<TaskExpertTaskData>> queryPageInfo(@PathVariable("pageno") @ApiParam(value = "页码", required = true) int pageno,@RequestBody TaskExpertTaskData  taskexperttask) {
        PageInfo page = new PageInfo<TaskExpertTaskData>();
        page.setPageNo(pageno);
        page.setPageSize(15);
        PageInfo<TaskExpertTaskData> pageInfo= taskexperttaskService.queryPageInfo(page, taskexperttask);
        if(null == pageInfo ||pageInfo.getDates().isEmpty()){
            return new CommonResult<>(HttpStatus.NO_CONTENT.value(),"无记录");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"查询成功",pageInfo);
    }
    @RequestMapping(value = "/getAlltaskexperttasks",method = RequestMethod.POST)
    @ApiOperation(notes = "专家评价任务列表", httpMethod = "POST", value = "专家评价任务列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = TaskExpertTaskData.class)
    public CommonResult<List<TaskExpertTaskData>> getAllTaskExpertTasks(@RequestBody TaskExpertTaskData taskexperttask) {
        List<TaskExpertTaskData> datas= taskexperttaskService.getAllTaskExpertTasks(taskexperttask);
        if(null == datas ||datas.isEmpty()){
            return new CommonResult<>(HttpStatus.NO_CONTENT.value(),"无记录");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"查询成功",datas);
    }

    @RequestMapping(value = "/getTaskExpertTaskById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据id获取专家评价任务信息", httpMethod = "GET", value = "根据id获取专家评价任务信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = TaskExpertTaskData.class)
    public CommonResult<TaskExpertTaskData> getTaskExpertTaskById(@PathVariable("id") @ApiParam(value = "专家评价任务id", required = true) long id) {
        TaskExpertTaskData taskexperttask = taskexperttaskService.getTaskExpertTaskById(id);
        if (taskexperttask == null) {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"无记录");
        }
        return new CommonResult<>( HttpStatus.OK.value(),"查询成功",taskexperttask);
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加专家评价任务", httpMethod = "POST", value = "添加专家评价任务", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = TaskExpertTaskData.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "添加失败")})
    public CommonResult<TaskExpertTaskData> createTaskExpertTask(@RequestBody TaskExpertTaskData taskexperttask) {
        if (taskexperttaskService.addTaskExpertTask(taskexperttask)){
            return new CommonResult<>( HttpStatus.CREATED.value(),"添加成功",taskexperttask);
        }else {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"添加失败");
        }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "更新专家评价任务信息", httpMethod = "PUT", value = "更新专家评价任务", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "更新成功", response = TaskExpertTaskData.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "更新失败")})
    public CommonResult<TaskExpertTaskData> updateTaskExpertTask(@PathVariable("id") long id, @RequestBody TaskExpertTaskData taskexperttask) {
        TaskExpertTaskData currenttaskexperttask = taskexperttaskService.getTaskExpertTaskById(id);

        if (currenttaskexperttask==null) {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"无记录");
        }

        if (taskexperttaskService.updateTaskExpertTask( taskexperttask)){
            return new CommonResult<>( HttpStatus.OK.value(),"更新成功",taskexperttask);
        }else {
            return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"更新失败");
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "逻辑删除专家评价任务信息", httpMethod = "DELETE", value = "逻辑删除专家评价任务", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "删除失败")})
    public CommonResult<Object> deleteTaskExpertTask(@PathVariable("id") @ApiParam(value = "专家评价任务id", required = true)long id) {
        if (taskexperttaskService.delTaskExpertTaskById(id)){
            return new CommonResult<>(HttpStatus.OK.value(),"删除成功");
        }else {
            return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"删除失败");
        }
    }
    @RequestMapping(value = "/batchDeleteInfo",method = RequestMethod.POST)
    @ApiOperation(notes = "根据id列表批量删除", httpMethod = "POST", value = "根据id列表批量删除")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "失败")})
    public CommonResult<Object> batchDeleteInfo(@RequestBody List<String> infos) {
        if(null == infos||infos.isEmpty()){
            return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"列表参不能为空");
        }
        int  cont = taskexperttaskService.batchDeleteInfo(infos);
        if(cont < 0){
            return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"删除失败");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"删除成功");
    }
}
