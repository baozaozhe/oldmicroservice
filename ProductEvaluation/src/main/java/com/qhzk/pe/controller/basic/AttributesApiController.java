package com.qhzk.pe.controller.basic;

import com.qhzk.pe.common.CommonResult;
import com.qhzk.pe.data.AttributesData;
import com.qhzk.pe.service.AttributesService;
import com.qhzk.pe.utils.PageInfo;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 扩展属性管理管理控制器类，扩展属性管理管理资源管理
 * @author: Mr.Muxl
 * @date 2021-06-30
 */
@RestController
@RequestMapping("/attributes")
@Api(value = "/attributes", description = "扩展属性管理")
@Slf4j
public class AttributesApiController {

    @Resource
    private AttributesService attributesService;

    @RequestMapping(value = "/queryPageInfo/{pageno}",method = RequestMethod.POST)
    @ApiOperation(notes = "扩展属性分页", httpMethod = "POST", value = "扩展属性分页列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = AttributesData.class)
    public CommonResult<PageInfo<AttributesData>> queryPageInfo(@PathVariable("pageno") @ApiParam(value = "页码", required = true) int pageno,@RequestBody AttributesData  attributes) {
        PageInfo page = new PageInfo<AttributesData>();
        page.setPageNo(pageno);
        page.setPageSize(15);
        PageInfo<AttributesData> pageInfo= attributesService.queryPageInfo(page, attributes);
        if(null == pageInfo ||pageInfo.getDates().isEmpty()){
            return new CommonResult<>(HttpStatus.NO_CONTENT.value(),"无记录");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"查询成功",pageInfo);
    }
    @RequestMapping(value = "/getAllattributess",method = RequestMethod.POST)
    @ApiOperation(notes = "扩展属性列表", httpMethod = "POST", value = "扩展属性列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = AttributesData.class)
    public CommonResult<List<AttributesData>> getAllAttributess(@RequestBody AttributesData attributes) {
        log.info("扩展属性列表");
        List<AttributesData> datas= attributesService.getAllAttributess(attributes);
        if(null == datas ||datas.isEmpty()){
            return new CommonResult<>(HttpStatus.NO_CONTENT.value(),"无记录");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"查询成功",datas);
    }

    @RequestMapping(value = "/getAttributesById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据id获取扩展属性信息", httpMethod = "GET", value = "根据id获取扩展属性信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = AttributesData.class)
    public CommonResult<AttributesData> getAttributesById(@PathVariable("id") @ApiParam(value = "扩展属性id", required = true) long id) {
        AttributesData attributes = attributesService.getAttributesById(id);
        if (attributes == null) {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"无记录");
        }
        return new CommonResult<>( HttpStatus.OK.value(),"查询成功",attributes);
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加扩展属性", httpMethod = "POST", value = "添加扩展属性", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = AttributesData.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "添加失败")})
    public CommonResult<AttributesData> createAttributes(@RequestBody AttributesData attributes) {
        if (attributesService.addAttributes(attributes)){
            return new CommonResult<>( HttpStatus.CREATED.value(),"添加成功",attributes);
        }else {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"添加失败");
        }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "更新扩展属性信息", httpMethod = "PUT", value = "更新扩展属性", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "更新成功", response = AttributesData.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "更新失败")})
    public CommonResult<AttributesData> updateAttributes(@PathVariable("id") long id, @RequestBody AttributesData attributes) {
        AttributesData currentattributes = attributesService.getAttributesById(id);

        if (currentattributes==null) {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"无记录");
        }

        if (attributesService.updateAttributes( attributes)){
            return new CommonResult<>( HttpStatus.OK.value(),"更新成功",attributes);
        }else {
            return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"更新失败");
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "逻辑删除扩展属性信息", httpMethod = "DELETE", value = "逻辑删除扩展属性", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "删除失败")})
    public CommonResult<Object> deleteAttributes(@PathVariable("id") @ApiParam(value = "扩展属性id", required = true)long id) {
        if (attributesService.delAttributesById(id)){
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
        int  cont = attributesService.batchDeleteInfo(infos);
        if(cont < 0){
            return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"删除失败");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"删除成功");
    }
    @RequestMapping(value = "/getfuncextenstype", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "功能扩展属性分类", httpMethod = "GET", value = "功能扩展属性分类", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = Map.class)
    public CommonResult<Map> getFuncextEnstype(){
        Map<String,String> map = new HashMap<>();
        map.put("fs","香精香料样品管理");
        return new CommonResult<>(HttpStatus.OK.value(),"请求成功",map);
    }

    @RequestMapping(value = "/getAttributesIndicator", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "获取显示控件类型combox数据", httpMethod = "GET", value = "获取显示控件类型combox数据", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = Map.class)
    public CommonResult<Map> getAttributesIndicator(){
        Map<String,String> map = new HashMap<>();
        map.put("1","文本框");
        map.put("2","文本域");
        return new CommonResult<>(HttpStatus.OK.value(),"请求成功",map);
    }

    @RequestMapping(value = "/getAttributesDataType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "数据数据类型", httpMethod = "GET", value = "数据数据类型", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = Map.class)
    public CommonResult<Map> getAttributesDataType(){
        Map<String,String> map = new HashMap<>();
        map.put("string","string");
        map.put("int","int");
        map.put("boolean","boolean");
        map.put("double","double");
        map.put("float","float");
        return new CommonResult<>(HttpStatus.OK.value(),"请求成功",map);
    }

}
