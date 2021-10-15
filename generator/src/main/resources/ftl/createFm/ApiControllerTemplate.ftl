package com.qhzk.pe.controller.${objectNameLower};

import com.qhzk.pe.common.CommonResult;
import com.qhzk.pe.data.${objectName}Data;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.entities.${objectName};
import com.qhzk.pe.service.${objectName}Service;
import io.swagger.annotations.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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

    @RequestMapping(value = "/queryPageInfo/{pageno}",method = RequestMethod.POST)
    @ApiOperation(notes = "${title}分页", httpMethod = "POST", value = "${title}分页列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = ${objectName}Data.class)
    public CommonResult<PageInfo<${objectName}Data>> queryPageInfo(@PathVariable("pageno") @ApiParam(value = "页码", required = true) int pageno,@RequestBody ${objectName}Data  ${objectNameLower}) {
    PageInfo page = new PageInfo<${objectName}Data>();
        page.setPageNo(pageno);
        page.setPageSize(15);
        PageInfo<${objectName}Data> pageInfo= ${objectNameLower}Service.queryPageInfo(page, ${objectNameLower});
        if(null == pageInfo ||pageInfo.getDates().isEmpty()){
            return new CommonResult<>(HttpStatus.NO_CONTENT.value(),"无记录");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"查询成功",pageInfo);
    }
     @RequestMapping(value = "/getAll${objectNameLower}s",method = RequestMethod.POST)
     @ApiOperation(notes = "${title}列表", httpMethod = "POST", value = "${title}列表")
     @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
     @ApiResponse(code = 200, message = "获取成功", response = ${objectName}Data.class)
     public CommonResult<List<${objectName}Data>> getAll${objectName}s(@RequestBody ${objectName}Data ${objectNameLower}) {
          List<${objectName}Data> datas= ${objectNameLower}Service.getAll${objectName}s(${objectNameLower});
          if(null == datas ||datas.isEmpty()){
               return new CommonResult<>(HttpStatus.NO_CONTENT.value(),"无记录");
          }
          return new CommonResult<>(HttpStatus.OK.value(),"查询成功",datas);
     }

    @RequestMapping(value = "/get${objectName}ById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据id获取${title}信息", httpMethod = "GET", value = "根据id获取${title}信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = ${objectName}Data.class)
    public CommonResult<${objectName}Data> get${objectName}ById(@PathVariable("id") @ApiParam(value = "${title}id", required = true) long id) {
        ${objectName}Data ${objectNameLower} = ${objectNameLower}Service.get${objectName}ById(id);
        if (${objectNameLower} == null) {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"无记录");
        }
        return new CommonResult<>( HttpStatus.OK.value(),"查询成功",${objectNameLower});
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加${title}", httpMethod = "POST", value = "添加${title}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = ${objectName}Data.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 400, message = "添加失败")})
    public CommonResult<${objectName}Data> create${objectName}(@RequestBody ${objectName}Data ${objectNameLower}) {
         if (${objectNameLower}Service.add${objectName}(${objectNameLower})){
              return new CommonResult<>( HttpStatus.CREATED.value(),"添加成功",${objectNameLower});
         }else {
              return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"添加失败");
         }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "更新${title}信息", httpMethod = "PUT", value = "更新${title}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "更新成功", response = ${objectName}Data.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 400, message = "更新失败")})
    public CommonResult<${objectName}Data> update${objectName}(@PathVariable("id") long id, @RequestBody ${objectName}Data ${objectNameLower}) {
          ${objectName}Data current${objectNameLower} = ${objectNameLower}Service.get${objectName}ById(id);

          if (current${objectNameLower}==null) {
              return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"无记录");
          }

          if (${objectNameLower}Service.update${objectName}( ${objectNameLower})){
              return new CommonResult<>( HttpStatus.OK.value(),"更新成功",${objectNameLower});
          }else {
              return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"更新失败");
          }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "逻辑删除${title}信息", httpMethod = "DELETE", value = "逻辑删除${title}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
                        @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
                        @ApiResponse(code = 400, message = "删除失败")})
    public CommonResult<Object> delete${objectName}(@PathVariable("id") @ApiParam(value = "${title}id", required = true)long id) {
        if (${objectNameLower}Service.del${objectName}ById(id)){
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
        int  cont = ${objectNameLower}Service.batchDeleteInfo(infos);
        if(cont < 0){
            return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"删除失败");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"删除成功");
    }
}
