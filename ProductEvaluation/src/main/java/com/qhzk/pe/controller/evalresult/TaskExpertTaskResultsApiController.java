package com.qhzk.pe.controller.evalresult;

import com.qhzk.pe.common.CommonResult;
import com.qhzk.pe.data.TaskExpertTaskResultsData;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.TaskExpertTaskResultsService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 专家评价结果表控制器类，专家评价结果表资源管理
 * @author: Mr.Muxl
 * @date 2021-07-20
 */
@RestController
@RequestMapping("/taskexperttaskresults")
@Api(value = "/taskexperttaskresults", description = "专家评价结果表")
public class TaskExpertTaskResultsApiController {

    @Resource
    private TaskExpertTaskResultsService taskexperttaskresultsService;

    @RequestMapping(value = "/queryPageInfo/{pageno}",method = RequestMethod.POST)
    @ApiOperation(notes = "专家评价结果表分页", httpMethod = "POST", value = "专家评价结果表分页列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = TaskExpertTaskResultsData.class)
    public CommonResult<PageInfo<TaskExpertTaskResultsData>> queryPageInfo(@PathVariable("pageno") @ApiParam(value = "页码", required = true) int pageno,@RequestBody TaskExpertTaskResultsData  taskexperttaskresults) {
        PageInfo page = new PageInfo<TaskExpertTaskResultsData>();
        page.setPageNo(pageno);
        page.setPageSize(15);
        PageInfo<TaskExpertTaskResultsData> pageInfo= taskexperttaskresultsService.queryPageInfo(page, taskexperttaskresults);
        if(null == pageInfo ||pageInfo.getDates().isEmpty()){
            return new CommonResult<>(HttpStatus.NO_CONTENT.value(),"无记录");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"查询成功",pageInfo);
    }
    @RequestMapping(value = "/getAlltaskexperttaskresultss",method = RequestMethod.POST)
    @ApiOperation(notes = "专家评价结果表列表", httpMethod = "POST", value = "专家评价结果表列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = TaskExpertTaskResultsData.class)
    public CommonResult<List<TaskExpertTaskResultsData>> getAllTaskExpertTaskResultss(@RequestBody TaskExpertTaskResultsData taskexperttaskresults) {
        List<TaskExpertTaskResultsData> datas= taskexperttaskresultsService.getAllTaskExpertTaskResultss(taskexperttaskresults);
        if(null == datas ||datas.isEmpty()){
            return new CommonResult<>(HttpStatus.NO_CONTENT.value(),"无记录");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"查询成功",datas);
    }

    @RequestMapping(value = "/getTaskExpertTaskResultsById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据id获取专家评价结果表信息", httpMethod = "GET", value = "根据id获取专家评价结果表信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = TaskExpertTaskResultsData.class)
    public CommonResult<TaskExpertTaskResultsData> getTaskExpertTaskResultsById(@PathVariable("id") @ApiParam(value = "专家评价结果表id", required = true) long id) {
        TaskExpertTaskResultsData taskexperttaskresults = taskexperttaskresultsService.getTaskExpertTaskResultsById(id);
        if (taskexperttaskresults == null) {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"无记录");
        }
        return new CommonResult<>( HttpStatus.OK.value(),"查询成功",taskexperttaskresults);
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加专家评价结果表", httpMethod = "POST", value = "添加专家评价结果表", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = TaskExpertTaskResultsData.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "添加失败")})
    public CommonResult<TaskExpertTaskResultsData> createTaskExpertTaskResults(@RequestBody TaskExpertTaskResultsData taskexperttaskresults) {
        if (taskexperttaskresultsService.addTaskExpertTaskResults(taskexperttaskresults)){
            return new CommonResult<>( HttpStatus.CREATED.value(),"添加成功",taskexperttaskresults);
        }else {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"添加失败");
        }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "更新专家评价结果表信息", httpMethod = "PUT", value = "更新专家评价结果表", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "更新成功", response = TaskExpertTaskResultsData.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "更新失败")})
    public CommonResult<TaskExpertTaskResultsData> updateTaskExpertTaskResults(@PathVariable("id") long id, @RequestBody TaskExpertTaskResultsData taskexperttaskresults) {
        TaskExpertTaskResultsData currenttaskexperttaskresults = taskexperttaskresultsService.getTaskExpertTaskResultsById(id);

        if (currenttaskexperttaskresults==null) {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"无记录");
        }

        if (taskexperttaskresultsService.updateTaskExpertTaskResults( taskexperttaskresults)){
            return new CommonResult<>( HttpStatus.OK.value(),"更新成功",taskexperttaskresults);
        }else {
            return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"更新失败");
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "逻辑删除专家评价结果表信息", httpMethod = "DELETE", value = "逻辑删除专家评价结果表", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "删除失败")})
    public CommonResult<Object> deleteTaskExpertTaskResults(@PathVariable("id") @ApiParam(value = "专家评价结果表id", required = true)long id) {
        if (taskexperttaskresultsService.delTaskExpertTaskResultsById(id)){
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
        int  cont = taskexperttaskresultsService.batchDeleteInfo(infos);
        if(cont < 0){
            return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"删除失败");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"删除成功");
    }
}
