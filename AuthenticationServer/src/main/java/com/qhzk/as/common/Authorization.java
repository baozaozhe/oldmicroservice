package com.qhzk.as.common;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @description: 用户token
 * @author: Mr.Muxl
 * @create: 2021-07-12 15:09
 **/
public class Authorization extends UsernamePasswordToken {
    private String token;   //用户身份唯一的标识

    public Authorization(String token){
        this.token=token;
    }

    @Override
    public Object getPrincipal() {
        //在用户认证通过之后 再访问这个方法 默认返回的是什么?
        // Realm校验的第一个参数
        //校验我们自己写了   还有没有第一个参数这个说法?
        return token;
    }

}
