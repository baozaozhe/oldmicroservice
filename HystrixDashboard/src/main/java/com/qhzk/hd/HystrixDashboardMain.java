package com.qhzk.hd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


/**
 * @description: Hystrix监控启动类
 * @author: Mr.Muxl
 * @create: 2021-07-14 11:31
 **/
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain.class,args);
    }
}
