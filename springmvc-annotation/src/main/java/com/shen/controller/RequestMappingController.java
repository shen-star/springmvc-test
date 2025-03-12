package com.shen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    /**
     * -@RequestMapping的派生注解
     * 处理get请求的映射-->@GetMapping
     * 处理post请求的映射-->@PostMapping
     * 处理put请求的映射-->@PutMapping
     * 处理delete请求的映射-->@DeleteMapping
     */
    @GetMapping(value = {"/testGetMapping"})
    public String testGetMappingIndex() {
        return success();
    }

}
