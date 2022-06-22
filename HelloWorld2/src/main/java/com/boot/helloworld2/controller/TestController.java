package com.boot.helloworld2.controller;

import com.boot.helloworld2.pojo.Animal;
import com.boot.helloworld2.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    Person person;

    @Autowired
    Animal animal;

    @RequestMapping("/test")
    public String method(){
        return "你好";
    }

    @RequestMapping("/person")
    public Person method2(){
        return person;
    }

    @RequestMapping("/animal")
    public Animal method3(){
        return animal;
    }


}
