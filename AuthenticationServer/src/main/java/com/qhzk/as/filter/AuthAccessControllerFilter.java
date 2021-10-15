package com.qhzk.as.filter;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.qhzk.as.common.Authorization;
import com.qhzk.as.common.BusinessException;
import com.qhzk.as.common.Constant;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.http.MediaType;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description: 授权过滤器
 * @author: Mr.Muxl
 * @create: 2021-07-12 15:15
 **/
public class AuthAccessControllerFilter extends AccessControlFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        try {
            //校验身份
            //逻辑是什么?
            //第一步：获取token
            String token=request.getHeader(Constant.REQ_TOKEN);
            if(StringUtils.isEmpty(token)){
                token=request.getHeader(Constant.AUTH_TOKEN);
            }
            //第二步：看下这个token是否否为""
            if(StringUtils.isEmpty(token)){  //说明你娃身份是非法的
                resultResponse(403001,"用户的请求的token不能为空",servletResponse);
            }else{  //说明用户带了token
                //逻辑
                //这里要将token进行封装  封装完了 交给shiro去做认证  看下身份是否合法
                Authorization customToken = new Authorization(token);
                //记住下面这个类 在用户第一次登陆的时候  并不会执行
                // 这个执行的时候 是在认证成功之后访问其他资源的
                //的时候 机械能给你身份校验的
                getSubject(servletRequest,servletResponse).login(customToken);
            }
        } catch (BusinessException e) {
            //如果是这个异常：返回JSON告诉前端出现问题了
            resultResponse(403001,"token校验异常",servletResponse);
            return false;
        } catch (AuthorizationException e){
            //  e.getCause() ：返回的是当前异常的实例
            if(e.getCause() instanceof BusinessException){ //表示返回的是我们自定义的异常
                //将异常的实例进行转换
                BusinessException err= (BusinessException) e.getCause();
                resultResponse(err.getMessageCode(),err.getDefaultMesaage(),servletResponse);
            }else{  //如果执行到这里  说明 这个异常是shiro返回的
                resultResponse(403001,"用户没有访问权限",servletResponse);
            }
            return false;
        }catch (Exception e){  //这个分支就捕获一些未考虑的异常了
            //  e.getCause() ：返回的是当前异常的实例
            if(e.getCause() instanceof BusinessException){ //表示返回的是我们自定义的异常
                //将异常的实例进行转换
                BusinessException err= (BusinessException) e.getCause();
                resultResponse(err.getMessageCode(),err.getDefaultMesaage(),servletResponse);
            }else{  //如果执行到这里  说明 这个异常是shiro返回的
                resultResponse(500001,"系统出现了异常",servletResponse);
            }
            return false;
        }
        //当前的方法返回true才放行  否则这个程序也就执行到这里了....
        return true;
    }

    /**
     * 这个方法的主要功能就是告诉前端 一些出错的信息
     * @param messageCode
     * @param defaultMesaage
     * @param response
     */
    private void resultResponse(int messageCode, String defaultMesaage, ServletResponse response) {

        //构建返回的数据
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",messageCode);
        jsonObject.put("msg",defaultMesaage);
        //设置下返回的数据类型
        response.setContentType(MediaType.APPLICATION_JSON_UTF8.toString());
        //获取输出流
        try {
            ServletOutputStream out = response.getOutputStream();
            //接下来项数据写出去
            out.write(jsonObject.toJSONString().getBytes());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
