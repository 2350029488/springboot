package com.example.profile.controller;

import com.example.profile.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试环境变量的切换
 */
@RestController
public class HelloController {
    @Value("${person.name:李四}")//如果配置文件没有配置则默认为李四
    private String name;

    @Autowired
    private Person person;


    @GetMapping("/")
    public Person hello(){
        return person;
    }

//        @GetMapping("/")
//    public Person hello(){
//        return person;
//    }


    //    @GetMapping("/")
//    public String hello(){
//        return "hello"+name;
//    }
}
