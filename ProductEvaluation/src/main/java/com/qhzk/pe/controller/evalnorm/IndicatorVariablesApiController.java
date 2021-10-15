package com.qhzk.pe.controller.evalnorm;

import com.qhzk.pe.common.CommonResult;
import com.qhzk.pe.data.IndicatorVariablesData;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.IndicatorVariablesService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 评价指标项控制器类，评价指标项资源管理
 * @author: Mr.Muxl
 * @date 2021-06-29
 */
@RestController
@RequestMapping("/indicatorvariables")
@Api(value = "/indicatorvariables", description = "评价指标项")
public class IndicatorVariablesApiController {

    @Resource
    private IndicatorVariablesService indicatorvariablesService;

    @RequestMapping(value = "/queryPageInfo/{pageno}",method = RequestMethod.POST)
    @ApiOperation(notes = "评价指标项分页", httpMethod = "POST", value = "评价指标项分页列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = IndicatorVariablesData.class)
    public CommonResult<PageInfo<IndicatorVariablesData>> queryPageInfo(@PathVariable("pageno") @ApiParam(value = "页码", required = true) int pageno,@RequestBody IndicatorVariablesData  indicatorvariables) {
    PageInfo page = new PageInfo<IndicatorVariablesData>();
        page.setPageNo(pageno);
        page.setPageSize(15);
        PageInfo<IndicatorVariablesData> pageInfo= indicatorvariablesService.queryPageInfo(page, indicatorvariables);
        if(null == pageInfo ||pageInfo.getDates().isEmpty()){
            return new CommonResult<>(HttpStatus.NO_CONTENT.value(),"无记录");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"查询成功",pageInfo);
    }
     @RequestMapping(value = "/getAllindicatorvariabless",method = RequestMethod.POST)
     @ApiOperation(notes = "评价指标项列表", httpMethod = "POST", value = "评价指标项列表")
     @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
     @ApiResponse(code = 200, message = "获取成功", response = IndicatorVariablesData.class)
     public CommonResult<List<IndicatorVariablesData>> getAllIndicatorVariabless(@RequestBody IndicatorVariablesData indicatorvariables) {
          List<IndicatorVariablesData> datas= indicatorvariablesService.getAllIndicatorVariabless(indicatorvariables);
         if(null == datas ||datas.isEmpty()){
             return new CommonResult<>(HttpStatus.NO_CONTENT.value(),"无记录");
         }
         return new CommonResult<>(HttpStatus.OK.value(),"查询成功",datas);
     }

    @RequestMapping(value = "/getIndicatorVariablesById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据id获取评价指标项信息", httpMethod = "GET", value = "根据id获取评价指标项信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = IndicatorVariablesData.class)
    public CommonResult<IndicatorVariablesData> getIndicatorVariablesById(@PathVariable("id") @ApiParam(value = "评价指标项id", required = true) long id) {
        IndicatorVariablesData indicatorvariables = indicatorvariablesService.getIndicatorVariablesById(id);
        if (indicatorvariables == null) {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"无记录");
        }
        return new CommonResult<>( HttpStatus.OK.value(),"查询成功",indicatorvariables);
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加评价指标项", httpMethod = "POST", value = "添加评价指标项", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = IndicatorVariablesData.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 404, message = "添加失败")})
    public CommonResult<IndicatorVariablesData> createIndicatorVariables(@RequestBody IndicatorVariablesData indicatorvariables) {
         if (indicatorvariablesService.addIndicatorVariables(indicatorvariables)){
             return new CommonResult<>( HttpStatus.CREATED.value(),"添加成功",indicatorvariables);
         }else {
             return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"添加失败");
         }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "更新评价指标项信息", httpMethod = "PUT", value = "更新评价指标项", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "更新成功", response = IndicatorVariablesData.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 404, message = "更新失败")})
    public CommonResult<IndicatorVariablesData> updateIndicatorVariables(@PathVariable("id") long id, @RequestBody IndicatorVariablesData indicatorvariables) {
          IndicatorVariablesData currentindicatorvariables = indicatorvariablesService.getIndicatorVariablesById(id);

        if (currentindicatorvariables==null) {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"无记录");
        }

          if (indicatorvariablesService.updateIndicatorVariables( indicatorvariables)){
              return new CommonResult<>( HttpStatus.OK.value(),"更新成功",indicatorvariables);
          }else {
              return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"更新失败");
          }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "删除评价指标项信息", httpMethod = "DELETE", value = "删除评价指标项", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
                        @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
                        @ApiResponse(code = 404, message = "删除失败")})
    public CommonResult<Void> deleteIndicatorVariables(@PathVariable("id") @ApiParam(value = "评价指标项id", required = true)long id) {
        if (indicatorvariablesService.delIndicatorVariablesById(id)){
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
        int  cont = indicatorvariablesService.batchDeleteInfo(infos);
        if(cont < 0){
            return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"删除失败");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"删除成功");
    }

    @RequestMapping(value = "/dt", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "获取评价指标项数据类型", httpMethod = "GET", value = "获取评价指标项数据类型", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = Map.class)
    public CommonResult<Map> getIndicatorDataType(){
        Map<String,String> map = new HashMap<>();
        map.put("nv","数字");
        map.put("ss","单选");
        map.put("ms","多选");
        map.put("ti","文本输入");
        return new CommonResult<>(HttpStatus.OK.value(),"成功",map);
    }

    @RequestMapping(value = "/eot", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "标准适用范围分类", httpMethod = "GET", value = "标准适用范围分类", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = Map.class)
    public CommonResult<Map> getEvaluationType(){
        Map<String,String> map = new HashMap<>();
        map.put("faf","香糖料");
        map.put("tm","原料");
        map.put("fp","成品");
        return new CommonResult<>(HttpStatus.OK.value(),"成功",map);
    }
}
