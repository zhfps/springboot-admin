package com.dog.it.filter;
import com.dog.it.until.RequestResponse;
import com.dog.it.until.RequestResponseBuilder;
import com.dog.it.until.RequestResponseCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("authFailureHandler")
@Slf4j
public class AuthFailureHandler implements AuthenticationEntryPoint {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.info("鉴权失败");
        RequestResponse<String> result = new RequestResponse<String>();
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            if(exception instanceof LockedException){
                result = RequestResponseBuilder.error("账户被锁定，登录失败!", RequestResponseCode.ERROR,exception.getClass().getName());
            }else if(exception instanceof BadCredentialsException){

                result = RequestResponseBuilder.error("账户名或密码输入错误，登录失败!", RequestResponseCode.ERROR,exception.getClass().getName());
            }else if(exception instanceof DisabledException){

                result = RequestResponseBuilder.error("账户被禁用，登录失败", RequestResponseCode.ERROR,exception.getClass().getName());
            }else if(exception instanceof AccountExpiredException){

                result = RequestResponseBuilder.error("账户已过期，登录失败!", RequestResponseCode.ERROR,exception.getClass().getName());
            }else if(exception instanceof CredentialsExpiredException){

                result = RequestResponseBuilder.error("密码已过期，登录失败!", RequestResponseCode.ERROR,exception.getClass().getName());
            }else if(exception instanceof InsufficientAuthenticationException){

                result = RequestResponseBuilder.error("未登录", RequestResponseCode.ERROR,exception.getClass().getName());
            }else{
                result = RequestResponseBuilder.error(exception.getMessage(), RequestResponseCode.ERROR,exception.getClass().getName());;
            }
            response.getWriter().write(objectMapper.writeValueAsString(result));

    }
}
