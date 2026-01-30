package com.niuma.demo.jdk25demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.accept.QueryApiVersionResolver;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author fanxiaoming
 * @since 2026/1/30 9:07
 */
@Configuration
public class ApiConfig implements WebMvcConfigurer {

    @Override
    public void configureApiVersioning(ApiVersionConfigurer configurer) {
        configurer.setDefaultVersion("v1");
        // 可以使用请求头或查询参数来指定 API 版本
        // 例如：X-API-VERSION: v2
        configurer.useRequestHeader("X-API-VERSION");
        // 也可以使用查询参数来指定 API 版本
        // 例如：/version/hello?version=v2
//        configurer.useVersionResolver(new QueryApiVersionResolver("version"));
    }


}
