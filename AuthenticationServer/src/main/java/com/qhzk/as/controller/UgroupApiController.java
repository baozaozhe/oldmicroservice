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
 * 用户组信息控制器类，用户组信息资源管理
 * @author: Mr.Muxl
 * @date 2021-08-05
 */
@RestController
@RequestMapping("/ugroup")
@Api(value = "/ugroup", description = "用户组信息")
public class UgroupApiController {

    @Resource
    private UgroupService ugroupService;

    @Resource
    private UserUgroupService userugroupService;

    @Resource
    private UserService userService;

    @Resource
    private UgroupRoleService ugrouproleService;

    @Resource
    private RoleService roleService;

    @RequestMapping(value = "/queryPageInfo",method = RequestMethod.POST)
    @ApiOperation(notes = "用户组信息分页", httpMethod = "POST", value = "用户组信息分页列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = Ugroup.class)
    public CommonResult<IPage<Ugroup>> queryPageInfo(
                @RequestParam (value = "pageno",required = true) @ApiParam(value = "pageno", required = true) int pageno,
                @RequestParam (value = "size",required = true)  @ApiParam(value = "size", required = true) int size,
                @RequestBody Ugroup  ugroup) {

        Page page = new Page<Ugroup>();
        page.setCurrent(pageno);
        page.setSize(size);

        QueryWrapper<Ugroup> wrapper = new QueryWrapper<>();
        wrapper.setEntity(ugroup);

        IPage<Ugroup> pageinfo= ugroupService.page(page,wrapper);

        if(null == pageinfo.getRecords() ||pageinfo.getRecords().isEmpty()){
             return CommonResult.ofNotRecord();
        }
         return CommonResult.ofSuccess(pageinfo);
    }


     @RequestMapping(value = "/getAllUgroups",method = RequestMethod.POST)
     @ApiOperation(notes = "用户组信息列表", httpMethod = "POST", value = "用户组信息列表")
     @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
     @ApiResponse(code = 200, message = "获取成功", response = Ugroup.class)
     public CommonResult<List<Ugroup>> getAllUsers(@RequestBody Ugroup ugroup) {
        QueryWrapper<Ugroup> wrapper = new QueryWrapper<>();
        wrapper.setEntity(ugroup);
        List<Ugroup> list = ugroupService.list(wrapper);
        if(null == list ||list.isEmpty()){
            return CommonResult.ofNotRecord();
        }
        return  CommonResult.ofSuccess(list);
    }

    @RequestMapping(value = "/getUgroupById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据id获取用户组信息信息", httpMethod = "GET", value = "根据id获取用户组信息信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = Ugroup.class)
    public CommonResult<Ugroup> getUgroupById(@PathVariable("id") @ApiParam(value = "用户组信息id", required = true) long id) {
        Ugroup ugroup = ugroupService.getById(id);
        if (ugroup == null) {
            return CommonResult.ofNotRecord();
        }
        return CommonResult.ofSuccess(ugroup);
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加用户组信息", httpMethod = "POST", value = "添加用户组信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = Ugroup.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 400, message = "添加失败")})
    public CommonResult<Ugroup> createUgroup(@RequestBody Ugroup ugroup) {
        ugroup.setId(SnowflakeIdWorker.generateId());
        if (ugroupService.save(ugroup)){
            return CommonResult.ofSuccessCreate(ugroup);
        }else {
            return CommonResult.ofFail("添加失败");
        }
    }
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "更新用户组信息信息", httpMethod = "PUT", value = "更新用户组信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "更新成功", response = Ugroup.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 400, message = "更新失败")})
    public CommonResult<Ugroup> updateUgroup(@RequestBody Ugroup ugroup) {
        Ugroup currugroup = ugroupService.getById(ugroup.getId());

        if (currugroup == null) {
            return CommonResult.ofNotRecord();
        }

        if (ugroupService.updateById(ugroup)){
            return CommonResult.ofSuccess(ugroup);
        }else {
            return CommonResult.ofFail();
        }
    }

    @RequestMapping(value = "/del/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "逻辑删除用户组信息信息", httpMethod = "DELETE", value = "逻辑删除用户组信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
                        @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
                        @ApiResponse(code = 400, message = "删除失败")})
    public CommonResult<Object> deleteUgroup(@PathVariable("id") @ApiParam(value = "用户组信息id", required = true)long id) {
        if (ugroupService.removeById(id)){
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
        boolean b = ugroupService.removeByIds(infos);
        if(!b){
            return CommonResult.ofFail();
        }
        return CommonResult.ofSuccess();
    }

    @RequestMapping(value = "/addUgroupUser",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "向用户组添加用户", httpMethod = "POST", value = "向用户组添加用户", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = UserUgroup.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "添加失败")})
    public CommonResult<UserUgroup> addUgroupUser(@RequestBody UserUgroup userugroup) {
        Long ugroupid = userugroup.getUgroupid();
        Long userid = userugroup.getUserid();
        if(null ==ugroupid ||null == userid){
            return CommonResult.ofFail("用户或用户组不能为空");
        }
        Ugroup group = ugroupService.getById(ugroupid);
        if(null == group){
            return CommonResult.ofFail("用户组不存在");
        }
        User user = userService.getById(userid);
        if(null == user){
            return CommonResult.ofFail("用户不存在");
        }

        userugroup.setId(SnowflakeIdWorker.generateId());

        if (userugroupService.save(userugroup)){
            return CommonResult.ofSuccessCreate(userugroup);
        }else {
            return CommonResult.ofFail("添加失败");
        }
    }

    @RequestMapping(value = "/delUgroupUser/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "逻辑删除用户组下的用户信息", httpMethod = "DELETE", value = "逻辑删除用户组下的用户信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "删除失败")})
    public CommonResult<Object> delUgroupUser(@PathVariable("id") @ApiParam(value = "关联信息id", required = true)long id) {
        if (userugroupService.removeById(id)){
            return CommonResult.ofSuccess(id);
        }else {
            return CommonResult.ofFail();
        }
    }
    @RequestMapping(value = "/batchDelUgroupUserInfo",method = RequestMethod.POST)
    @ApiOperation(notes = "根据id列表批量删除", httpMethod = "POST", value = "根据id列表批量删除")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "失败")})
    public CommonResult<Object> batchDelUgroupUserInfo(@RequestBody List<String> infos) {
        if(null == infos||infos.isEmpty()){
            return CommonResult.parameterError(infos);
        }
        boolean b = userugroupService.removeByIds(infos);
        if(!b){
            return CommonResult.ofFail();
        }
        return CommonResult.ofSuccess();
    }

    @RequestMapping(value = "/getUgroupUserRoles/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据用户组id获取用户组用户和角色信息", httpMethod = "GET", value = "根据用户组id获取用户组用户和角色信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = Ugroup.class)
    public CommonResult<List<Ugroup>> getUgroupUserRoles(@PathVariable("id") @ApiParam(value = "用户组id", required = true) long id,
                        @RequestParam (value = "currflag",required = true)  @ApiParam(value = "Y 当前用户组的用户和角色 N 当前及下级用户组用户和角色", required = true) String currflag) {

        Ugroup ugroup = ugroupService.getById(id);
        if(null == ugroup){
            return CommonResult.ofFail("用户组不存在");
        }

        if(null == currflag || "".equals(currflag)){
            return CommonResult.ofFail("currflag 不能为空");
        }

        List<Ugroup> list = ugroupService.queryUgroupUsersRoleById(id,currflag);

        if (null == list || list.isEmpty()) {
            return CommonResult.ofNotRecord();
        }
        return CommonResult.ofSuccess(list);
    }


    @RequestMapping(value = "/addUgroupRole",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "向用户组添加角色", httpMethod = "POST", value = "向用户组添加角色", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = UgroupRole.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "添加失败")})
    public CommonResult<UgroupRole> addUgroupRole(@RequestBody UgroupRole ugrouprole) {
        Long roleid = ugrouprole.getRoleid();
        Long ugroupid = ugrouprole.getUgroupid();
        if(null == roleid || null == ugroupid){
            return CommonResult.ofSuccessCreate("用户组或角色为空");
        }
        Role role = roleService.getById(roleid);
        if(null == role){
            return CommonResult.ofFail("角色不存在");
        }
        Ugroup ugroup = ugroupService.getById(ugroupid);
        if(null == ugroup){
            return CommonResult.ofFail("用户组不存在");
        }
        ugrouprole.setId(SnowflakeIdWorker.generateId());
        if (ugrouproleService.save(ugrouprole)){
            return CommonResult.ofSuccessCreate(ugrouprole);
        }else {
            return CommonResult.ofFail("添加失败");
        }
    }


    @RequestMapping(value = "/delUgroupRole/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "逻辑删除用户组-角色关联信息信息", httpMethod = "DELETE", value = "逻辑删除用户组-角色关联信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "删除失败")})
    public CommonResult<Object> delUgroupRole(@PathVariable("id") @ApiParam(value = "用户组-角色关联信息id", required = true)long id) {
        if (ugrouproleService.removeById(id)){
            return CommonResult.ofSuccess(id);
        }else {
            return CommonResult.ofFail();
        }
    }
    @RequestMapping(value = "/batchDelUgroupRoleInfo",method = RequestMethod.POST)
    @ApiOperation(notes = "根据id列表批量删除", httpMethod = "POST", value = "根据id列表批量删除")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "失败")})
    public CommonResult<Object> batchDelUgroupRoleInfo(@RequestBody List<String> infos) {
        if(null == infos||infos.isEmpty()){
            return CommonResult.parameterError(infos);
        }
        boolean b = ugrouproleService.removeByIds(infos);
        if(!b){
            return CommonResult.ofFail();
        }
        return CommonResult.ofSuccess();
    }
}
