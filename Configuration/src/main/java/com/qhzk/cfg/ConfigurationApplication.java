package com.qhzk.cfg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @description: 配置中心启动类
 * @author: Mr.Muxl
 * @create: 2021-07-12 09:28
 **/
@SpringBootApplication
@EnableConfigServer
public class ConfigurationApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigurationApplication.class,args);
    }
}
