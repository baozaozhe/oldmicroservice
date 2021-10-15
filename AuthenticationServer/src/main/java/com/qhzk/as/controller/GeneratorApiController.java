package com.qhzk.as.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qhzk.as.common.CommonResult;
import com.qhzk.as.entity.ColumnInfo;
import com.qhzk.as.entity.GenConfig;
import com.qhzk.as.entity.Tables;
import com.qhzk.as.exception.BadRequestException;
import com.qhzk.as.service.ColumnInfoService;
import com.qhzk.as.service.FileInfoService;
import com.qhzk.as.service.GenConfigService;
import com.qhzk.as.service.GeneratorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @description: 代码生成管理
 * @author: Mr.Muxl
 * @create: 2021-08-26 16:02
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/generator")
@Api(tags = "系统：代码生成管理")
public class GeneratorApiController {
    @Resource
    private GeneratorService generatorService;
    @Resource
    private ColumnInfoService columninfoService;
    @Resource
    private GenConfigService genconfigService;

    @ApiOperation("查询数据库数据")
    @GetMapping(value = "/tables")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    public CommonResult<List<Tables>> queryTables(@RequestParam(defaultValue = "") String name){
        List<Tables> tables = generatorService.getTables(name);
        if(null ==tables || tables.isEmpty()){
            return CommonResult.ofNotRecord();
        }
        return CommonResult.ofSuccess(tables);
    }


    @ApiOperation("查询字段数据")
    @GetMapping(value = "/columns")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    public CommonResult< List<ColumnInfo>> queryColumns(@RequestParam String tableName){
        ColumnInfo cl = new ColumnInfo();
        cl.setTableName(tableName);
        QueryWrapper<ColumnInfo> wrapper = new QueryWrapper<>();
        wrapper.setEntity(cl);
        List<ColumnInfo> columnInfos = columninfoService.list(wrapper);
        if(null == columnInfos || columnInfos.isEmpty()){
            columnInfos = generatorService.queryColumnInfos(tableName);
        }
        return CommonResult.ofSuccess(columnInfos);
    }

    @ApiOperation("保存字段数据")
    @PutMapping
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    public CommonResult<Void> save(@RequestBody List<ColumnInfo> columnInfos){
       boolean b = columninfoService.saveBatch(columnInfos);
       if(b){
           return  CommonResult.ofSuccess();
       }
        return CommonResult.ofFail();
    }

    @ApiOperation("同步字段数据")
    @PostMapping(value = "sync")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    public ResponseEntity<HttpStatus> sync(@RequestBody List<String> tables){
        for (String table : tables) {
            ColumnInfo cl = new ColumnInfo();
            cl.setTableName(table);
            QueryWrapper<ColumnInfo> wrapper = new QueryWrapper<>();
            wrapper.setEntity(cl);
            List<ColumnInfo> columnInfos = columninfoService.list(wrapper);
            if(null == columnInfos || columnInfos.isEmpty()){
                columnInfos = generatorService.queryColumnInfos(table);
            }
            List<ColumnInfo> columnInfoList = generatorService.queryColumnInfos(table);

            generatorService.sync(columnInfos, columnInfoList);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation("生成代码")
    @PostMapping(value = "/{tableName}/{type}")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    public ResponseEntity<Object> generator(@PathVariable String tableName, @PathVariable Integer type, HttpServletRequest request, HttpServletResponse response){
        if(type == 0){
            throw new BadRequestException("此环境不允许生成代码，请选择预览或者下载查看！");
        }
        GenConfig qu = new GenConfig();
        qu.setTableName(tableName);
        //表信息
        QueryWrapper<GenConfig> wrapper = new QueryWrapper<>();
        wrapper.setEntity(qu);

        GenConfig one = genconfigService.getOne(wrapper);
        if(null == one){
            one =new GenConfig();
            one.setTableName(tableName);
        }
        //表字段
        ColumnInfo cl = new ColumnInfo();
        cl.setTableName(tableName);
        QueryWrapper<ColumnInfo> colwrapper = new QueryWrapper<>();
        colwrapper.setEntity(cl);
        List<ColumnInfo> columnInfos = columninfoService.list(colwrapper);
        if(null == columnInfos || columnInfos.isEmpty()){
            columnInfos = generatorService.queryColumnInfos(tableName);
        }

        switch (type){
            // 生成代码
            case 0: generatorService.generator(one, columnInfos);
                break;
            // 预览
            case 1: return generatorService.preview(one,columnInfos);
            // 打包
            case 2: generatorService.download(one, columnInfos,request,response);
                break;
            default: throw new BadRequestException("没有这个选项");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
