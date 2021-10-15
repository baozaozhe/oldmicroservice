package com.qhzk.pe.controller.evalnorm;

import com.qhzk.pe.common.CommonResult;
import com.qhzk.pe.data.EvaluationStandardMethodologyData;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.EvaluationStandardMethodologyService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评价标准适用评价方法控制器类，评价标准适用评价方法资源管理
 * @author: Mr.Muxl
 * @date 2021-07-20
 */
@RestController
@RequestMapping("/evaluationstandardmethodology")
@Api(value = "/evaluationstandardmethodology", description = "评价标准适用评价方法")
public class EvaluationStandardMethodologyApiController {

    @Resource
    private EvaluationStandardMethodologyService evaluationstandardmethodologyService;

    @RequestMapping(value = "/queryPageInfo/{pageno}",method = RequestMethod.POST)
    @ApiOperation(notes = "评价标准适用评价方法分页", httpMethod = "POST", value = "评价标准适用评价方法分页列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = EvaluationStandardMethodologyData.class)
    public CommonResult<PageInfo<EvaluationStandardMethodologyData>> queryPageInfo(@PathVariable("pageno") @ApiParam(value = "页码", required = true) int pageno,@RequestBody EvaluationStandardMethodologyData  evaluationstandardmethodology) {
        PageInfo page = new PageInfo<EvaluationStandardMethodologyData>();
        page.setPageNo(pageno);
        page.setPageSize(15);
        PageInfo<EvaluationStandardMethodologyData> pageInfo= evaluationstandardmethodologyService.queryPageInfo(page, evaluationstandardmethodology);
        if(null == pageInfo ||pageInfo.getDates().isEmpty()){
            return new CommonResult<>(HttpStatus.NO_CONTENT.value(),"无记录");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"查询成功",pageInfo);
    }
    @RequestMapping(value = "/getAllevaluationstandardmethodologys",method = RequestMethod.POST)
    @ApiOperation(notes = "评价标准适用评价方法列表", httpMethod = "POST", value = "评价标准适用评价方法列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = EvaluationStandardMethodologyData.class)
    public CommonResult<List<EvaluationStandardMethodologyData>> getAllEvaluationStandardMethodologys(@RequestBody EvaluationStandardMethodologyData evaluationstandardmethodology) {
        List<EvaluationStandardMethodologyData> datas= evaluationstandardmethodologyService.getAllEvaluationStandardMethodologys(evaluationstandardmethodology);
        if(null == datas ||datas.isEmpty()){
            return new CommonResult<>(HttpStatus.NO_CONTENT.value(),"无记录");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"查询成功",datas);
    }

    @RequestMapping(value = "/getEvaluationStandardMethodologyById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据id获取评价标准适用评价方法信息", httpMethod = "GET", value = "根据id获取评价标准适用评价方法信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = EvaluationStandardMethodologyData.class)
    public CommonResult<EvaluationStandardMethodologyData> getEvaluationStandardMethodologyById(@PathVariable("id") @ApiParam(value = "评价标准适用评价方法id", required = true) long id) {
        EvaluationStandardMethodologyData evaluationstandardmethodology = evaluationstandardmethodologyService.getEvaluationStandardMethodologyById(id);
        if (evaluationstandardmethodology == null) {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"无记录");
        }
        return new CommonResult<>( HttpStatus.OK.value(),"查询成功",evaluationstandardmethodology);
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加评价标准适用评价方法", httpMethod = "POST", value = "添加评价标准适用评价方法", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = EvaluationStandardMethodologyData.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "添加失败")})
    public CommonResult<EvaluationStandardMethodologyData> createEvaluationStandardMethodology(@RequestBody EvaluationStandardMethodologyData evaluationstandardmethodology) {
        if (evaluationstandardmethodologyService.addEvaluationStandardMethodology(evaluationstandardmethodology)){
            return new CommonResult<>( HttpStatus.CREATED.value(),"添加成功",evaluationstandardmethodology);
        }else {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"添加失败");
        }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "更新评价标准适用评价方法信息", httpMethod = "PUT", value = "更新评价标准适用评价方法", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "更新成功", response = EvaluationStandardMethodologyData.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "更新失败")})
    public CommonResult<EvaluationStandardMethodologyData> updateEvaluationStandardMethodology(@PathVariable("id") long id, @RequestBody EvaluationStandardMethodologyData evaluationstandardmethodology) {
        EvaluationStandardMethodologyData currentevaluationstandardmethodology = evaluationstandardmethodologyService.getEvaluationStandardMethodologyById(id);

        if (currentevaluationstandardmethodology==null) {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"无记录");
        }

        if (evaluationstandardmethodologyService.updateEvaluationStandardMethodology( evaluationstandardmethodology)){
            return new CommonResult<>( HttpStatus.OK.value(),"更新成功",evaluationstandardmethodology);
        }else {
            return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"更新失败");
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "逻辑删除评价标准适用评价方法信息", httpMethod = "DELETE", value = "逻辑删除评价标准适用评价方法", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "删除失败")})
    public CommonResult<Object> deleteEvaluationStandardMethodology(@PathVariable("id") @ApiParam(value = "评价标准适用评价方法id", required = true)long id) {
        if (evaluationstandardmethodologyService.delEvaluationStandardMethodologyById(id)){
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
        int  cont = evaluationstandardmethodologyService.batchDeleteInfo(infos);
        if(cont < 0){
            return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"删除失败");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"删除成功");
    }
}
