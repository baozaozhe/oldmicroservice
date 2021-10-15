package com.qhzk.as.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
    @Bean
    public Docket getDefultApiDocket(){

        return new Docket(DocumentationType.SWAGGER_2)//文档类型（swagger2）
                .apiInfo(apiInfo())//设置包含在json ResourceListing响应中的api元信息
                .select()//启动用于api选择的构建器
                .apis(RequestHandlerSelectors.basePackage("com.qhzk.as.controller"))//扫描接口的包
                .paths(PathSelectors.any())//路径过滤器
                .build();
    }
    private ApiInfo apiInfo() {
        return  new ApiInfoBuilder()
                .title("SpringBoot 中使用Swagger2构建RESTful APIs")//api标题
                .version("1.0.0")//版本号
                .contact(new Contact("Mu xl","http://192.168.1.152/muxl","1658562850@qq.com"))//本API负责人的联系信息
                .build();
    }
}
