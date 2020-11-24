package com.dog.it.filter;
import com.dog.it.until.RequestResponse;
import com.dog.it.until.RequestResponseBuilder;
import com.dog.it.until.RequestResponseCode;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component("authAccessDeniedHandler")
public class AuthAccessDeniedHandler implements AccessDeniedHandler {
    @Autowired
    private Gson gson;
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception)
            throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setCharacterEncoding("utf-8");
        log.info("鉴权失败");
        RequestResponse<String> result = new RequestResponse<String>();
        result = RequestResponseBuilder.error(exception.getMessage(), RequestResponseCode.ERROR,exception.getClass().getName());
        response.getWriter().write(gson.toJson(result));
    }

}
