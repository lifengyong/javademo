package com.neu.lify.demo.swagger.common.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDateTime;
import java.util.Date;

@Configuration
@EnableSwagger2
@Profile({"dev"})
public class SwaggerConfig {

    @Bean
    public Docket swaggerSpringPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .directModelSubstitute(LocalDateTime.class, Date.class) //java8中LocalDateTime类型会被序列化成很复杂的字符串，LocalDateTime转换成Date进行显示
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot-swagger")
                .description("swagger document")
                .contact(new Contact("lify", "http://www.neu.cn", "lify@gmail.com"))
                .version("0.0.1")
                .build();
    }
}
