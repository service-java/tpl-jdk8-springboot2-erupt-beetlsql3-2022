package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class WebCorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 根据实际情况修改如下配置的值
        corsConfiguration.addAllowedOrigin("*"); // 允许访问源地址
        corsConfiguration.addAllowedHeader("*"); // 允许头
        corsConfiguration.addAllowedMethod("*"); // 允许方法
        source.registerCorsConfiguration("/**", corsConfiguration); // 对接口配置跨域设置
        return new CorsFilter(source);
    }

}
