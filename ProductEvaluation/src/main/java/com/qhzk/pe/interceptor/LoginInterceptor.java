package com.qhzk.pe.interceptor;

import com.github.pagehelper.util.StringUtil;
import com.qhzk.pe.common.CommonResult;
import com.qhzk.pe.feignclient.AuthServerFeignClient;
import com.qhzk.pe.utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @description: 登录请求拦截器
 * @author: Mr.Muxl
 * @create: 2021-07-13 11:17
 **/
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private AuthServerFeignClient userservice;
    /**
     * 在请求被处理之前调用
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestMethod = request.getMethod();
        if (requestMethod.contains("OPTIONS") || requestMethod.contains("options")) {
            return true;
        }
        //token 校验
        String token = request.getHeader(Constant.REQ_TOKEN);
        if (StringUtil.isEmpty(token)) {
            returnJson(response);
            return false;
        }

        String s = userservice.tokenIsExist(token);

        if ("0".equals(s)) {
            return true;
        }
        else if("-1".equals(s)){
            returnJson(response);
            return false;
        }else {
            returnJson(response);
            return false;
        }
    }

    /**
     * token无效
     * @param response
     */
    private void returnJson(HttpServletResponse response){
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(CommonResult.tokenExpired());
        } catch (IOException e){
            System.out.println("拦截器输出流异常:"+e.getMessage());
            e.printStackTrace();
        } finally {
            if(writer != null){
                writer.close();
            }
        }
    }

    /**
     * 在请求被处理后，视图渲染之前调用
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {}
    /**
     * 在整个请求结束后调用
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {}
}
