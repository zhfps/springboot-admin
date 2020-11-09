package com.dog.it.controller;

import com.dog.it.service.TestService;
import com.dog.it.until.RequestResponse;
import com.dog.it.until.RequestResponseBuilder;
import com.dog.it.until.RequestResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller()
public class TestController {

    @Autowired
    TestService testService;

    @ResponseBody
    @RequestMapping(value ="/test",method = RequestMethod.GET)
    public String Test(){
        return testService.test();
    }
}
