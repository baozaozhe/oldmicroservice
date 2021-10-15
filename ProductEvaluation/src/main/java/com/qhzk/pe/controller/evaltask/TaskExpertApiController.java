package com.qhzk.pe.controller.evaltask;

import com.qhzk.pe.common.CommonResult;
import com.qhzk.pe.data.TaskExpertData;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.TaskExpertService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评价专家表控制器类，评价专家表资源管理
 * @author: Mr.Muxl
 * @date 2021-07-20
 */
@RestController
@RequestMapping("/taskexpert")
@Api(value = "/taskexpert", description = "评价专家表")
public class TaskExpertApiController {

    @Resource
    private TaskExpertService taskexpertService;

    @RequestMapping(value = "/queryPageInfo/{pageno}",method = RequestMethod.POST)
    @ApiOperation(notes = "评价专家表分页", httpMethod = "POST", value = "评价专家表分页列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = TaskExpertData.class)
    public CommonResult<PageInfo<TaskExpertData>> queryPageInfo(@PathVariable("pageno") @ApiParam(value = "页码", required = true) int pageno,@RequestBody TaskExpertData  taskexpert) {
        PageInfo page = new PageInfo<TaskExpertData>();
        page.setPageNo(pageno);
        page.setPageSize(15);
        PageInfo<TaskExpertData> pageInfo= taskexpertService.queryPageInfo(page, taskexpert);
        if(null == pageInfo ||pageInfo.getDates().isEmpty()){
            return new CommonResult<>(HttpStatus.NO_CONTENT.value(),"无记录");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"查询成功",pageInfo);
    }
    @RequestMapping(value = "/getAlltaskexperts",method = RequestMethod.POST)
    @ApiOperation(notes = "评价专家表列表", httpMethod = "POST", value = "评价专家表列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = TaskExpertData.class)
    public CommonResult<List<TaskExpertData>> getAllTaskExperts(@RequestBody TaskExpertData taskexpert) {
        List<TaskExpertData> datas= taskexpertService.getAllTaskExperts(taskexpert);
        if(null == datas ||datas.isEmpty()){
            return new CommonResult<>(HttpStatus.NO_CONTENT.value(),"无记录");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"查询成功",datas);
    }

    @RequestMapping(value = "/getTaskExpertById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据id获取评价专家表信息", httpMethod = "GET", value = "根据id获取评价专家表信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = TaskExpertData.class)
    public CommonResult<TaskExpertData> getTaskExpertById(@PathVariable("id") @ApiParam(value = "评价专家表id", required = true) long id) {
        TaskExpertData taskexpert = taskexpertService.getTaskExpertById(id);
        if (taskexpert == null) {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"无记录");
        }
        return new CommonResult<>( HttpStatus.OK.value(),"查询成功",taskexpert);
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加评价专家表", httpMethod = "POST", value = "添加评价专家表", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = TaskExpertData.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "添加失败")})
    public CommonResult<TaskExpertData> createTaskExpert(@RequestBody TaskExpertData taskexpert) {
        if (taskexpertService.addTaskExpert(taskexpert)){
            return new CommonResult<>( HttpStatus.CREATED.value(),"添加成功",taskexpert);
        }else {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"添加失败");
        }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "更新评价专家表信息", httpMethod = "PUT", value = "更新评价专家表", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "更新成功", response = TaskExpertData.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "更新失败")})
    public CommonResult<TaskExpertData> updateTaskExpert(@PathVariable("id") long id, @RequestBody TaskExpertData taskexpert) {
        TaskExpertData currenttaskexpert = taskexpertService.getTaskExpertById(id);

        if (currenttaskexpert==null) {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"无记录");
        }

        if (taskexpertService.updateTaskExpert( taskexpert)){
            return new CommonResult<>( HttpStatus.OK.value(),"更新成功",taskexpert);
        }else {
            return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"更新失败");
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "逻辑删除评价专家表信息", httpMethod = "DELETE", value = "逻辑删除评价专家表", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "删除失败")})
    public CommonResult<Object> deleteTaskExpert(@PathVariable("id") @ApiParam(value = "评价专家表id", required = true)long id) {
        if (taskexpertService.delTaskExpertById(id)){
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
        int  cont = taskexpertService.batchDeleteInfo(infos);
        if(cont < 0){
            return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"删除失败");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"删除成功");
    }
}
