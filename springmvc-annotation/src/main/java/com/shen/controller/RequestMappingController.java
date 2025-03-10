package com.shen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("hello")
public class RequestMappingController {
    @RequestMapping("/testRequestMapping")
    public String success() {
        return "success";
    }

    @RequestMapping(value = {"/testValue1", "/testValue2"})
    public String testDifferValue() {
        return "testvalue";
    }

    @RequestMapping(value = {"/testMethod"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String testMethod() {
        return "testmethod";
    }

}
