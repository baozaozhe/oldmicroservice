package com.qhzk.pe.controller.evalnorm;

import com.qhzk.pe.common.CommonResult;
import com.qhzk.pe.data.IndicatorVariablesValuesData;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.IndicatorVariablesValuesService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * 评价指标项值控制器类，评价指标项值资源管理
 * @author: Mr.Muxl
 * @date 2021-07-20
 */
@RestController
@RequestMapping("/indicatorvariablesvalues")
@Api(value = "/indicatorvariablesvalues", description = "评价指标项值")
public class IndicatorVariablesValuesApiController {

    @Resource
    private IndicatorVariablesValuesService indicatorvariablesvaluesService;

    @RequestMapping(value = "/queryPageInfo/{pageno}",method = RequestMethod.POST)
    @ApiOperation(notes = "评价指标项值分页", httpMethod = "POST", value = "评价指标项值分页列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = IndicatorVariablesValuesData.class)
    public CommonResult<PageInfo<IndicatorVariablesValuesData>> queryPageInfo(@PathVariable("pageno") @ApiParam(value = "页码", required = true) int pageno,@RequestBody IndicatorVariablesValuesData  indicatorvariablesvalues) {
        PageInfo page = new PageInfo<IndicatorVariablesValuesData>();
        page.setPageNo(pageno);
        page.setPageSize(15);
        PageInfo<IndicatorVariablesValuesData> pageInfo= indicatorvariablesvaluesService.queryPageInfo(page, indicatorvariablesvalues);
        if(null == pageInfo ||pageInfo.getDates().isEmpty()){
            return new CommonResult<>(HttpStatus.NO_CONTENT.value(),"无记录");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"查询成功",pageInfo);
    }
    @RequestMapping(value = "/getAllindicatorvariablesvaluess",method = RequestMethod.POST)
    @ApiOperation(notes = "评价指标项值列表", httpMethod = "POST", value = "评价指标项值列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = IndicatorVariablesValuesData.class)
    public CommonResult<List<IndicatorVariablesValuesData>> getAllIndicatorVariablesValuess(@RequestBody IndicatorVariablesValuesData indicatorvariablesvalues) {
        List<IndicatorVariablesValuesData> datas= indicatorvariablesvaluesService.getAllIndicatorVariablesValuess(indicatorvariablesvalues);
        if(null == datas ||datas.isEmpty()){
            return new CommonResult<>(HttpStatus.NO_CONTENT.value(),"无记录");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"查询成功",datas);
    }

    @RequestMapping(value = "/getIndicatorVariablesValuesById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据id获取评价指标项值信息", httpMethod = "GET", value = "根据id获取评价指标项值信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = IndicatorVariablesValuesData.class)
    public CommonResult<IndicatorVariablesValuesData> getIndicatorVariablesValuesById(@PathVariable("id") @ApiParam(value = "评价指标项值id", required = true) long id) {
        IndicatorVariablesValuesData indicatorvariablesvalues = indicatorvariablesvaluesService.getIndicatorVariablesValuesById(id);
        if (indicatorvariablesvalues == null) {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"无记录");
        }
        return new CommonResult<>( HttpStatus.OK.value(),"查询成功",indicatorvariablesvalues);
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加评价指标项值", httpMethod = "POST", value = "添加评价指标项值", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = IndicatorVariablesValuesData.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "添加失败")})
    public CommonResult<IndicatorVariablesValuesData> createIndicatorVariablesValues(@RequestBody IndicatorVariablesValuesData indicatorvariablesvalues) {
        if (indicatorvariablesvaluesService.addIndicatorVariablesValues(indicatorvariablesvalues)){
            return new CommonResult<>( HttpStatus.CREATED.value(),"添加成功",indicatorvariablesvalues);
        }else {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"添加失败");
        }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "更新评价指标项值信息", httpMethod = "PUT", value = "更新评价指标项值", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "更新成功", response = IndicatorVariablesValuesData.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "更新失败")})
    public CommonResult<IndicatorVariablesValuesData> updateIndicatorVariablesValues(@PathVariable("id") long id, @RequestBody IndicatorVariablesValuesData indicatorvariablesvalues) {
        IndicatorVariablesValuesData currentindicatorvariablesvalues = indicatorvariablesvaluesService.getIndicatorVariablesValuesById(id);

        if (currentindicatorvariablesvalues==null) {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"无记录");
        }

        if (indicatorvariablesvaluesService.updateIndicatorVariablesValues( indicatorvariablesvalues)){
            return new CommonResult<>( HttpStatus.OK.value(),"更新成功",indicatorvariablesvalues);
        }else {
            return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"更新失败");
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "逻辑删除评价指标项值信息", httpMethod = "DELETE", value = "逻辑删除评价指标项值", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "删除失败")})
    public CommonResult<Object> deleteIndicatorVariablesValues(@PathVariable("id") @ApiParam(value = "评价指标项值id", required = true)long id) {
        if (indicatorvariablesvaluesService.delIndicatorVariablesValuesById(id)){
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
        int  cont = indicatorvariablesvaluesService.batchDeleteInfo(infos);
        if(cont < 0){
            return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"删除失败");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"删除成功");
    }
}

