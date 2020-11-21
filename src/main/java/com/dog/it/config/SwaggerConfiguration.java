package com.dog.it.config;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
@EnableOpenApi
@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket webApi() {
        return new Docket(DocumentationType.OAS_30)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .groupName("接口文档")//1-端口所属模块
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dog.it.controller"))//扫描当前package下的controller
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))//扫描类上标有@Api的controller类
                .paths(PathSelectors.any())
                .build();
    }


    /*** 获取 API 信息 方法 ***/
    private ApiInfo apiInfo() {
        // 作者 名称 连接地址 邮箱 是 固定写法
        Contact contact = new Contact("it_dog_zhang", null, null);
        // 返回一个 构造对象
        return new ApiInfoBuilder()
                .title("springboot-admin")
                .description("项目接口api文档")
                .contact(contact)
                .version("1.0")
                .build();
        //访问接口：/swagger-ui/index.html
    }
}
