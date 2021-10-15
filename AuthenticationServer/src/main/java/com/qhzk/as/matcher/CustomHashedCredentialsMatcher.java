package com.qhzk.as.matcher;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qhzk.as.common.Authorization;
import com.qhzk.as.entity.User;
import com.qhzk.as.service.UserService;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: Mr.Muxl
 * @create: 2021-07-12 15:48
 **/
public class CustomHashedCredentialsMatcher extends HashedCredentialsMatcher {

    @Autowired
    private UserService userService;

    /**
     * 下面这个方法 返回true 或者 false就决定了 这个是成功呢还是失败
     * @param token
     * @param info
     * @return
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        //  把前面传递过来的token取出来  再把存储到服务器的token取出来做比较
        // 如果一致那么就返回true  否则就返回  false
        Authorization token1= (Authorization) token;
        // 取出 Principal的值 (下面这个值 就是从前端传递过来进行比较的)
        String tokenVal= (String) token1.getPrincipal();
        // 从redis  或者  数据库    或者 session取出这个信息来
        User user = new User();
        user.setToken(tokenVal);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.setEntity(user);
        int count = userService.count(wrapper);
        return count > 0 ? true:false;
    }
}
