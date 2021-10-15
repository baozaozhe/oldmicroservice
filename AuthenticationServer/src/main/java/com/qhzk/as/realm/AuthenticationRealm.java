package com.qhzk.as.realm;

import com.qhzk.as.common.Authorization;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @description: realm
 * @author: Mr.Muxl
 * @create: 2021-07-12 15:21
 **/
public class AuthenticationRealm extends AuthorizingRealm {
    /**
     * 授权的方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        return simpleAuthorizationInfo;
    }

    /**
     * 认证的方法
     * 将前端放进去的token 取出来 放到校验的SimpleAuthenticationInfo中去 方便后面进行校验
     * token放到哪里呢?
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //取出前端传递过来的token
        Authorization customToken= (Authorization) authenticationToken;
        String token= (String) customToken.getPrincipal();

        //这里就可以取出这个token
        //在这里要将前端传递过来的token给封装到 SimpleAuthenticationInfo 对象中去
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(token,token,getName());
        return simpleAuthenticationInfo;
    }
}
