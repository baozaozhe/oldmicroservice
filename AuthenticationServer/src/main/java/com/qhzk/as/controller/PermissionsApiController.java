package com.qhzk.as.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qhzk.as.common.BusinessException;
import com.qhzk.as.common.CommonResult;
import com.qhzk.as.common.SnowflakeIdWorker;
import com.qhzk.as.entity.*;
import com.qhzk.as.service.*;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限信息控制器类，权限信息资源管理
 * @author: Mr.Muxl
 * @date 2021-08-05
 */
@RestController
@RequestMapping("/permissions")
@Api(value = "/permissions", description = "权限信息")
public class PermissionsApiController {

    @Resource
    private PermissionsService permissionsService;
    @Resource
    private PermissPelementService permisspelementService;
    @Resource
    private PermissionMenuService permissionmenuService;
    @Resource
    private PermissFileService permissfileService;
    @Resource
    private PermissOperateService permissoperateService;

    @RequestMapping(value = "/queryPageInfo",method = RequestMethod.POST)
    @ApiOperation(notes = "权限信息分页", httpMethod = "POST", value = "权限信息分页列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = Permissions.class)
    public CommonResult<IPage<Permissions>> queryPageInfo(
                @RequestParam (value = "pageno",required = true) @ApiParam(value = "pageno", required = true) int pageno,
                @RequestParam (value = "size",required = true)  @ApiParam(value = "size", required = true) int size,
                @RequestBody Permissions  permissions) {

        Page page = new Page<Permissions>();
        page.setCurrent(pageno);
        page.setSize(15);

        QueryWrapper<Permissions> wrapper = new QueryWrapper<>();
        wrapper.setEntity(permissions);

        IPage<Permissions> pageinfo= permissionsService.page(page,wrapper);

        if(null == pageinfo.getRecords() ||pageinfo.getRecords().isEmpty()){
             return CommonResult.ofNotRecord();
        }
         return CommonResult.ofSuccess(pageinfo);
    }


     @RequestMapping(value = "/getAllPermissionss",method = RequestMethod.POST)
     @ApiOperation(notes = "权限信息列表", httpMethod = "POST", value = "权限信息列表")
     @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
     @ApiResponse(code = 200, message = "获取成功", response = Permissions.class)
     public CommonResult<List<Permissions>> getAllUsers(@RequestBody Permissions permissions) {
        QueryWrapper<Permissions> wrapper = new QueryWrapper<>();
        wrapper.setEntity(permissions);
        List<Permissions> list = permissionsService.list(wrapper);
        if(null == list ||list.isEmpty()){
            return CommonResult.ofNotRecord();
        }
        return  CommonResult.ofSuccess(list);
    }

    @RequestMapping(value = "/getPermissionsById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据id获取权限信息信息", httpMethod = "GET", value = "根据id获取权限信息信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = Permissions.class)
    public CommonResult<Permissions> getPermissionsById(@PathVariable("id") @ApiParam(value = "权限信息id", required = true) long id) {
        Permissions permissions = permissionsService.getById(id);
        if (permissions == null) {
            return CommonResult.ofNotRecord();
        }
        return CommonResult.ofSuccess(permissions);
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加权限信息", httpMethod = "POST", value = "添加权限信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = Permissions.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 400, message = "添加失败")})
    public CommonResult<Permissions> createPermissions(@RequestBody Permissions permissions) {
        permissions.setId(SnowflakeIdWorker.generateId());
        if (permissionsService.save(permissions)){
            return CommonResult.ofSuccessCreate(permissions);
        }else {
            return CommonResult.ofFail("添加失败");
        }
    }
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "更新权限信息信息", httpMethod = "PUT", value = "更新权限信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "更新成功", response = Permissions.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 400, message = "更新失败")})
    public CommonResult<Permissions> updatePermissions(@RequestBody Permissions permissions) {
        Permissions currpermissions = permissionsService.getById(permissions.getId());

        if (currpermissions == null) {
            return CommonResult.ofNotRecord();
        }

        if (permissionsService.updateById(permissions)){
            return CommonResult.ofSuccess(permissions);
        }else {
            return CommonResult.ofFail();
        }
    }

    @RequestMapping(value = "/del/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "逻辑删除权限信息信息", httpMethod = "DELETE", value = "逻辑删除权限信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
                        @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
                        @ApiResponse(code = 400, message = "删除失败")})
    public CommonResult<Object> deletePermissions(@PathVariable("id") @ApiParam(value = "权限信息id", required = true)long id) {
        if (permissionsService.removeById(id)){
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
        boolean b = permissionsService.removeByIds(infos);
        if(!b){
            return CommonResult.ofFail();
        }
        return CommonResult.ofSuccess();
    }

    @RequestMapping(value = "/addPermissPelement",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "向权限添加页面元素信息", httpMethod = "POST", value = "向权限添加页面元素信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = PermissPelement.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "添加失败")})
    public CommonResult<PermissPelement> addPermissPelement(@RequestBody PermissPelement permisspelement) {
        permisspelement.setId(SnowflakeIdWorker.generateId());
        if (permisspelementService.save(permisspelement)){
            return CommonResult.ofSuccessCreate(permisspelement);
        }else {
            return CommonResult.ofFail("添加失败");
        }
    }

    @RequestMapping(value = "/delPermissPelement/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "逻辑删除权限的页面元素信息", httpMethod = "DELETE", value = "逻辑删除权限的页面元素信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "删除失败")})
    public CommonResult<Object> delPermissPelement(@PathVariable("id") @ApiParam(value = "权限页面元素信息id", required = true)long id) {
        if (permisspelementService.removeById(id)){
            return CommonResult.ofSuccess(id);
        }else {
            return CommonResult.ofFail();
        }
    }
    @RequestMapping(value = "/batchDelPermissPelementInfo",method = RequestMethod.POST)
    @ApiOperation(notes = "根据id列表批量删除权限的页面元素", httpMethod = "POST", value = "根据id列表批量删除权限的页面元素")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "失败")})
    public CommonResult<Object> batchDelPermissPelementInfo(@RequestBody List<String> infos) {
        if(null == infos||infos.isEmpty()){
            return CommonResult.parameterError(infos);
        }
        boolean b = permisspelementService.removeByIds(infos);
        if(!b){
            return CommonResult.ofFail();
        }
        return CommonResult.ofSuccess();
    }

    @RequestMapping(value = "/addPermissionMenu",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加权限的菜单信息", httpMethod = "POST", value = "添加权限的菜单信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = PermissionMenu.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "添加失败")})
    public CommonResult<PermissionMenu> addPermissionMenu(@RequestBody PermissionMenu permissionmenu) {
        permissionmenu.setId(SnowflakeIdWorker.generateId());
        if (permissionmenuService.save(permissionmenu)){
            return CommonResult.ofSuccessCreate(permissionmenu);
        }else {
            return CommonResult.ofFail("添加失败");
        }
    }

    @RequestMapping(value = "/delPermissionMenu/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "逻辑删除权限的菜单信息信息", httpMethod = "DELETE", value = "逻辑删除权限的菜单信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "删除失败")})
    public CommonResult<Object> delPermissionMenu(@PathVariable("id") @ApiParam(value = "权限-菜单信息id", required = true)long id) {
        if (permissionmenuService.removeById(id)){
            return CommonResult.ofSuccess(id);
        }else {
            return CommonResult.ofFail();
        }
    }
    @RequestMapping(value = "/batchDelPermissionMenuInfo",method = RequestMethod.POST)
    @ApiOperation(notes = "根据id列表批量删除权限的菜单", httpMethod = "POST", value = "根据id列表批量删除权限的菜单")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "失败")})
    public CommonResult<Object> batchDelPermissionMenuInfo(@RequestBody List<String> infos) {
        if(null == infos||infos.isEmpty()){
            return CommonResult.parameterError(infos);
        }
        boolean b = permissionmenuService.removeByIds(infos);
        if(!b){
            return CommonResult.ofFail();
        }
        return CommonResult.ofSuccess();
    }

    @RequestMapping(value = "/addPermissFile",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加权限的文件信息", httpMethod = "POST", value = "添加权限的文件信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = PermissFile.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "添加失败")})
    public CommonResult<PermissFile> addPermissFile(@RequestBody PermissFile permissfile) {
        permissfile.setId(SnowflakeIdWorker.generateId());
        if (permissfileService.save(permissfile)){
            return CommonResult.ofSuccessCreate(permissfile);
        }else {
            return CommonResult.ofFail("添加失败");
        }
    }

    @RequestMapping(value = "/delPermissFile/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "逻辑删除权限的文件信息", httpMethod = "DELETE", value = "逻辑删除权限的文件信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "删除失败")})
    public CommonResult<Object> delPermissFile(@PathVariable("id") @ApiParam(value = "权限的文件信息id", required = true)long id) {
        if (permissfileService.removeById(id)){
            return CommonResult.ofSuccess(id);
        }else {
            return CommonResult.ofFail();
        }
    }
    @RequestMapping(value = "/batchDelPermissFileInfo",method = RequestMethod.POST)
    @ApiOperation(notes = "根据id列表批量删除权限的文件信息", httpMethod = "POST", value = "根据id列表批量删除权限的文件信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "失败")})
    public CommonResult<Object> batchDelPermissFileInfo(@RequestBody List<String> infos) {
        if(null == infos||infos.isEmpty()){
            return CommonResult.parameterError(infos);
        }
        boolean b = permissfileService.removeByIds(infos);
        if(!b){
            return CommonResult.ofFail();
        }
        return CommonResult.ofSuccess();
    }

    @RequestMapping(value = "/addPermissOperate",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加权限的操作信息", httpMethod = "POST", value = "添加权限的操作信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = PermissOperate.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "添加失败")})
    public CommonResult<PermissOperate> addPermissOperate(@RequestBody PermissOperate permissoperate) {
        permissoperate.setId(SnowflakeIdWorker.generateId());
        if (permissoperateService.save(permissoperate)){
            return CommonResult.ofSuccessCreate(permissoperate);
        }else {
            return CommonResult.ofFail("添加失败");
        }
    }

    @RequestMapping(value = "/deletePermissOperate/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "逻辑删除权限的操作信息信息", httpMethod = "DELETE", value = "逻辑删除权限的操作信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "删除失败")})
    public CommonResult<Object> deletePermissOperate(@PathVariable("id") @ApiParam(value = "权限的操作信息id", required = true)long id) {
        if (permissoperateService.removeById(id)){
            return CommonResult.ofSuccess(id);
        }else {
            return CommonResult.ofFail();
        }
    }
    @RequestMapping(value = "/batchDelPermissOperateInfo",method = RequestMethod.POST)
    @ApiOperation(notes = "根据id列表批量删除", httpMethod = "POST", value = "根据id列表批量删除")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "失败")})
    public CommonResult<Object> batchDelPermissOperateInfo(@RequestBody List<String> infos) {
        if(null == infos||infos.isEmpty()){
            return CommonResult.parameterError(infos);
        }
        boolean b = permissoperateService.removeByIds(infos);
        if(!b){
            return CommonResult.ofFail();
        }
        return CommonResult.ofSuccess();
    }
}
