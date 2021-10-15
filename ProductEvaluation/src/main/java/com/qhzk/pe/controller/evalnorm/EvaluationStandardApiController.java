package com.qhzk.pe.controller.evalnorm;

import com.qhzk.pe.common.CommonResult;
import com.qhzk.pe.data.DictionaryData;
import com.qhzk.pe.data.EvaluationStandardData;
import com.qhzk.pe.service.DictionaryService;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.EvaluationStandardService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 评价标准控制器类，评价标准资源管理
 * @author: Mr.Muxl
 * @date 2021-06-29
 */
@RestController
@RequestMapping("/evaluationstandard")
@Api(value = "/evaluationstandard", description = "评价标准")
public class EvaluationStandardApiController {

    @Resource
    private EvaluationStandardService evaluationstandardService;
    @Resource
    private DictionaryService dictionaryService;

    @RequestMapping(value = "/queryPageInfo/{pageno}",method = RequestMethod.POST)
    @ApiOperation(notes = "评价标准分页", httpMethod = "POST", value = "评价标准分页列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = EvaluationStandardData.class)
    public CommonResult<PageInfo<EvaluationStandardData>> queryPageInfo(@PathVariable("pageno") @ApiParam(value = "页码", required = true) int pageno,@RequestBody EvaluationStandardData  evaluationstandard) {
    PageInfo page = new PageInfo<EvaluationStandardData>();
        page.setPageNo(pageno);
        page.setPageSize(15);
        PageInfo<EvaluationStandardData> pageInfo= evaluationstandardService.queryPageInfo(page, evaluationstandard);
        if(null == pageInfo ||pageInfo.getDates().isEmpty()){
            return new CommonResult<>(HttpStatus.NO_CONTENT.value(),"无记录");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"查询成功",pageInfo);
    }
     @RequestMapping(value = "/getAllevaluationstandards",method = RequestMethod.POST)
     @ApiOperation(notes = "评价标准列表", httpMethod = "POST", value = "评价标准列表")
     @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
     @ApiResponse(code = 200, message = "获取成功", response = EvaluationStandardData.class)
     public CommonResult<List<EvaluationStandardData>> getAllEvaluationStandards(@RequestBody EvaluationStandardData evaluationstandard) {
          List<EvaluationStandardData> datas= evaluationstandardService.getAllEvaluationStandards(evaluationstandard);
         if(null == datas ||datas.isEmpty()){
             return new CommonResult<>(HttpStatus.NO_CONTENT.value(),"无记录");
         }
         return new CommonResult<>(HttpStatus.OK.value(),"查询成功",datas);
     }

    @RequestMapping(value = "/getEvaluationStandardById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据id获取评价标准信息", httpMethod = "GET", value = "根据id获取评价标准信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = EvaluationStandardData.class)
    public CommonResult<EvaluationStandardData> getEvaluationStandardById(@PathVariable("id") @ApiParam(value = "评价标准id", required = true) long id) {
        EvaluationStandardData evaluationstandard = evaluationstandardService.getEvaluationStandardById(id);
        if (evaluationstandard == null) {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"无记录");
        }
        return new CommonResult<>( HttpStatus.OK.value(),"查询成功",evaluationstandard);
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加评价标准", httpMethod = "POST", value = "添加评价标准", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = EvaluationStandardData.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 404, message = "添加失败")})
    public CommonResult<EvaluationStandardData> createEvaluationStandard(@RequestBody EvaluationStandardData evaluationstandard) {
         if (evaluationstandardService.addEvaluationStandard(evaluationstandard)){
             return new CommonResult<>( HttpStatus.CREATED.value(),"添加成功",evaluationstandard);
         }else {
             return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"添加失败");
         }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "更新评价标准信息", httpMethod = "PUT", value = "更新评价标准", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "更新成功", response = EvaluationStandardData.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 404, message = "更新失败")})
    public CommonResult<EvaluationStandardData> updateEvaluationStandard(@PathVariable("id") long id, @RequestBody EvaluationStandardData evaluationstandard) {
          EvaluationStandardData currentevaluationstandard = evaluationstandardService.getEvaluationStandardById(id);

        if (currentevaluationstandard==null) {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"无记录");
        }

          if (evaluationstandardService.updateEvaluationStandard( evaluationstandard)){
              return new CommonResult<>( HttpStatus.OK.value(),"更新成功",evaluationstandard);
          }else {
              return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"更新失败");
          }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "删除评价标准信息", httpMethod = "DELETE", value = "删除评价标准", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
                        @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
                        @ApiResponse(code = 404, message = "删除失败")})
    public CommonResult<Void> deleteEvaluationStandard(@PathVariable("id") @ApiParam(value = "评价标准id", required = true)long id) {
        if (evaluationstandardService.delEvaluationStandardById(id)){
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
        int  cont = evaluationstandardService.batchDeleteInfo(infos);
        if(cont < 0){
            return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"删除失败");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"删除成功");
    }

    @RequestMapping(value = "/getevaluationstandardtype", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "标准分类", httpMethod = "GET", value = "标准分类", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = Map.class)
    public CommonResult<Map> getEvaluationStandardType(){
        Map<String,String> map = new HashMap<>();
        map.put("nas","国家标准");
        map.put("ins","行业标准");
        map.put("cos","企业标准");
        map.put("prs","生产标准");
        map.put("cus","自定义标准");
        return new CommonResult<>(HttpStatus.OK.value(),"成功",map);
    }

    @RequestMapping(value = "/getevaluationobjectstype", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "标准对象分类", httpMethod = "GET", value = "标准对象分类", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = Map.class)
    public CommonResult<Map> getEvaluationObjectsType(){
        Map<String,String> map = new HashMap<>();
        List<String> pcodes  = new ArrayList<>();
        pcodes.add("faf");
        pcodes.add("tm");
        pcodes.add("fp");
        List<DictionaryData> ds = dictionaryService.getEvaluatScopes(pcodes);
        if(null != ds && !ds.isEmpty()){
            for (DictionaryData e:ds) {
                map.put(e.getDiccode(),e.getDicname());
            }
        }
        map.put("faf","香糖料");
        map.put("tm","原料");
        map.put("fp","成品");
        return new CommonResult<>(HttpStatus.OK.value(),"成功",map);
    }

    @RequestMapping(value = "/getevaluationmodeltype", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "标准模型分类", httpMethod = "GET", value = "标准模型分类", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = Map.class)
    public CommonResult<Map> getEvaluationModelType(){
        Map<String,String> map = new HashMap<>();
        map.put("sp","单人模式");
        map.put("sm","共享模式");
        map.put("mm","会议模式");
        return new CommonResult<>(HttpStatus.OK.value(),"成功",map);
    }

    @RequestMapping(value = "/getevaluationmethodologytype", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "标准模型分类", httpMethod = "GET", value = "标准模型分类", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = Map.class)
    public CommonResult<Map> getEvaluationMethodologyType(){
        Map<String,String> map = new HashMap<>();
        map.put("ds","直接打分");
        map.put("cs","对比评吸");
        map.put("ts","三角评吸");
        map.put("ss","排序评吸");
        return new CommonResult<>(HttpStatus.OK.value(),"成功",map);
    }

    @RequestMapping(value = "/getEvalstandardByMeanAndScope", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据评价对象、方法获取标准", httpMethod = "POST", value = "根据评价对象、方法获取标准", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = EvaluationStandardData.class)
    public CommonResult< List<EvaluationStandardData>> getEvalstandardByMeanAndScope(
            @RequestParam @ApiParam(value = "评价方法code", required = true) String mean,
            @RequestParam @ApiParam(value = "评价对象code", required = true)  String scope
    ) {

        List<EvaluationStandardData>  taskdatas= evaluationstandardService.getEvalstandardByMeanAndScope(mean,scope);

        if (null == taskdatas || taskdatas.isEmpty()) {
            return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"无记录");
        }

        return new CommonResult<>(HttpStatus.OK.value(),"成功",taskdatas);
    }
}
