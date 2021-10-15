package com.qhzk.as.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qhzk.as.common.BusinessException;
import com.qhzk.as.common.CommonResult;
import com.qhzk.as.common.SnowflakeIdWorker;
import com.qhzk.as.entity.GenConfig;
import com.qhzk.as.service.GenConfigService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 代码生成配置控制器类，代码生成配置资源管理
 * @author: Mr.Muxl
 * @date 2021-08-29
 */
@RestController
@RequestMapping("/genconfig")
@Api(value = "/genconfig", description = "代码生成配置")
public class GenConfigApiController {

    @Resource
    private GenConfigService genconfigService;
    @ApiOperation("查询")
    @GetMapping(value = "/{tableName}")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    public CommonResult<GenConfig> query(@PathVariable String tableName){

        GenConfig qu = new GenConfig();
        qu.setTableName(tableName);

        QueryWrapper<GenConfig> wrapper = new QueryWrapper<>();
        wrapper.setEntity(qu);

        GenConfig one = genconfigService.getOne(wrapper);
        if(null == one){
            one =new GenConfig();
            one.setTableName(tableName);
        }

        return CommonResult.ofSuccess(one);
    }

    @ApiOperation("修改")
    @PutMapping
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    public CommonResult<Object> update(@Validated @RequestBody GenConfig genConfig){
        GenConfig qu = new GenConfig();
        qu.setTableName(genConfig.getTableName());

        QueryWrapper<GenConfig> wrapper = new QueryWrapper<>();
        wrapper.setEntity(qu);

        if(genconfigService.update(genConfig, wrapper)){
            return CommonResult.ofSuccess();
        }else {
            return CommonResult.ofFail();
        }
    }
}
