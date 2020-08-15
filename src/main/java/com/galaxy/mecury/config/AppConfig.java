package com.galaxy.mecury.config;

import com.galaxy.mecury.annotation.Auth;
import com.galaxy.mecury.interceptor.ApiInterceptor;
import com.galaxy.mecury.interceptor.AuthInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@Configuration
@EnableWebMvc//开启全面接管spingmvc
//配置只会扫描Controller注解
@ComponentScan(value = {"com.galaxy.mecury"},includeFilters={@ComponentScan.Filter(type= FilterType.ANNOTATION,value={Controller.class})},useDefaultFilters = false)
public class AppConfig implements WebMvcConfigurer {

    //配置视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //默认前缀 /WEB-INF/   后缀.jsp
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    //可以自定义添加各种组件 通过重写方法

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("/static/", "classpath:static/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converters.add(0, converter);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new ApiInterceptor()).excludePathPatterns("/index", "/");
        registry.addInterceptor(new AuthInterceptor());
    }
}