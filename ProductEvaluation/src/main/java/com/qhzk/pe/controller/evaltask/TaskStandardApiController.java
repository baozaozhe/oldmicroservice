package com.qhzk.pe.controller.evaltask;

import com.qhzk.pe.common.CommonResult;
import com.qhzk.pe.data.TaskStandardData;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.TaskStandardService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评价任务使用标准控制器类，评价任务使用标准资源管理
 * @author: Mr.Muxl
 * @date 2021-06-30
 */
@RestController
@RequestMapping("/taskstandard")
@Api(value = "/taskstandard", description = "评价任务使用标准")
public class TaskStandardApiController {

    @Resource
    private TaskStandardService taskstandardService;

    @RequestMapping(value = "/queryPageInfo/{pageno}",method = RequestMethod.POST)
    @ApiOperation(notes = "评价任务使用标准分页", httpMethod = "POST", value = "评价任务使用标准分页列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = TaskStandardData.class)
    public CommonResult<PageInfo<TaskStandardData>> queryPageInfo(@PathVariable("pageno") @ApiParam(value = "页码", required = true) int pageno,@RequestBody TaskStandardData  taskstandard) {
    PageInfo page = new PageInfo<TaskStandardData>();
        page.setPageNo(pageno);
        page.setPageSize(15);
        PageInfo<TaskStandardData> pageInfo= taskstandardService.queryPageInfo(page, taskstandard);
        if(null == pageInfo ||pageInfo.getDates().isEmpty()){
            return new CommonResult<>(HttpStatus.NO_CONTENT.value(),"无记录");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"查询成功",pageInfo);
    }
     @RequestMapping(value = "/getAlltaskstandards",method = RequestMethod.POST)
     @ApiOperation(notes = "评价任务使用标准列表", httpMethod = "POST", value = "评价任务使用标准列表")
     @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
     @ApiResponse(code = 200, message = "获取成功", response = TaskStandardData.class)
     public CommonResult<List<TaskStandardData>> getAllTaskStandards(@RequestBody TaskStandardData taskstandard) {
          List<TaskStandardData> datas= taskstandardService.getAllTaskStandards(taskstandard);
         if(null == datas ||datas.isEmpty()){
             return new CommonResult<>(HttpStatus.NO_CONTENT.value(),"无记录");
         }
         return new CommonResult<>(HttpStatus.OK.value(),"查询成功",datas);
     }

    @RequestMapping(value = "/getTaskStandardById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据id获取评价任务使用标准信息", httpMethod = "GET", value = "根据id获取评价任务使用标准信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = TaskStandardData.class)
    public CommonResult<TaskStandardData> getTaskStandardById(@PathVariable("id") @ApiParam(value = "评价任务使用标准id", required = true) long id) {
        TaskStandardData taskstandard = taskstandardService.getTaskStandardById(id);
        if (taskstandard == null) {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"无记录");
        }
        return new CommonResult<>( HttpStatus.OK.value(),"查询成功",taskstandard);
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加评价任务使用标准", httpMethod = "POST", value = "添加评价任务使用标准", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = TaskStandardData.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 404, message = "添加失败")})
    public CommonResult<TaskStandardData> createTaskStandard(@RequestBody TaskStandardData taskstandard) {
         if (taskstandardService.addTaskStandard(taskstandard)){
             return new CommonResult<>( HttpStatus.CREATED.value(),"添加成功",taskstandard);
         }else {
             return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"添加失败");
         }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "更新评价任务使用标准信息", httpMethod = "PUT", value = "更新评价任务使用标准", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "更新成功", response = TaskStandardData.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 404, message = "更新失败")})
    public CommonResult<TaskStandardData> updateTaskStandard(@PathVariable("id") long id, @RequestBody TaskStandardData taskstandard) {
          TaskStandardData currenttaskstandard = taskstandardService.getTaskStandardById(id);

          if (currenttaskstandard==null) {
              return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"无记录");
          }

          if (taskstandardService.updateTaskStandard( taskstandard)){
              return new CommonResult<>( HttpStatus.OK.value(),"更新成功",taskstandard);
          }else {
              return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"更新失败");
          }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "删除评价任务使用标准信息", httpMethod = "DELETE", value = "删除评价任务使用标准", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
                        @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
                        @ApiResponse(code = 404, message = "删除失败")})
    public CommonResult<Void> deleteTaskStandard(@PathVariable("id") @ApiParam(value = "评价任务使用标准id", required = true)long id) {
        if (taskstandardService.delTaskStandardById(id)){
            return new CommonResult<>(HttpStatus.OK.value(),"删除成功");
        }else {
            return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"删除失败");
        }
    }
}
