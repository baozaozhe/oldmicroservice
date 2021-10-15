package com.qhzk.as.config;

import com.qhzk.as.common.Constant;
import com.qhzk.as.filter.AuthAccessControllerFilter;
import com.qhzk.as.matcher.CustomHashedCredentialsMatcher;
import com.qhzk.as.realm.AuthenticationRealm;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description: Shiro配置类
 * @author: Mr.Muxl
 * @create: 2021-07-12 15:24
 **/
@SpringBootConfiguration
public class ShiroConfig {

    /**
     * 咋们项目认证(请求资源的时候 身份的认证)的realm
     * @return
     */
    @Bean
    public AuthenticationRealm customRealm(){
        AuthenticationRealm customRealm = new AuthenticationRealm();
        customRealm.setCredentialsMatcher(customHashedCredentialsMatcher());
        return customRealm;
    }

    /**
     * 凭证匹配器的申明
     * @return
     */
    @Bean
    public CustomHashedCredentialsMatcher customHashedCredentialsMatcher(){
        return new CustomHashedCredentialsMatcher();
    }


    /**
     * 安全管理器
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(customRealm());
        return securityManager;
    }

    /**
     * 配置的是目标过滤器的代理
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //配置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //接下来配置些过滤器
        //配置自己的那个过滤器
        Map<String, Filter> maps=new LinkedHashMap<>();
        maps.put(Constant.REQ_TOKEN, (Filter) new AuthAccessControllerFilter());
        shiroFilterFactoryBean.setFilters(maps);

        //对请求过滤和拦截的设置
        Map<String,String> maps1=new LinkedHashMap<>();
        //放入不拦截的页面  拦截的页面....
        maps1.put("/user/login","anon");
        maps1.put("/user/getCaptchaCode","anon");
        maps1.put("/user/accNameIsExist","anon");
        maps1.put("/user/add","anon");
        maps1.put("/user/tokenIsExist","anon");
        maps1.put("/turbine.stream","anon");
        maps1.put("/turbine","anon");
        maps1.put("/hystrix.stream","anon");
        maps1.put("/hystrix","anon");
        maps1.put("/actuator/hystrix.stream","anon");
        maps1.put("/actuator/hystrix","anon");
        //Swagger的所有请求的资源和请求的地址都不需要拦截
        maps1.put("/swagger/**","anon");
        maps1.put("/v2/api-docs","anon");
        maps1.put("/swagger-ui.html","anon");
        maps1.put("/swagger-resources/**","anon");
        maps1.put("/doc.html/**","anon");
        maps1.put("/doc.html","anon");
        maps1.put("/webjars/**","anon");
        maps1.put("/favicon.ico","anon");
        maps1.put("/captcha.jpg","anon");
        maps1.put("/csrf","anon");
        //设置我们自己的校验
        maps1.put("/**","token,authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(maps1);
        return shiroFilterFactoryBean;
    }

    /**
     * 开启aop的注解的支持
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultSecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor attributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        attributeSourceAdvisor.setSecurityManager(securityManager);
        return attributeSourceAdvisor;
    }
    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }
}
