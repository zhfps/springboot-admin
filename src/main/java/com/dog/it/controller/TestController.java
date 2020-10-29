package com.dog.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller(value = "/")
public class TestController {
    @ResponseBody
    @RequestMapping(value ="test",method = RequestMethod.GET)
    public String Test(){
        return "hello word";
    }
}
