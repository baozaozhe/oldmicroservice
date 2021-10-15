package com.qhzk.pe.controller.basic;

import com.qhzk.pe.common.CommonResult;
import com.qhzk.pe.data.DictionaryData;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.DictionaryService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 字典管理控制器类，字典管理资源管理
 * @author: Mr.Muxl
 * @date 2021-06-29
 */
@RestController
@RequestMapping("/dictionary")
@Api(value = "/dictionary", description = "字典管理")
public class DictionaryApiController {

    @Resource
    private DictionaryService dictionaryService;

    @RequestMapping(value = "/queryPageInfo/{pageno}",method = RequestMethod.POST)
    @ApiOperation(notes = "字典管理分页", httpMethod = "POST", value = "字典管理分页列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = DictionaryData.class)
    public CommonResult<PageInfo<DictionaryData>> queryPageInfo(@PathVariable("pageno") @ApiParam(value = "页码", required = true) int pageno,@RequestBody DictionaryData  dictionary) {
    PageInfo page = new PageInfo<DictionaryData>();
        page.setPageNo(pageno);
        page.setPageSize(15);
        PageInfo<DictionaryData> pageInfo= dictionaryService.queryPageInfo(page, dictionary);
        if(null == pageInfo ||pageInfo.getDates().isEmpty()){
            return new CommonResult<>(HttpStatus.NO_CONTENT.value(),"无记录");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"查询成功",pageInfo);
    }
     @RequestMapping(value = "/getAlldictionarys",method = RequestMethod.POST)
     @ApiOperation(notes = "字典管理列表", httpMethod = "POST", value = "字典管理列表")
     @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
     @ApiResponse(code = 200, message = "获取成功", response = DictionaryData.class)
     public CommonResult<List<DictionaryData>> getAllDictionarys(@RequestBody DictionaryData dictionary) {
          List<DictionaryData> datas= dictionaryService.getAllDictionarys(dictionary);
         if(null == datas ||datas.isEmpty()){
             return new CommonResult<>(HttpStatus.NO_CONTENT.value(),"无记录");
         }
         return new CommonResult<>(HttpStatus.OK.value(),"查询成功",datas);
     }

    @RequestMapping(value = "/getDictionaryById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据id获取字典管理信息", httpMethod = "GET", value = "根据id获取字典管理信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = DictionaryData.class)
    public CommonResult<DictionaryData> getDictionaryById(@PathVariable("id") @ApiParam(value = "字典管理id", required = true) long id) {
        DictionaryData dictionary = dictionaryService.getDictionaryById(id);
        if (dictionary == null) {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"无记录");
        }
        return new CommonResult<>( HttpStatus.OK.value(),"查询成功",dictionary);
    }
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加字典管理", httpMethod = "POST", value = "添加字典管理", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = DictionaryData.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 400, message = "添加失败")})
    public CommonResult<DictionaryData> createDictionary(@RequestBody DictionaryData dictionary) {
         if (dictionaryService.addDictionary(dictionary)){
             return new CommonResult<>( HttpStatus.CREATED.value(),"添加成功",dictionary);
         }else {
             return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"添加失败");
         }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "更新字典管理信息", httpMethod = "PUT", value = "更新字典管理", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "更新成功", response = DictionaryData.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 400, message = "更新失败")})
    public CommonResult<DictionaryData> updateDictionary(@PathVariable("id") long id, @RequestBody DictionaryData dictionary) {
          DictionaryData currentdictionary = dictionaryService.getDictionaryById(id);

        if (currentdictionary==null) {
            return new CommonResult<>(HttpStatus.NOT_FOUND.value(),"无记录");
        }

          if (dictionaryService.updateDictionary( dictionary)){
              return new CommonResult<>( HttpStatus.OK.value(),"更新成功",dictionary);
          }else {
              return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"更新失败");
          }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "删除字典管理信息", httpMethod = "DELETE", value = "删除字典管理", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
                        @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
                        @ApiResponse(code = 400, message = "删除失败")})
    public CommonResult<Object> deleteDictionary(@PathVariable("id") @ApiParam(value = "字典管理id", required = true)long id) {
        if (dictionaryService.delDictionaryById(id)){
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

        int  cont = dictionaryService.batchDeleteInfo(infos);

        if(cont < 0){
            return new CommonResult<>(HttpStatus.BAD_REQUEST.value(),"删除失败");
        }
        return new CommonResult<>(HttpStatus.OK.value(),"删除成功");
    }
}
