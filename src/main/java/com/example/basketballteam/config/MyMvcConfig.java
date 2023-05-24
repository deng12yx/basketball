package com.example.basketballteam.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    // 配置虚拟路径映射访问
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 映射图片保存地址
        registry.addResourceHandler("/static/image/**")
                .addResourceLocations("file:D:\\开摆\\数据库\\basketballTeam\\src\\main\\resources\\static\\image\\");
    }
}