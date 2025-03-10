package com.shen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
