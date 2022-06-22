package com.springboot.boot.controller;

import com.springboot.boot.pojo.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody

/**写在类上 表示这个类的所有请求都是直接响应到浏览器上*/
//@Controller
    @Slf4j//日志
@RestController /** 这个等于上面两个的合体 ctrl+B可以看到*/
public class HelloController {

//    @ResponseBody 写在类上了
    @RequestMapping("/hello")
    public String hello01(@RequestParam("name")String name){
        log.info("请求来了");
        return "hello springboot 你好"+name;
    }




//   测试注解 @ConfigurationProperties(prefix = "mycar")
    @Autowired
    Car car;
    @RequestMapping("/car")
    public Car method(){
        return car;
    }

}
