package com.example.profile.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试配置加载的优先级
 */
@RestController
public class Hello2Controller {
    /*测试取出系统环境变量的值*/
    @Value("${MAVEN_HOME}")/*value不仅可以取配置中的，还可以取系统中的*/
    private String msg;

    /*测试操作系统的名字*/
    @Value("${os.name}")
    private String name;

    @GetMapping("/msg")
    private String getMsg(){
        return msg;//D:\Maven\apache-maven-3.8.4
    }
    @GetMapping("/name")
    private String getName(){
        return name;//Windows 10
    }
}
