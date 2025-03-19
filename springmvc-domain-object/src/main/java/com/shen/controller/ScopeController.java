package com.shen.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/scope")
public class ScopeController {

    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest httpServletRequest) {
        httpServletRequest.setAttribute("testRequestScope", "this is test scope by Servlet API");
        return "success";
    }
}
