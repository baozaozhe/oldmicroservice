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
 * 角色信息控制器类，角色信息资源管理
 * @author: Mr.Muxl
 * @date 2021-08-05
 */
@RestController
@RequestMapping("/role")
@Api(value = "/role", description = "角色信息")
public class RoleApiController {

    @Resource
    private RoleService roleService;
    @Resource
    private RoleUserService roleuserService;
    @Resource
    private UserService userService;
    @Resource
    private RolePermissionsService rolepermissionsService;
    @Resource
    private PermissionsService permissionsService;

    @RequestMapping(value = "/queryPageInfo",method = RequestMethod.POST)
    @ApiOperation(notes = "角色信息分页", httpMethod = "POST", value = "角色信息分页列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = Role.class)
    public CommonResult<IPage<Role>> queryPageInfo(
                @RequestParam (value = "pageno",required = true) @ApiParam(value = "pageno", required = true) int pageno,
                @RequestParam (value = "size",required = true)  @ApiParam(value = "size", required = true) int size,
                @RequestBody Role  role) {

        Page page = new Page<Role>();
        page.setCurrent(pageno);
        page.setSize(size);

        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        wrapper.setEntity(role);

        IPage<Role> pageinfo= roleService.page(page,wrapper);

        if(null == pageinfo.getRecords() ||pageinfo.getRecords().isEmpty()){
             return CommonResult.ofNotRecord();
        }
         return CommonResult.ofSuccess(pageinfo);
    }


     @RequestMapping(value = "/getAllRoles",method = RequestMethod.POST)
     @ApiOperation(notes = "角色信息列表", httpMethod = "POST", value = "角色信息列表")
     @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
     @ApiResponse(code = 200, message = "获取成功", response = Role.class)
     public CommonResult<List<Role>> getAllUsers(@RequestBody Role role) {
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        wrapper.setEntity(role);
        List<Role> list = roleService.list(wrapper);
        if(null == list ||list.isEmpty()){
            return CommonResult.ofNotRecord();
        }
        return  CommonResult.ofSuccess(list);
    }

    @RequestMapping(value = "/getRoleById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据id获取角色信息信息", httpMethod = "GET", value = "根据id获取角色信息信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = Role.class)
    public CommonResult<Role> getRoleById(@PathVariable("id") @ApiParam(value = "角色信息id", required = true) long id) {
        Role role = roleService.getById(id);
        if (role == null) {
            return CommonResult.ofNotRecord();
        }
        return CommonResult.ofSuccess(role);
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加角色信息", httpMethod = "POST", value = "添加角色信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = Role.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 400, message = "添加失败")})
    public CommonResult<Role> createRole(@RequestBody Role role) {
        role.setId(SnowflakeIdWorker.generateId());
        if (roleService.save(role)){
            return CommonResult.ofSuccessCreate(role);
        }else {
            return CommonResult.ofFail("添加失败");
        }
    }
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "更新角色信息信息", httpMethod = "PUT", value = "更新角色信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "更新成功", response = Role.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 400, message = "更新失败")})
    public CommonResult<Role> updateRole(@RequestBody Role role) {
        Role currrole = roleService.getById(role.getId());

        if (currrole == null) {
            return CommonResult.ofNotRecord();
        }

        if (roleService.updateById(role)){
            return CommonResult.ofSuccess(role);
        }else {
            return CommonResult.ofFail();
        }
    }

    @RequestMapping(value = "/del/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "逻辑删除角色信息信息", httpMethod = "DELETE", value = "逻辑删除角色信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
                        @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
                        @ApiResponse(code = 400, message = "删除失败")})
    public CommonResult<Object> deleteRole(@PathVariable("id") @ApiParam(value = "角色信息id", required = true)long id) {
        if (roleService.removeById(id)){
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
        boolean b = roleService.removeByIds(infos);
        if(!b){
            return CommonResult.ofFail();
        }
        return CommonResult.ofSuccess();
    }

    @RequestMapping(value = "/addRoleUser",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加用户的角色", httpMethod = "POST", value = "添加用户的角色", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = RoleUser.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "添加失败")})
    public CommonResult<RoleUser> addRoleUser(@RequestBody RoleUser roleuser) {
        Long roleid = roleuser.getRoleid();
        Long userid = roleuser.getUserid();
        if(null == roleid || null == userid){
            return CommonResult.ofFail("用户或者角色不能为空");
        }
        User user = userService.getById(userid);
        if(null == user){
            return  CommonResult.ofFail("用户不存在");
        }
        Role role = roleService.getById(roleid);
        if(null == role){
            return  CommonResult.ofFail("角色不存在");
        }

        roleuser.setId(SnowflakeIdWorker.generateId());
        if (roleuserService.save(roleuser)){
            return CommonResult.ofSuccessCreate(roleuser);
        }else {
            return CommonResult.ofFail("添加失败");
        }
    }

    @RequestMapping(value = "/delRoleUser/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "逻辑删除用户-角色关联信息信息", httpMethod = "DELETE", value = "逻辑删除用户-角色关联信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "删除失败")})
    public CommonResult<Object> deleteRoleUser(@PathVariable("id") @ApiParam(value = "用户-角色关联信息id", required = true)long id) {
        if (roleuserService.removeById(id)){
            return CommonResult.ofSuccess(id);
        }else {
            return CommonResult.ofFail();
        }
    }
    @RequestMapping(value = "/batchDelRoleUserInfo",method = RequestMethod.POST)
    @ApiOperation(notes = "根据id列表批量删除", httpMethod = "POST", value = "根据id列表批量删除")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "失败")})
    public CommonResult<Object> batchDelRoleUserInfo(@RequestBody List<String> infos) {
        if(null == infos||infos.isEmpty()){
            return CommonResult.parameterError(infos);
        }
        boolean b = roleuserService.removeByIds(infos);
        if(!b){
            return CommonResult.ofFail();
        }
        return CommonResult.ofSuccess();
    }

    @RequestMapping(value = "/getUserRolesByUid",method = RequestMethod.GET)
    @ApiOperation(notes = "根据用户id获取用户的角色列表", httpMethod = "POST", value = "根据用户id获取用户的角色列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "删除成功" ,response = UserRoles.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "失败")})
    public CommonResult<UserRoles> getUserRolesByUid (
            @RequestParam (value = "用户id",required = true) @ApiParam(value = "用户id", required = true) long id,
            @RequestParam (value = "获取方式",required = true) @ApiParam(value = "获取方式(A查询全部角色 R查询用户杆连接上 U 查询用户组角色)", required = true) String type){
        if(null == type || "".equals(type)){
            return CommonResult.ofFail("获取方式不能为空");
        }
        UserRoles roles = roleuserService.getUserRolesByUid(id,type);

        if(null == roles){
            return CommonResult.ofFail();
        }
        return CommonResult.ofSuccess();
    }

    @RequestMapping(value = "/addRolePermissions",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加角色的权限信息", httpMethod = "POST", value = "添加角色的权限信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = RolePermissions.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "添加失败")})
    public CommonResult<RolePermissions> addRolePermissions(@RequestBody RolePermissions rolepermissions) {
        rolepermissions.setId(SnowflakeIdWorker.generateId());
        if (rolepermissionsService.save(rolepermissions)){
            return CommonResult.ofSuccessCreate(rolepermissions);
        }else {
            return CommonResult.ofFail("添加失败");
        }
    }

    @RequestMapping(value = "/delRolePermissions/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "逻辑删除角色的权限", httpMethod = "DELETE", value = "逻辑删除角色的权限", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "删除失败")})
    public CommonResult<Object> delRolePermissions(@PathVariable("id") @ApiParam(value = "逻辑删除角色的权限id", required = true)long id) {
        if (rolepermissionsService.removeById(id)){
            return CommonResult.ofSuccess(id);
        }else {
            return CommonResult.ofFail();
        }
    }

    @RequestMapping(value = "/batchDelRolePermisInfo",method = RequestMethod.POST)
    @ApiOperation(notes = "根据id列表批量角色的权限", httpMethod = "POST", value = "根据id列表批量角色的权限")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "失败")})
    public CommonResult<Object> batchDelRolePermisInfo(@RequestBody List<String> infos) {
        if(null == infos||infos.isEmpty()){
            return CommonResult.parameterError(infos);
        }
        boolean b = rolepermissionsService.removeByIds(infos);
        if(!b){
            return CommonResult.ofFail();
        }
        return CommonResult.ofSuccess();
    }

    @RequestMapping(value = "/getRolesPermissByRid",method = RequestMethod.GET)
    @ApiOperation(notes = "根据角色id获取权限列表", httpMethod = "POST", value = "根据角色id获取权限列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "删除成功" ,response = UserRoles.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "失败")})
    public CommonResult<UserRoles> getRolesPermissByRid (
            @RequestParam (value = "角色id",required = true) @ApiParam(value = "角色id", required = true) long id){

        Role role = roleService.getById(id);
        if(null == role){
            return CommonResult.ofFail("角色不存在");
        }
        List<Permissions> perss = permissionsService.getRolesPermissByRid(id);

        if(null == perss || perss.isEmpty()){
            return CommonResult.ofFail();
        }
        return CommonResult.ofSuccess();
    }
}
