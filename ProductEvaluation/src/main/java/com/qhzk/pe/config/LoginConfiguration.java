package com.qhzk.pe.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.qhzk.pe.interceptor.LoginInterceptor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.MappedInterceptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 负责注册并生效自己定义的拦截器配置
 * @author: Mr.Muxl
 * @create: 2021-07-13 11:16
 **/
@Configuration
public class LoginConfiguration implements WebMvcConfigurer{
    @Bean
    public MappedInterceptor getMappedInterceptor() {
        //注册拦截器
        LoginInterceptor loginInterceptor = setBean2();
        //拦截路径 ("/**")对所有请求都拦截
        String[] includePatterns = new String[]{"/**"};
        //排除拦截路径
        String[] excludePatterns = new String[]{"/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**",
                "/api", "/api-docs", "/api-docs/**","/doc.html/**","/doc.html"};

        //将数组转化为集合
        List<String> listOldExclude = Arrays.asList(excludePatterns);

        //将自定义的排除拦截路径添加到集合中
        List<String> listNewExclude = new ArrayList<>();
        listNewExclude.add("/demoJson/getCityList.json");
        listNewExclude.add("/demoJson/getStudentList.json");

        //定义新集合
        List<String> listExclude = new ArrayList<>();
        listExclude.addAll(listOldExclude);
        listExclude.addAll(listNewExclude);

        //将新集合转化回新数组
        String[] newExcludePatterns = listExclude.toArray(new String[listExclude.size()]);

        return new MappedInterceptor(includePatterns, newExcludePatterns, loginInterceptor);
    }
    @Bean
    public LoginInterceptor setBean2(){
        return new LoginInterceptor();
    }

    /**
     * 解决Jackson导致Long型数据精度丢失问题
     * @return
     */
    @Bean("jackson2ObjectMapperBuilderCustomizer")
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        Jackson2ObjectMapperBuilderCustomizer customizer = new Jackson2ObjectMapperBuilderCustomizer() {
            @Override
            public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
                jacksonObjectMapperBuilder.serializerByType(Long.class, ToStringSerializer.instance)
                        .serializerByType(Long.TYPE, ToStringSerializer.instance);
            }
        };
        return customizer;

    }
}
