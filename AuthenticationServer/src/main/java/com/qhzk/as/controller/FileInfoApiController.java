package com.qhzk.as.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qhzk.as.common.BusinessException;
import com.qhzk.as.common.CommonResult;
import com.qhzk.as.common.SnowflakeIdWorker;
import com.qhzk.as.entity.FileInfo;
import com.qhzk.as.service.FileInfoService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文件信息控制器类，文件信息资源管理
 * @author: Mr.Muxl
 * @date 2021-08-05
 */
@RestController
@RequestMapping("/fileinfo")
@Api(value = "/fileinfo", description = "文件信息")
public class FileInfoApiController {

    @Resource
    private FileInfoService fileinfoService;

    @RequestMapping(value = "/queryPageInfo",method = RequestMethod.POST)
    @ApiOperation(notes = "文件信息分页", httpMethod = "POST", value = "文件信息分页列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = FileInfo.class)
    public CommonResult<IPage<FileInfo>> queryPageInfo(
                @RequestParam (value = "pageno",required = true) @ApiParam(value = "pageno", required = true) int pageno,
                @RequestParam (value = "size",required = true)  @ApiParam(value = "size", required = true) int size,
                @RequestBody FileInfo  fileinfo) {

        Page page = new Page<FileInfo>();
        page.setCurrent(pageno);
        page.setSize(15);

        QueryWrapper<FileInfo> wrapper = new QueryWrapper<>();
        wrapper.setEntity(fileinfo);

        IPage<FileInfo> pageinfo= fileinfoService.page(page,wrapper);

        if(null == pageinfo.getRecords() ||pageinfo.getRecords().isEmpty()){
             return CommonResult.ofNotRecord();
        }
         return CommonResult.ofSuccess(pageinfo);
    }


     @RequestMapping(value = "/getAllFileInfos",method = RequestMethod.POST)
     @ApiOperation(notes = "文件信息列表", httpMethod = "POST", value = "文件信息列表")
     @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
     @ApiResponse(code = 200, message = "获取成功", response = FileInfo.class)
     public CommonResult<List<FileInfo>> getAllUsers(@RequestBody FileInfo fileinfo) {
        QueryWrapper<FileInfo> wrapper = new QueryWrapper<>();
        wrapper.setEntity(fileinfo);
        List<FileInfo> list = fileinfoService.list(wrapper);
        if(null == list ||list.isEmpty()){
            return CommonResult.ofNotRecord();
        }
        return  CommonResult.ofSuccess(list);
    }

    @RequestMapping(value = "/getFileInfoById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据id获取文件信息信息", httpMethod = "GET", value = "根据id获取文件信息信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = FileInfo.class)
    public CommonResult<FileInfo> getFileInfoById(@PathVariable("id") @ApiParam(value = "文件信息id", required = true) long id) {
        FileInfo fileinfo = fileinfoService.getById(id);
        if (fileinfo == null) {
            return CommonResult.ofNotRecord();
        }
        return CommonResult.ofSuccess(fileinfo);
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加文件信息", httpMethod = "POST", value = "添加文件信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = FileInfo.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 400, message = "添加失败")})
    public CommonResult<FileInfo> createFileInfo(@RequestBody FileInfo fileinfo) {
        fileinfo.setId(SnowflakeIdWorker.generateId());
        if (fileinfoService.save(fileinfo)){
            return CommonResult.ofSuccessCreate(fileinfo);
        }else {
            return CommonResult.ofFail("添加失败");
        }
    }
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "更新文件信息信息", httpMethod = "PUT", value = "更新文件信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "更新成功", response = FileInfo.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 400, message = "更新失败")})
    public CommonResult<FileInfo> updateFileInfo(@RequestBody FileInfo fileinfo) {
        FileInfo currfileinfo = fileinfoService.getById(fileinfo.getId());

        if (currfileinfo == null) {
            return CommonResult.ofNotRecord();
        }

        if (fileinfoService.updateById(fileinfo)){
            return CommonResult.ofSuccess(fileinfo);
        }else {
            return CommonResult.ofFail();
        }
    }

    @RequestMapping(value = "/del/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "逻辑删除文件信息信息", httpMethod = "DELETE", value = "逻辑删除文件信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
                        @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
                        @ApiResponse(code = 400, message = "删除失败")})
    public CommonResult<Object> deleteFileInfo(@PathVariable("id") @ApiParam(value = "文件信息id", required = true)long id) {
        if (fileinfoService.removeById(id)){
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
        boolean b = fileinfoService.removeByIds(infos);
        if(!b){
            return CommonResult.ofFail();
        }
        return CommonResult.ofSuccess();
    }
}
