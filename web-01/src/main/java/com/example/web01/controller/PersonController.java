package com.example.web01.controller;

import com.example.web01.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {


    @RequestMapping(value = "/saveuser",method = RequestMethod.POST)
    @ResponseBody
    public Person save(Person person){
//        @RequestBody String content
        /**
         * 使用 @RequestBody不能作用对象 只能作用String或者其他
         */
        return person;
    }
}
