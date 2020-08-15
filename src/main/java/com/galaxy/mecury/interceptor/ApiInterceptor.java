package com.galaxy.mecury.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galaxy.mecury.common.Jwt;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApiInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization=request.getHeader("Authorization");
        if(authorization == null || ! authorization.startsWith("Bearer ")){
            this.setErrorResponse(response,"未携带token");
            return false;
        }
        String token=authorization.substring(7);
        try {
            request.setAttribute("user", Jwt.parseJwt(token));
        }catch(Exception e) {
            this.setErrorResponse(response,e.getMessage());
            return  false;
        }
        return  true;
    }
    protected void setErrorResponse(HttpServletResponse response, String message) throws IOException {
        response.setHeader("Content-type", "application/json; charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        ResponseData responseData = new ResponseData();
        responseData.code = 400;
        responseData.message = "not login";
        response.getWriter().write(mapper.writeValueAsString(responseData));
        response.getWriter().flush();
        response.getWriter().close();
    }

    static class ResponseData {
        int code;
        String message;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
