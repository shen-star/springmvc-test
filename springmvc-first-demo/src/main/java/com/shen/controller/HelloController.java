package com.shen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String index() {
        //返回视图名称(前缀和后缀已在web.xml中配置了)
        return "index";
    }

    @RequestMapping("/target")
    public String target() {
        return "target";
    }
}
