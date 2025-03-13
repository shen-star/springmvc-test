package com.shen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "success";
    }

    /**
     * -@RequestMapping的params属性
     * "param"：要求请求映射所匹配的请求必须携带param请求参数
     * "!param"：要求请求映射所匹配的请求必须不能携带param请求参数
     * "param=value"：要求请求映射所匹配的请求必须携带param请求参数且param=value
     * "param!=value"：要求请求映射所匹配的请求必须携带param请求参数但是param!=value
     */
    @RequestMapping(value = {"/testParams"}, method = {RequestMethod.GET, RequestMethod.POST}, params = {"username", "password!=123456"})
    public String testParams() {
        return "success";
    }

    @RequestMapping(value = {"/testHeaders"}, method = {RequestMethod.GET, RequestMethod.POST}, headers = {"Host=localhost:8080"})
    public String testHeaders() {
        return "success";
    }

    /**
     * springMVC支持ant风格
     * ？：表示任意的单个字符
     * *：表示任意的0个或多个字符
     */
    // /*/: 表示任意一层目录
    // /*/*/: 表示任意两层目录
//    @RequestMapping("/test/a?a/ant")
//    @RequestMapping("/test/a*a/ant")
    @RequestMapping("/test/*/ant")
    public String testAnt() {
        return "success";
    }


    /**
     * SpringMVC路径中的占位符常用于RESTful风格中，当请求路径中将某些数据通过路径的方式传输到服务器中，
     * 就可以在相应的@RequestMapping注解的value属性中通过占位符{xxx}表示传输的数据，在通过@PathVariable注解，
     * 将占位符所表示的数据赋值给控制器方法的形参
     */
    @RequestMapping("/test/rest/{id}/{name}")
    public String testRest(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        System.out.println("id:" + id + ",name:" + name);
        return "success";
    }


}
