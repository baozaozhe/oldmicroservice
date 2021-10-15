package com.qhzk.pe.controller.evaltask;

import com.qhzk.pe.common.CommonResult;
import com.qhzk.pe.data.TaskSpecimenData;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.TaskSpecimenService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评价标准明细控制器类，评价标准明细资源管理
 * @author: Mr.Muxl
 * @date 2021-06-30
 */
@RestController
@RequestMapping("/taskspecimen")
@Api(value = "/taskspecimen", description = "评价标准明细")
public class TaskSpecimenApiController {

    @Resource
    private TaskSpecimenService taskspecimenService;

    @RequestMapping(value = "/queryPageInfo/{pageno}",method = RequestMethod.POST)
    @ApiOperation(notes = "评价标准明细分页", httpMethod = "POST", value = "评价标准明细分页列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = TaskSpecimenData.class)
    public CommonResult<PageInfo<TaskSpecimenData>> queryPageInfo(@PathVariable("pageno") @ApiParam(value = "页码", required = true) int pageno,@RequestBody TaskSpecimenData  taskspecimen) {
    PageInfo page = new PageInfo<TaskSpecimenData>();
        page.setPageNo(pageno);
        page.setPageSize(15);
        PageInfo<TaskSpecimenData> pageInfo= taskspecimenService.queryPageInfo(page, taskspecimen);
        if(null == pageInfo ||pageInfo.getDates().isEmpty()){
            return new CommonResult<>(HttpStatus.NO_CONTENT.value(),"无记录");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"查询成功",pageInfo);
    }
     @RequestMapping(value = "/getAlltaskspecimens",method = RequestMethod.POST)
     @ApiOperation(notes = "评价标准明细列表", httpMethod = "POST", value = "评价标准明细列表")
     @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
     @ApiResponse(code = 200, message = "获取成功", response = TaskSpecimenData.class)
     public CommonResult<List<TaskSpecimenData>> getAllTaskSpecimens(@RequestBody TaskSpecimenData taskspecimen) {
          List<TaskSpecimenData> datas= taskspecimenService.getAllTaskSpecimens(taskspecimen);
         if(null == datas ||datas.isEmpty()){
             return new CommonResult<>(HttpStatus.NO_CONTENT.value(),"无记录");
         }
         return new CommonResult<>(HttpStatus.OK.value(),"查询成功",datas);
     }

    @RequestMapping(value = "/getTaskSpecimenById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据id获取评价标准明细信息", httpMethod = "GET", value = "根据id获取评价标准明细信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = TaskSpecimenData.class)
    public CommonResult<TaskSpecimenData> getTaskSpecimenById(@PathVariable("id") @ApiParam(value = "评价标准明细id", required = true) long id) {
        TaskSpecimenData taskspecimen = taskspecimenService.getTaskSpecimenById(id);
        if (taskspecimen == null) {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"无记录");
        }
        return new CommonResult<>( HttpStatus.OK.value(),"查询成功",taskspecimen);
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加评价标准明细", httpMethod = "POST", value = "添加评价标准明细", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = TaskSpecimenData.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 404, message = "添加失败")})
    public CommonResult<TaskSpecimenData> createTaskSpecimen(@RequestBody TaskSpecimenData taskspecimen) {
         if (taskspecimenService.addTaskSpecimen(taskspecimen)){
             return new CommonResult<>( HttpStatus.CREATED.value(),"添加成功",taskspecimen);
         }else {
             return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"添加失败");
         }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "更新评价标准明细信息", httpMethod = "PUT", value = "更新评价标准明细", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "更新成功", response = TaskSpecimenData.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 404, message = "更新失败")})
    public CommonResult<TaskSpecimenData> updateTaskSpecimen(@PathVariable("id") long id, @RequestBody TaskSpecimenData taskspecimen) {
          TaskSpecimenData currenttaskspecimen = taskspecimenService.getTaskSpecimenById(id);

          if (currenttaskspecimen==null) {
              return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"无记录");
          }

          if (taskspecimenService.updateTaskSpecimen( taskspecimen)){
              return new CommonResult<>( HttpStatus.OK.value(),"更新成功",taskspecimen);
          }else {
              return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"更新失败");
          }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "删除评价标准明细信息", httpMethod = "DELETE", value = "删除评价标准明细", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
                        @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
                        @ApiResponse(code = 404, message = "删除失败")})
    public CommonResult<Void> deleteTaskSpecimen(@PathVariable("id") @ApiParam(value = "评价标准明细id", required = true)long id) {
        if (taskspecimenService.delTaskSpecimenById(id)){
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
        int  cont = taskspecimenService.batchDeleteInfo(infos);
        if(cont < 0){
            return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"删除失败");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"删除成功");
    }
}
