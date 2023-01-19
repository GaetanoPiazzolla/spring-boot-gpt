package com.chatgpt.interceptor;

import com.chatgpt.exception.UnauthorizedException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*String authorization = request.getHeader("Authorization");
        if(authorization == null || !authorization.equals("human")) {
            throw new UnauthorizedException("Unauthorized access");
        }*/
        return true;
    }
}