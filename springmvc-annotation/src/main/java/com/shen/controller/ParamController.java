package com.shen.controller;

import com.shen.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    /**
     * @RequestParam是将请求参数和控制器方法的形参创建映射关系 该注解的属性有四个
     * value|name :为指定为形参赋值的请求参数的参数名，name属性与value属性的含义相同，更推荐使用name属性，因为更符合语义
     * required: 设置是否必须传输此请求参数，默认为true
     * defaultValue: 不管required属性值为true或false，当指定的请求参数咩有传输或传输为空字符串时，则使用默认值为形参赋值
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "user_name") String username, @RequestParam(name = "pass_word", required = false, defaultValue = "123456") String password) {
        System.out.println("username : " + username + ",password : " + password);
        return "success";
    }

    /**
     * @RequestHeader是将请求头信息和控制器方法的形参创建映射关系，该注解与@RequestParam注解类似同样有四个属性 。
     * value|name :为指定为形参赋值的请求参数的参数名，name属性与value属性的含义相同，更推荐使用name属性，因为更符合语义
     * required: 设置是否必须传输此请求参数，默认为true
     * defaultValue: 不管required属性值为true或false，当指定的请求参数咩有传输或传输为空字符串时，则使用默认值为形参赋值
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(name = "Host") String host, @RequestHeader(name = "test_value", required = true, defaultValue = "test") String testValue) {
        System.out.println("host: " + host + ", test_value:" + testValue);
        return "success";
    }

    /**
     * @CookieValue是将cookie数据和控制器方法的形参创建映射关系,该注解与@RequestParam注解类似同样有四个属性 。
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(name = "test", required = false, defaultValue = "123456") String test) {
        System.out.println("cookie: " + test);
        return "success";
    }

    /**
     * 当请求参数名与一个实体类中属性名相同时，可以使用一个POJO(简单java对象)，即一个实体类来获取所有的请求参数
     */
    @RequestMapping("/testpojo")
    public String testpojo(User user) {
        System.out.println(user);
        return "success";
    }
}
