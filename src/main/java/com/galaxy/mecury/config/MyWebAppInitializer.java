package com.galaxy.mecury.config;

import ch.qos.logback.ext.spring.web.LogbackConfigListener;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //加载容器
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }
    //加载webapp容器
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { AppConfig.class };
    }
    //设置DispatcherServlet的拦截规则  / 代表拦截所有但是不包括jsp
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);

        servletContext.setInitParameter("logbackConfigLocation", "classpath:logback.xml");
        servletContext.addListener(LogbackConfigListener.class);
    }
}