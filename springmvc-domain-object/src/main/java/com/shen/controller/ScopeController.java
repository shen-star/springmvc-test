package com.shen.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


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

    @RequestMapping("/testModel")
    public String testModel(Model model) {
        model.addAttribute("testModel", "this is test scope by Model");
        System.out.println(model.getClass().getName());
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        map.put("testMap", "this is test scope by Map");
        System.out.println(map.getClass().getName());
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("testModelMap", "this is test scope by ModelMap");
        System.out.println(modelMap.getClass().getName());
        //打断点会观察到DispatcherServlet类在执行ha.handle(processedRequest, response, mappedHandler.getHandler());方法后会返回ModelAndView
        //即每一个请求在结束都会返回ModelAndView，Model中是域对象中的数据，view是返回的页面
        return "success";
    }

    @RequestMapping("/testSessionByServletAPI")
    public String testSessionByServletAPI(HttpSession httpSession) {
        httpSession.setAttribute("testSessionScope","this is test session scope by Servlet API");
        return "success";
    }
}
