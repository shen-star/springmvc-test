package com.shen.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/scope")
public class ScopeController {

    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest httpServletRequest) {
        httpServletRequest.setAttribute("testRequestScope", "this is test scope by Servlet API");
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        //ModelAndView有Model和View的功能
        //Model主要用于向请求域共享数据
        //View主要用于设置视图，页面跳转
        ModelAndView mav = new ModelAndView();
        //处理模型数据，即向请求域request共享数据
        mav.addObject("testModelAndView", "this is test scope by ModelAndView");
        mav.setViewName("success");
        return mav;
    }
}
