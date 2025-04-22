package org.example.crudemployeemanage.config;

import com.github.pagehelper.PageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisConfig {
    @Bean
    PageInterceptor pageInterceptor() {
        //1、创建分页插件对象
        PageInterceptor pageInterceptor = new PageInterceptor();
        //2、设置参数

        return pageInterceptor;
    }
}
