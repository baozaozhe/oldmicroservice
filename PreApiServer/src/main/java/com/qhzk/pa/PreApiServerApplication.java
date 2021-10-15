package com.qhzk.pa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description: 前置服务调用启动类
 * @author: Mr.Muxl
 * @create: 2021-06-23 13:39
 **/
@SpringBootApplication
@EnableFeignClients
public class PreApiServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PreApiServerApplication.class,args);
    }
}
