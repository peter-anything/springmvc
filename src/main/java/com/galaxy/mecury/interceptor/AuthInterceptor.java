package com.galaxy.mecury.interceptor;

import com.galaxy.mecury.annotation.Auth;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            Auth auth = ((HandlerMethod) handler).getMethodAnnotation(Auth.class);
            System.out.println("Test");
        }
        return super.preHandle(request, response, handler);
    }
}
