package com.qhzk.as.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qhzk.as.common.BusinessException;
import com.qhzk.as.common.CommonResult;
import com.qhzk.as.common.SnowflakeIdWorker;
import com.qhzk.as.entity.Company;
import com.qhzk.as.entity.Dept;
import com.qhzk.as.entity.DeptUser;
import com.qhzk.as.entity.User;
import com.qhzk.as.service.CompanyService;
import com.qhzk.as.service.DeptService;
import com.qhzk.as.service.DeptUserService;
import com.qhzk.as.service.UserService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门信息控制器类，部门信息资源管理
 * @author: Mr.Muxl
 * @date 2021-08-05
 */
@RestController
@RequestMapping("/dept")
@Api(value = "/dept", description = "部门信息")
public class DeptApiController {
    @Resource
    private DeptUserService deptuserService;
    @Resource
    private DeptService deptService;
    @Resource
    private CompanyService companyService;
    @Resource
    private UserService userService;

    @RequestMapping(value = "/queryPageInfo",method = RequestMethod.POST)
    @ApiOperation(notes = "部门信息分页", httpMethod = "POST", value = "部门信息分页列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = Dept.class)
    public CommonResult<IPage<Dept>> queryPageInfo(
                @RequestParam (value = "pageno",required = true) @ApiParam(value = "pageno", required = true) int pageno,
                @RequestParam (value = "size",required = true)  @ApiParam(value = "size", required = true) int size,
                @RequestBody Dept  dept) {

        Page page = new Page<Dept>();
        page.setCurrent(pageno);
        page.setSize(15);

        QueryWrapper<Dept> wrapper = new QueryWrapper<>();
        wrapper.setEntity(dept);

        IPage<Dept> pageinfo= deptService.page(page,wrapper);

        if(null == pageinfo.getRecords() ||pageinfo.getRecords().isEmpty()){
             return CommonResult.ofNotRecord();
        }
         return CommonResult.ofSuccess(pageinfo);
    }


     @RequestMapping(value = "/getAllDepts",method = RequestMethod.POST)
     @ApiOperation(notes = "部门信息列表", httpMethod = "POST", value = "部门信息列表")
     @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
     @ApiResponse(code = 200, message = "获取成功", response = Dept.class)
     public CommonResult<List<Dept>> getAllUsers(@RequestBody Dept dept) {
        QueryWrapper<Dept> wrapper = new QueryWrapper<>();
        wrapper.setEntity(dept);
        List<Dept> list = deptService.list(wrapper);
        if(null == list ||list.isEmpty()){
            return CommonResult.ofNotRecord();
        }
        return  CommonResult.ofSuccess(list);
    }

    @RequestMapping(value = "/getDeptById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据id获取部门信息信息", httpMethod = "GET", value = "根据id获取部门信息信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = Dept.class)
    public CommonResult<Dept> getDeptById(@PathVariable("id") @ApiParam(value = "部门信息id", required = true) long id) {
        Dept dept = deptService.getById(id);
        if (dept == null) {
            return CommonResult.ofNotRecord();
        }
        return CommonResult.ofSuccess(dept);
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加部门信息", httpMethod = "POST", value = "添加部门信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = Dept.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 400, message = "添加失败")})
    public CommonResult<Dept> createDept(@RequestBody Dept dept) {
        Long companyid = dept.getCompanyid();
        if(null == companyid){
            return CommonResult.ofFail("companyid");
        }
        Company company = companyService.getById(companyid);
        if(null == company){
            return CommonResult.ofFail("公司不存在");
        }
        dept.setId(SnowflakeIdWorker.generateId());
        Long parentid = dept.getParentid();
        if(null == parentid || parentid < 0L){
            dept.setParentid(0L);
        }
        if (deptService.save(dept)){
            return CommonResult.ofSuccessCreate(dept);
        }else {
            return CommonResult.ofFail("添加失败");
        }
    }
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "更新部门信息信息", httpMethod = "PUT", value = "更新部门信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "更新成功", response = Dept.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 400, message = "更新失败")})
    public CommonResult<Dept> updateDept(@RequestBody Dept dept) {
        Dept currdept = deptService.getById(dept.getId());

        Long companyid = dept.getCompanyid();
        if(null != companyid){
            Company company = companyService.getById(companyid);
            if(null == company){
                return CommonResult.ofFail("公司不存在");
            }
        }

        if (currdept == null) {
            return CommonResult.ofNotRecord();
        }

        if (deptService.updateById(dept)){
            return CommonResult.ofSuccess(dept);
        }else {
            return CommonResult.ofFail();
        }
    }

    @RequestMapping(value = "/del/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "逻辑删除部门信息信息", httpMethod = "DELETE", value = "逻辑删除部门信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
                        @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
                        @ApiResponse(code = 400, message = "删除失败")})
    public CommonResult<Object> deleteDept(@PathVariable("id") @ApiParam(value = "部门信息id", required = true)long id) {
        if (deptService.removeById(id)){
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
        boolean b = deptService.removeByIds(infos);
        if(!b){
            return CommonResult.ofFail();
        }
        return CommonResult.ofSuccess();
    }

    @RequestMapping(value = "/createdeptuser",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = " 向部门下添加用户", httpMethod = "POST", value = "向部门下添加用户", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = DeptUser.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "添加失败")})
    public CommonResult<DeptUser> createDeptUser(@RequestBody DeptUser deptuser) {
        Long userid = deptuser.getUserid();
        if(null == userid){
            return CommonResult.parameterError("userid 不能为 null",deptuser);
        }
        User user = userService.getById(userid);
        if(null == user){
            return CommonResult.ofFail("用户不存在");
        }
        Long deptid = deptuser.getDeptid();
        if(null == deptid){
            return CommonResult.parameterError("deptid 不能为 null",deptuser);
        }
        Dept dept = deptService.getById(deptid);
        if(null == dept){
            return CommonResult.ofFail("部门不存在");
        }

        deptuser.setId(SnowflakeIdWorker.generateId());

        if (deptuserService.save(deptuser)){
            return CommonResult.ofSuccessCreate(deptuser);
        }else {
            return CommonResult.ofFail("添加失败");
        }
    }
    @RequestMapping(value = "/updatedeptuser", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "更新单个 用户 的 部门 信息", httpMethod = "PUT", value = "更新单个用户 的 部门 信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "更新成功", response = DeptUser.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "更新失败")})
    public CommonResult<DeptUser> updateDeptUser(@RequestBody DeptUser deptuser) {
        DeptUser currdeptuser = deptuserService.getById(deptuser.getId());

        if (currdeptuser == null) {
            return CommonResult.ofNotRecord();
        }

        Long userid = deptuser.getUserid();
        if(null == userid){
            return CommonResult.parameterError("userid 不能为 null",deptuser);
        }
        User user = userService.getById(userid);
        if(null == user){
            return CommonResult.ofFail("用户不存在");
        }
        Long deptid = deptuser.getDeptid();
        if(null == deptid){
            return CommonResult.parameterError("deptid 不能为 null",deptuser);
        }
        Dept dept = deptService.getById(deptid);
        if(null == dept){
            return CommonResult.ofFail("部门不存在");
        }

        if (deptuserService.updateById(deptuser)){
            return CommonResult.ofSuccess(deptuser);
        }else {
            return CommonResult.ofFail();
        }
    }

    @RequestMapping(value = "/deldeptuser/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "真实删除部门下面的用户", httpMethod = "DELETE", value = "真实删除部门下面的用户", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "删除失败")})
    public CommonResult<Object> deleteDeptUser(@PathVariable("id") @ApiParam(value = "部门-用户id", required = true)long id) {
        if (deptuserService.removeById(id)){
            return CommonResult.ofSuccess(id);
        }else {
            return CommonResult.ofFail();
        }
    }
    @RequestMapping(value = "/batchDelDeptUserInfo",method = RequestMethod.POST)
    @ApiOperation(notes = "根据id列表批量删除部门下的用户", httpMethod = "POST", value = "根据id列表批量删除部门下的用户")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "失败")})
    public CommonResult<Object> batchDelDeptUserInfo(@RequestBody List<String> infos) {

        if(null == infos||infos.isEmpty()){
            return CommonResult.parameterError(infos);
        }
        boolean b = deptuserService.removeByIds(infos);
        if(!b){
            return CommonResult.ofFail();
        }
        return CommonResult.ofSuccess();
    }

    @RequestMapping(value = "/getDeptUsers/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据部门id获取部门的员工信息", httpMethod = "GET", value = "根据部门id获取部门的员工信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = User.class)
    public CommonResult<List<User>> getDeptUsers(@PathVariable("id") @ApiParam(value = "部门id", required = true) long id,
                                  @RequestParam (value = "currflag",required = true)  @ApiParam(value = "Y 当前部门的员工 N 当前及下级部门员工", required = true) String currflag) {
        Dept dept = deptService.getById(id);
        if(null == dept){
            return CommonResult.ofFail("部门不存在");
        }

        if(null == currflag || "".equals(currflag)){
            return CommonResult.ofFail("currflag 不能为空");
        }

        List<Dept> list = deptService.queryDeptUsersById(id,currflag);

        if (null == list || list.isEmpty()) {
            return CommonResult.ofNotRecord();
        }
        return CommonResult.ofSuccess(list);
    }
}
