package com.example.web01.controller;

import com.example.web01.pojo.Person;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ResponseTestController {

    @GetMapping("/test/person")
    public Person getPerson(){
        Person person=new Person();
        person.setAge(18);
        person.setBirth(new Date());
        return person;
    }

    /**
     * 文件返回
     */
    @ResponseBody
    @RequestMapping("/hell")
    public FileSystemResource file(){
        return null;
    }
}
