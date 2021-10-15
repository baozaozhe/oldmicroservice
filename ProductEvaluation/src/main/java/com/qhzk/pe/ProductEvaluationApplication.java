package com.qhzk.pe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author: Mr.Muxl
 * 2021-06-22 10:04
 * 产品评价功能 启动
 */

@SpringBootApplication
@EnableEurekaClient
@EnableTransactionManagement
@EnableFeignClients
@EnableHystrix
public class ProductEvaluationApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductEvaluationApplication.class,args);
    }
}
