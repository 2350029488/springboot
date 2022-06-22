package com.example.web01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {
    /**
     * 测试@RequestAttribute
     *
     *  模拟页面跳转
     */
    @ResponseBody
    @RequestMapping("/success")
    public Map metod2(/* 通过@RequestAttribute获取请求域中的参数*/
                       @RequestAttribute(value = "msg1",required = false)String msg1,
                      @RequestAttribute(value = "code",required = false)Integer code,
                      /* 或者直接获取*/
                      HttpServletRequest request){

        Object code1 = request.getAttribute("code");


        Map<String,Object> map=new HashMap<>();
        map.put("msg1",msg1);
        map.put("code",code);
        map.put("request",code1);

        return map;


    }


    @RequestMapping("/goto")
    public String method1(HttpServletRequest request){
        request.setAttribute("msg1","成功");
        request.setAttribute("code",100);
        return "forward:/success";
    }

    @GetMapping("/params")
    public String testParams(
               Map<String,Object> maps,
               Model model,
               HttpServletRequest request,
               HttpServletResponse response){
        maps.put("world","hello");
        model.addAttribute("model","llllll");
        request.setAttribute("request","ssssssssss");
        Cookie cookie = new Cookie("c1", "v1");
//        cookie.setDomain("localhost");
        response.addCookie(cookie);
        return "forward:/success2";
    }
    @ResponseBody
    @RequestMapping("/success2")
    public Map mehtodss(HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        Object model = request.getAttribute("model");
        Object request1 = request.getAttribute("request");
        Object map1 = request.getAttribute("world");
        Object c1 = request.getAttribute("c1");
        map.put("c1",c1);
        map.put("model",model);
        map.put("request2",request1);
        map.put("map1",map1);
        return map;
    }


}
