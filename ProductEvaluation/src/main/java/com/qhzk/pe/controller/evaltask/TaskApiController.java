package com.qhzk.pe.controller.evaltask;

import com.qhzk.pe.common.CommonResult;
import com.qhzk.pe.data.TaskData;
import com.qhzk.pe.data.TaskExpertTaskData;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.TaskService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评价任务控制器类，评价任务资源管理
 * @author: Mr.Muxl
 * @date 2021-06-28
 */
@RestController
@RequestMapping("/task")
@Api(value = "/task", description = "评价任务")
public class TaskApiController {

    @Resource
    private TaskService taskService;

    @RequestMapping(value = "/queryPageInfo/{pageno}",method = RequestMethod.POST)
    @ApiOperation(notes = "评价任务分页", httpMethod = "POST", value = "评价任务分页列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = TaskData.class)
    public CommonResult<PageInfo<TaskData>> queryPageInfo(@PathVariable("pageno") @ApiParam(value = "页码", required = true) int pageno,@RequestBody TaskData  task) {
    PageInfo page = new PageInfo<TaskData>();
        page.setPageNo(pageno);
        page.setPageSize(15);
        PageInfo<TaskData> pageInfo= taskService.queryPageInfo(page, task);
        if(null == pageInfo ||pageInfo.getDates().isEmpty()){
            return new CommonResult<>(HttpStatus.NO_CONTENT.value(),"无记录");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"查询成功",pageInfo);
    }
     @RequestMapping(value = "/getAlltasks",method = RequestMethod.POST)
     @ApiOperation(notes = "评价任务列表", httpMethod = "POST", value = "评价任务列表")
     @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
     @ApiResponse(code = 200, message = "获取成功", response = TaskData.class)
     public CommonResult<List<TaskData>> getAllTasks(@RequestBody TaskData task) {
          List<TaskData> datas= taskService.getAllTasks(task);
         if(null == datas ||datas.isEmpty()){
             return new CommonResult<>(HttpStatus.NO_CONTENT.value(),"无记录");
         }
         return new CommonResult<>(HttpStatus.OK.value(),"查询成功",datas);
     }

    @RequestMapping(value = "/getTaskById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据id获取评价任务信息", httpMethod = "GET", value = "根据id获取评价任务信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = TaskData.class)
    public CommonResult<TaskData> getTaskById(@PathVariable("id") @ApiParam(value = "评价任务id", required = true) long id) {
        TaskData task = taskService.getTaskById(id);
        if (task == null) {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"无记录");
        }
        return new CommonResult<>( HttpStatus.OK.value(),"查询成功",task);
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加评价任务", httpMethod = "POST", value = "添加评价任务", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = TaskData.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 404, message = "添加失败")})
    public CommonResult<TaskData> createTask(@RequestBody TaskData task) {
         if (taskService.addTask(task)){
             return new CommonResult<>( HttpStatus.CREATED.value(),"添加成功",task);
         }else {
             return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"添加失败");
         }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "更新评价任务信息", httpMethod = "PUT", value = "更新评价任务", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "更新成功", response = TaskData.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 404, message = "更新失败")})
    public CommonResult<TaskData> updateTask(@PathVariable("id") long id, @RequestBody TaskData task) {
          TaskData currenttask = taskService.getTaskById(id);

          if (currenttask==null) {
              return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"无记录");
          }
          if (taskService.updateTask( task)){
              return new CommonResult<>( HttpStatus.OK.value(),"更新成功",task);
          }else {
              return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"更新失败");
          }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "删除评价任务信息", httpMethod = "DELETE", value = "删除评价任务", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "更新成功"),
                        @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
                        @ApiResponse(code = 404, message = "删除失败")})
    public CommonResult<Void> deleteTask(@PathVariable("id") @ApiParam(value = "评价任务id", required = true)long id) {
        if (taskService.delTaskById(id)){
            return new CommonResult<>(HttpStatus.OK.value(),"删除成功");
        }else {
            return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"删除失败");
        }
    }

    @RequestMapping(value = "/publishtask/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "发布任务", httpMethod = "GET", value = "发布任务", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = TaskData.class)
    public CommonResult<TaskData> publishTask(@PathVariable("id") @ApiParam(value = "评价任务id", required = true) long id) {
        boolean flag = taskService.putPublishTask(id);
        if (!flag) {
            return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"发布失败");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"发布成功");
    }

    @RequestMapping(value = "/getcurrentusertask", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "获取当前用户任务", httpMethod = "POST", value = "获取当前用户任务", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = TaskData.class)
    public CommonResult< List<TaskExpertTaskData>> getCurrentUserTask(@RequestParam @ApiParam(value = "用户id", required = true) long userid,
                                                        @RequestParam @ApiParam(value = "任务状态", required = true)  String status
                                                    ) {

        List<TaskExpertTaskData>  taskdatas= taskService.getCurrentUserTask(userid,status);

        if (null != taskdatas && !taskdatas.isEmpty()) {
            return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"无记录");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"成功",taskdatas);
    }

    @RequestMapping(value = "/stoptask/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "终止任务", httpMethod = "GET", value = "终止任务", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "更新成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 404, message = "删除失败")})
    public CommonResult<Void> stopTask(@PathVariable("id") @ApiParam(value = "评价任务id", required = true)long id) {
        if (!taskService.stopTask(id)){
            return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"失败");
        }else {
            return new CommonResult<>(HttpStatus.OK.value(),"成功");
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
        int  cont = taskService.batchDeleteInfo(infos);
        if(cont < 0){
            return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"删除失败");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"删除成功");
    }

}
