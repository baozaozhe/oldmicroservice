package com.qhzk.as.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qhzk.as.common.CommonResult;
import com.qhzk.as.common.MD5Util;
import com.qhzk.as.common.SnowflakeIdWorker;
import com.qhzk.as.entity.User;
import com.qhzk.as.service.UserService;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/**
 * 用户信息控制器类，用户信息资源管理
 * @author: Mr.Muxl
 * @date 2021-08-04
 */
@RestController
@RequestMapping("/user")
@Api(value = "/user", description = "用户信息")
public class UserApiController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/queryPageInfo",method = RequestMethod.POST)
    @ApiOperation(notes = "用户信息分页", httpMethod = "POST", value = "用户信息分页列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 200, message = "获取成功", response = User.class)
    public CommonResult<IPage<User>> queryPageInfo(
                      @RequestParam (value = "pageno",required = true) @ApiParam(value = "pageno", required = true) int pageno,
                      @RequestParam (value = "size",required = true) @ApiParam(value = "size", required = true) int size,
                      @RequestBody User  user) {
        Page page = new Page<User>();
        page.setCurrent(pageno);
        page.setSize(15);

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.setEntity(user);

        IPage<User> pageinfo= userService.page(page,wrapper);

        if(null == pageinfo.getRecords() ||pageinfo.getRecords().isEmpty()){
            return CommonResult.ofNotRecord();
        }
        return CommonResult.ofSuccess(pageinfo);
    }
     @RequestMapping(value = "/getAllusers",method = RequestMethod.POST)
     @ApiOperation(notes = "用户信息列表", httpMethod = "POST", value = "用户信息列表")
     @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
     @ApiResponse(code = 200, message = "获取成功", response = User.class)
     public CommonResult<List<User>> getAllUsers(@RequestBody User user) {
         QueryWrapper<User> wrapper = new QueryWrapper<>();
         wrapper.setEntity(user);
         List<User> list = userService.list(wrapper);
          if(null == list ||list.isEmpty()){
              return CommonResult.ofNotRecord();
          }
          return  CommonResult.ofSuccess(list);
     }

    @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "根据id获取用户信息信息", httpMethod = "GET", value = "根据id获取用户信息信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取", response = User.class)
    public CommonResult<User> getUserById(@PathVariable("id") @ApiParam(value = "用户信息id", required = true) long id) {
        User user = userService.getById(id);
        if (user == null) {
            return CommonResult.ofNotRecord();
        }
        return CommonResult.ofSuccess(user);
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "添加用户信息", httpMethod = "POST", value = "添加用户信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "添加成功", response = User.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 400, message = "添加失败")})
    public CommonResult<User> createUser(@RequestBody User user) {
        String accountnum = user.getAccountnum();
        if(null == accountnum ||"".equals(accountnum)){
            return CommonResult.ofFail("用户账号不能为空，不能注册");
        }
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        User user1 = new User();
        user1.setAccountnum(accountnum);
        wrapper.setEntity(user1);

        List<User> list = userService.list(wrapper);
        if(null == list ||list.isEmpty()){
            return CommonResult.ofFail("用户名已存在，不能注册");
        }

        user.setId(SnowflakeIdWorker.generateId());

         if (userService.save(user)){
              return CommonResult.ofSuccessCreate(user);
         }else {
              return CommonResult.ofFail("添加失败");
         }
    }
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "更新用户信息信息", httpMethod = "PUT", value = "更新用户信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 201, message = "更新成功", response = User.class),
    @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
    @ApiResponse(code = 400, message = "更新失败")})
    public CommonResult<User> updateUser(@RequestBody User user) {

          User currentuser = userService.getById(user.getId());

          if (currentuser==null) {
              return CommonResult.ofNotRecord();
          }

          String password = user.getPassword();
          String accountnum = user.getAccountnum();

          if(null != password||!"".equals(password)){
              String newpwd = MD5Util.string2MD5(password);
              if(newpwd.equals(currentuser.getPassword())){
                  return CommonResult.ofFail("新密码和原密码相同");
              }
          }

          if(null != accountnum||!"".equals(accountnum)){
              QueryWrapper<User> wrapper = new QueryWrapper<>();
              User user1 = new User();
              user1.setAccountnum(accountnum);
              wrapper.setEntity(user1);

              List<User> list = userService.list(wrapper);
              if(null == list ||list.isEmpty()){
                  return CommonResult.ofFail("用户名已存在，不能更改");
              }
          }

          if (userService.updateById(user)){
              return CommonResult.ofSuccess(user);
          }else {
              return CommonResult.ofFail();
          }
    }

    @RequestMapping(value = "/del/{id}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(notes = "逻辑删除用户信息信息", httpMethod = "DELETE", value = "逻辑删除用户信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "更新成功"),
                        @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
                        @ApiResponse(code = 400, message = "删除失败")})
    public CommonResult<Object> deleteUser(@PathVariable("id") @ApiParam(value = "用户信息id", required = true)long id) {
        if (userService.removeById(id)){
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
        boolean b = userService.removeByIds(infos);
        if(!b){
            return CommonResult.ofFail();
        }
        return CommonResult.ofSuccess();
    }

    /**
     * 登陆的接口
     * @param user
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "用户登陆的接口")
    public CommonResult<User> login(@RequestBody User user){
        //判断是否为空
        String password = user.getPassword();
        String accountnum = user.getAccountnum();

        if(null == password||"".equals(password)|| null == accountnum||"".equals(accountnum)){
            return CommonResult.ofFail("账号密码不能为空");
        }

        //验证用户是否存在
        User user1 = new  User();
        user1.setAccountnum(accountnum);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.setEntity(user1);
        List<User> list = userService.list(wrapper);

        if(null == list || list.isEmpty()){
            return CommonResult.ofFail("账号不存在");
        }

       //验证密码是否正确
        QueryWrapper<User> wrapper2 = new QueryWrapper<>();
        user1.setPassword(MD5Util.string2MD5(password));
        wrapper2.setEntity(user1);
        User one = userService.getOne(wrapper2);

        if(null == one){
            return CommonResult.ofFail("密码错误");
        }

        return CommonResult.ofSuccess(one);
    }
    /**
     * 验证token是否存在
     * @return
     */
    @RequestMapping(value = "/tokenIsExist",method = RequestMethod.GET)
    @ApiOperation(value = "验证token是否存在")
    public String tokenIsExist(
            @RequestParam (value = "token",required = true) @ApiParam(value = "token", required = true) String token){
        User user = new User();
        user.setToken(token);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.setEntity(user);
        int count = userService.count(wrapper);

        return  count>0 ?"0":"-1";
    }

    /**
     * 账号是否存在
     * @return
     */
    @RequestMapping(value = "/accNameIsExist",method = RequestMethod.GET)
    @ApiOperation(value = "账号是否存在")
    public CommonResult<Void> accNameIsExist(
            @RequestParam (value = "accountnum",required = true) @ApiParam(value = "accountnum", required = true) String accountnum){
        if(null == accountnum ||"".equals(accountnum)){
           return CommonResult.ofFail("用户账号不能为空，不能注册");
        }
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        User user = new User();
        user.setAccountnum(accountnum);
        wrapper.setEntity(user);

        List<User> list = userService.list(wrapper);
        if(null == list || list.isEmpty()){
            return CommonResult.ofSuccess("用户账号不存在，可以注册");
        }
        return CommonResult.ofFail("已存在用户账号，不能注册");
    }

    /**
     * 加密字符串
     * @return
     */
    @RequestMapping(value = "/encryptionStr",method = RequestMethod.GET)
    @ApiOperation(value = "加密字符串")
    public CommonResult<String> encryptionStr(
            @RequestParam (value = "str",required = true) @ApiParam(value = "str", required = true) String str){
        if(null == str || "".equals(str)){
            return CommonResult.ofFail("字符不能为空");
        }
        try{
            String s = MD5Util.string2MD5(str);
            return CommonResult.ofSuccess("加密成功",s);
        }catch (Exception e){
            return CommonResult.ofFail("加密异常");
        }
    }
    /**
     * 获取用户密码加密字符
     * @return
     */
    @RequestMapping(value = "/getEncryPwd",method = RequestMethod.GET)
    @ApiOperation(notes = "获取用户密码加密字符", httpMethod = "POST", value = "获取用户密码加密字符")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "authorization", value = "用户token", required = true)})
    @ApiResponses({@ApiResponse(code = 200, message = "删除成功",response = User.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "失败")})
    public CommonResult<User> getEncryPwd(
            @RequestParam (value = "accno",required = true) @ApiParam(value = "accno", required = true) String accno){

        if(null == accno || "".equals(accno)){
            return CommonResult.ofFail("账号不能为空");
        }

        try{
            //验证用户是否存在
            User user = new  User();
            user.setAccountnum(accno);
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.setEntity(user);

            User one = userService.getOne(wrapper);

            if(null == one){
                return CommonResult.ofFail("账号不存在");
            }
            return CommonResult.ofSuccess(one);

        }catch (Exception e){
            return CommonResult.ofFail("获取异常");
        }
    }

    /**
     * 获取验证码
     * @return
     */
    @RequestMapping(value = "/getCaptchaCode",method = RequestMethod.GET)
    @ApiOperation(notes = "获取验证码", httpMethod = "POST", value = "获取验证码")
    @ApiResponses({@ApiResponse(code = 200, message = "获取成功",response = User.class),
            @ApiResponse(code = 401, message = "令牌已过期，请重新获取"),
            @ApiResponse(code = 400, message = "失败")})
    public CommonResult<User> getCaptchaCode( @RequestParam (value = "uuid",required = true) @ApiParam(value = "uuid", required = true) String uuid){
        if(null == uuid || "".equals(uuid)){
            return CommonResult.ofFail("uuid不能为空！");
        }


        return CommonResult.ofSuccess();
    }
}
