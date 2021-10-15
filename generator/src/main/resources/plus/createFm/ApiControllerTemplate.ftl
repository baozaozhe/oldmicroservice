package com.qhzk.as.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qhzk.as.common.BusinessException;
import com.qhzk.as.common.CommonResult;
import com.qhzk.as.common.SnowflakeIdWorker;
import com.qhzk.as.entity.${objectName};
import com.qhzk.as.service.${objectName}Service;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * ${title}控制器类，${title}资源管理
 * @author: Mr.Muxl
 * @date ${nowDate?string("yyyy-MM-dd")}
 */
@RestController
@RequestMapping("/${objectNameLower}")
@Api(value = "/${objectNameLower}", description = "${title}")
public class ${objectName}ApiController {

    @Resource
    private ${objectName}Service ${objectNameLower}Service;

    @RequestMapping(value = "/queryPageInfo",method = RequestMethod.POST)
    @ApiOperation(notes = "${title}分页", httpMethod = "POST", value = "${title}分页列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = ${objectName}.class)
    public CommonResult<IPage<${objectName}>> queryPageInfo(
                @RequestParam (value = "pageno",required = true) @ApiParam(value = "pageno", required = true) int pageno,
                @RequestParam (value = "size",required = true)  @ApiParam(value = "size", required = true) int size,
                @RequestBody ${objectName}  ${objectNameLower}) {

        Page page = new Page<${objectName}>();
        page.setCurrent(pageno);
        page.setSize(15);

        QueryWrapper<${objectName}> wrapper = new QueryWrapper<>();
        wrapper.setEntity(${objectNameLower});

        IPage<${objectName}> pageinfo= ${objectNameLower}Service.page(page,wrapper);

        if(null == pageinfo.getRecords() ||pageinfo.getRecords().isEmpty()){
             return CommonResult.ofNotRecord();
        }
         return CommonResult.ofSuccess(pageinfo);
    }


     @RequestMapping(value = "/getAll${objectName}s",method = RequestMethod.POST)
     @ApiOperation(notes = "${title}列表", httpMethod = "POST", value = "${title}列表")
     @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
     @ApiResponse(code = 200, message = "获取成功", response = ${objectName}.class)
     public CommonResult<List<${objectName}>> getAllUsers(@RequestBody ${objectName} ${objectNameLower}) {
        QueryWrapper<${objectName}> wrapper = new QueryWrapper<>();
        wrapper.setEntity(${objectNameLower});
        List<${objectName}> list = ${objectNameLower}Service.list(wrapper);
        if(null == list ||list.isEmpty()){
            return CommonResult.ofNotRecord();
        }
        return  CommonResult.ofSuccess(list);
    }

    @RequestMapping(value = "/get${objectName}ById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据id获取${title}信息", httpMethod = "GET", value = "根据id获取${title}信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = ${objectName}.class)
    public CommonResult<${objectName}> get${objectName}ById(@PathVariable("id") @ApiParam(value = "${title}id", required = true) long id) {
        ${objectName} ${objectNameLower} = ${objectNameLower}Service.getById(id);
        if (${objectNameLower} == null) {
            return CommonResult.ofNotRecord();
        }
        return CommonResult.ofSuccess(${objectNameLower});
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加${title}", httpMethod = "POST", value = "添加${title}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = ${objectName}.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 400, message = "添加失败")})
    public CommonResult<${objectName}> create${objectName}(@RequestBody ${objectName} ${objectNameLower}) {
        ${objectNameLower}.setId(SnowflakeIdWorker.generateId());
        if (${objectNameLower}Service.save(${objectNameLower})){
            return CommonResult.ofSuccessCreate(${objectNameLower});
        }else {
            return CommonResult.ofFail("添加失败");
        }
    }
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "更新${title}信息", httpMethod = "PUT", value = "更新${title}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "更新成功", response = ${objectName}.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 400, message = "更新失败")})
    public CommonResult<${objectName}> update${objectName}(@RequestBody ${objectName} ${objectNameLower}) {
        ${objectName} curr${objectNameLower} = ${objectNameLower}Service.getById(${objectNameLower}.getId());

        if (curr${objectNameLower} == null) {
            return CommonResult.ofNotRecord();
        }

        if (${objectNameLower}Service.updateById(${objectNameLower})){
            return CommonResult.ofSuccess(${objectNameLower});
        }else {
            return CommonResult.ofFail();
        }
    }

    @RequestMapping(value = "/del/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "逻辑删除${title}信息", httpMethod = "DELETE", value = "逻辑删除${title}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
                        @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
                        @ApiResponse(code = 400, message = "删除失败")})
    public CommonResult<Object> delete${objectName}(@PathVariable("id") @ApiParam(value = "${title}id", required = true)long id) {
        if (${objectNameLower}Service.removeById(id)){
            return CommonResult.ofSuccess(id);
        }else {
            return CommonResult.ofFail();
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
            return CommonResult.parameterError(infos);
        }
        boolean b = ${objectNameLower}Service.removeByIds(infos);
        if(!b){
            return CommonResult.ofFail();
        }
        return CommonResult.ofSuccess();
    }
}
