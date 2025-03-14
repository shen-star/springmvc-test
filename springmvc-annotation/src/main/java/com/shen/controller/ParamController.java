package com.shen.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username : " + username + ",password : " + password);
        return "success";
    }

    @RequestMapping("/testParam")
    public String testServletAPI(String username, String password) {
        System.out.println("username : " + username + ",password : " + password);
        return "success";
    }

    /**
     * 若请求所传输的请求参数中有多个同名的请求参数，此时可以在控制器方法的形参中设置字符串数组或者字符串类型的形参接收此请求参数
     * 若使用字符串数组类型的形参，此参数的数组中包含了每一个数据
     * 若使用字符串类型的形参，此参数的值为每个数据中间使用逗号拼接的结果
     */
    @RequestMapping("/testParam2")
    public String testServletAPI(String username, String password, String[] hobby) {
        System.out.println("username : " + username + ",password : " + password + ",hobby : " + Arrays.toString(hobby));
        return "success";
    }
}
