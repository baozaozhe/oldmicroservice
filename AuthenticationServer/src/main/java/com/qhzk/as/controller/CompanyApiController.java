package com.qhzk.as.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qhzk.as.common.BusinessException;
import com.qhzk.as.common.CommonResult;
import com.qhzk.as.common.SnowflakeIdWorker;
import com.qhzk.as.entity.Company;
import com.qhzk.as.entity.CompanyUser;
import com.qhzk.as.entity.Dept;
import com.qhzk.as.entity.User;
import com.qhzk.as.service.CompanyService;
import com.qhzk.as.service.CompanyUserService;
import com.qhzk.as.service.DeptService;
import com.qhzk.as.service.UserService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 公司信息控制器类，公司信息资源管理
 * @author: Mr.Muxl
 * @date 2021-08-05
 */
@RestController
@RequestMapping("/company")
@Api(value = "/company", description = "公司信息")
public class CompanyApiController {

    @Resource
    private CompanyService companyService;
    @Resource
    private DeptService deptService;
    @Resource
    private CompanyUserService companyuserService;
    @Resource
    private UserService userService;

    @RequestMapping(value = "/queryPageInfo",method = RequestMethod.POST)
    @ApiOperation(notes = "公司信息分页", httpMethod = "POST", value = "公司信息分页列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = Company.class)
    public CommonResult<IPage<Company>> queryPageInfo(
                @RequestParam (value = "pageno",required = true) @ApiParam(value = "pageno", required = true) int pageno,
                @RequestParam (value = "size",required = true)  @ApiParam(value = "size", required = true) int size,
                @RequestBody Company  company) {

        Page page = new Page<Company>();
        page.setCurrent(pageno);
        page.setSize(15);

        QueryWrapper<Company> wrapper = new QueryWrapper<>();
        wrapper.setEntity(company);

        IPage<Company> pageinfo= companyService.page(page,wrapper);

        if(null == pageinfo.getRecords() ||pageinfo.getRecords().isEmpty()){
             return CommonResult.ofNotRecord();
        }
         return CommonResult.ofSuccess(pageinfo);
    }


     @RequestMapping(value = "/getAllCompanys",method = RequestMethod.POST)
     @ApiOperation(notes = "公司信息列表", httpMethod = "POST", value = "公司信息列表")
     @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
     @ApiResponse(code = 200, message = "获取成功", response = Company.class)
     public CommonResult<List<Company>> getAllUsers(@RequestBody Company company) {
        QueryWrapper<Company> wrapper = new QueryWrapper<>();
        wrapper.setEntity(company);
        List<Company> list = companyService.list(wrapper);
        if(null == list ||list.isEmpty()){
            return CommonResult.ofNotRecord();
        }
        return  CommonResult.ofSuccess(list);
    }

    @RequestMapping(value = "/getCompanyById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据id获取公司信息信息", httpMethod = "GET", value = "根据id获取公司信息信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = Company.class)
    public CommonResult<Company> getCompanyById(@PathVariable("id") @ApiParam(value = "公司信息id", required = true) long id) {
        Company company = companyService.getById(id);
        if (company == null) {
            return CommonResult.ofNotRecord();
        }
        return CommonResult.ofSuccess(company);
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加公司信息", httpMethod = "POST", value = "添加公司信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = Company.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 400, message = "添加失败")})
    public CommonResult<Company> createCompany(@RequestBody Company company) {
        company.setId(SnowflakeIdWorker.generateId());
        if (companyService.save(company)){
            return CommonResult.ofSuccessCreate(company);
        }else {
            return CommonResult.ofFail("添加失败");
        }
    }
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "更新公司信息信息", httpMethod = "PUT", value = "更新公司信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "更新成功", response = Company.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 400, message = "更新失败")})
    public CommonResult<Company> updateCompany(@RequestBody Company company) {
        Company currcompany = companyService.getById(company.getId());

        if (currcompany == null) {
            return CommonResult.ofNotRecord();
        }

        if (companyService.updateById(company)){
            return CommonResult.ofSuccess(company);
        }else {
            return CommonResult.ofFail();
        }
    }

    @RequestMapping(value = "/del/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "逻辑删除公司信息信息", httpMethod = "DELETE", value = "逻辑删除公司信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
                        @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
                        @ApiResponse(code = 400, message = "删除失败")})
    public CommonResult<Object> deleteCompany(@PathVariable("id") @ApiParam(value = "公司信息id", required = true)long id) {
        if (companyService.removeById(id)){
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
        boolean b = companyService.removeByIds(infos);
        if(!b){
            return CommonResult.ofFail();
        }
        return CommonResult.ofSuccess();
    }

    @RequestMapping(value = "/getCompanyDepts/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据公司id获取公司部门信息", httpMethod = "GET", value = "根据公司id获取公司部门信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = Dept.class)
    public CommonResult<List<Dept>> getCompanyDepts(@PathVariable("id") @ApiParam(value = "公司信息id", required = true) long id) {
        Company company = companyService.getById(id);
        if(null == company){
            return CommonResult.ofFail("公司不存在");
        }

        Dept dept = new Dept();
        dept.setCompanyid(id);

        QueryWrapper<Dept> wrapper = new QueryWrapper<>();
        wrapper.setEntity(dept);

        List<Dept> list = deptService.list(wrapper);

        if (null == list || list.isEmpty()) {
            return CommonResult.ofNotRecord();
        }
        return CommonResult.ofSuccess(list);
    }


    @RequestMapping(value = "/addCompanyUser",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加公司员工", httpMethod = "POST", value = "添加公司员工", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = CompanyUser.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "添加失败")})
    public CommonResult<CompanyUser> addCompanyUser(@RequestBody CompanyUser companyuser) {
        if(null == companyuser){
            return CommonResult.ofFail("参数不能为空");
        }
        Long companyid = companyuser.getCompanyid();
        Long userid = companyuser.getUserid();
        if(null == companyid || null == userid){
            return CommonResult.ofFail("参数不能为空");
        }
        Company company = companyService.getById(companyid);
        if(null == company){
            return CommonResult.ofFail("公司不存在");
        }
        User user = userService.getById(userid);
        if(null == user){
            return CommonResult.ofFail("用户不存在");
        }
        companyuser.setId(SnowflakeIdWorker.generateId());

        if (companyuserService.save(companyuser)){
            return CommonResult.ofSuccessCreate(companyuser);
        }else {
            return CommonResult.ofFail("添加失败");
        }
    }


    @RequestMapping(value = "/delCompanyUser/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "逻辑删除公司员工", httpMethod = "DELETE", value = "逻辑删除公司员工", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "删除失败")})
    public CommonResult<Object> deleteCompanyUser(@PathVariable("id") @ApiParam(value = "公司-用户id", required = true)long id) {
        if (companyuserService.removeById(id)){
            return CommonResult.ofSuccess(id);
        }else {
            return CommonResult.ofFail();
        }
    }
    @RequestMapping(value = "/batchDelCompanyUserInfo",method = RequestMethod.POST)
    @ApiOperation(notes = "根据id列表批量删除公司员工", httpMethod = "POST", value = "根据id列表批量删除公司员工")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "失败")})
    public CommonResult<Object> batchDelCompanyUserInfo(@RequestBody List<String> infos) {
        if(null == infos||infos.isEmpty()){
            return CommonResult.parameterError(infos);
        }
        boolean b = companyuserService.removeByIds(infos);
        if(!b){
            return CommonResult.ofFail();
        }
        return CommonResult.ofSuccess();
    }

    @RequestMapping(value = "/getCompanyUsers/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据公司id获取公司员工信息", httpMethod = "GET", value = "根据公司id获取公司员工信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = User.class)
    public CommonResult<List<User>> getCompanyUsers(@PathVariable("id") @ApiParam(value = "公司信息id", required = true) long id) {
        Company company = companyService.getById(id);
        if(null == company){
            return CommonResult.ofFail("公司不存在");
        }

        List<User> list = companyuserService.queryCompanyUsersById(id);

        if (null == list || list.isEmpty()) {
            return CommonResult.ofNotRecord();
        }
        return CommonResult.ofSuccess(list);
    }
}
