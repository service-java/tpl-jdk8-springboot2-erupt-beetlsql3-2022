//package com.example.demo.config;
//
//import com.alibaba.fastjson.support.config.FastJsonConfig;
//import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//class WebMvcConfig extends WebMvcConfigurationSupport {
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        // @fix https://www.cnblogs.com/mzc1997/p/10260024.html
//        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        List<MediaType> mediaTypes = new ArrayList<>();
//        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
//        fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
//        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
//        HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
//        converters.add(converter);
//    }
//}