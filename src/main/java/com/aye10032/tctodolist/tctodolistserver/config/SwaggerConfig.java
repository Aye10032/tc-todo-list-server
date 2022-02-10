package com.aye10032.tctodolist.tctodolistserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.function.Predicate;

/**
 * @program: tc-todo-list-server
 * @className: SwaggerConfgi
 * @Description: swagger配置类
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/10 下午 8:17
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket creatRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.aye10032.tctodolist.tctodolistserver.controller"))    // 为当前包路径
                .paths(PathSelectors.any())
                .paths(PathSelectors.regex("/error.*").negate())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("TC TodoList Server Swagger3 RESTful API")
                .contact(new Contact("Aye10032", "https://www.aye10032.com", "tc_aye@outlook.com"))
                .version("1.0")
                .description("TC TodoList Server接口文档")
                .build();
    }

}
