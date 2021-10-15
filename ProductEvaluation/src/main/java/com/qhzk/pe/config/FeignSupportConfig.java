package com.qhzk.pe.config;

import com.qhzk.pe.interceptor.FeignBasicAuthRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: FeignSupportConfig
 * @author: Mr.Muxl
 * @create: 2021-07-14 09:26
 **/
@Configuration
public class FeignSupportConfig {
    /**
     * feign请求拦截器
     *
     * @return
     */
    @Bean
    public RequestInterceptor requestInterceptor(){
        return new FeignBasicAuthRequestInterceptor();
    }
}
