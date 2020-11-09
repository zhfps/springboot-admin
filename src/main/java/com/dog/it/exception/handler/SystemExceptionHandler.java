package com.dog.it.exception.handler;

import com.dog.it.until.RequestResponse;
import com.dog.it.until.RequestResponseBuilder;
import com.dog.it.until.RequestResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.ServletException;
@ControllerAdvice
@ResponseBody
@Slf4j
public class SystemExceptionHandler {

    @ExceptionHandler(value = { ServletException.class })
    @ResponseBody
    public RequestResponse<String> handlerServletException(ServletException e){
        log.error(e.getMessage());
        RequestResponse<String> result= RequestResponseBuilder.error(e.getMessage(), RequestResponseCode.NO_MAPPING);
        return result;
    }

    @ExceptionHandler(value = { Exception.class })
    @ResponseBody
    public RequestResponse<String> handlerException(Exception e){
        log.error(e.getMessage());
        RequestResponse<String> result= RequestResponseBuilder.error(e.getMessage(), RequestResponseCode.ERROR);
        return result;
    }
}
