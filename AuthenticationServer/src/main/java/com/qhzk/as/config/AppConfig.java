package com.qhzk.as.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description: AppConfig
 * @author: Mr.Muxl
 * @create: 2021-07-12 15:26
 **/
@SpringBootConfiguration
@ComponentScan(basePackages = {"com.qhzk.as"})
@MapperScan(basePackages = {"com.qhzk.as.mapper"})
public class AppConfig {

}
