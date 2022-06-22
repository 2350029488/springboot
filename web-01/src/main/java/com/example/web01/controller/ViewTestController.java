package com.example.web01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {
    @GetMapping("/viewtest")
    public String viewTest(Model model){
        model.addAttribute("msg","thymelarf跳转页面");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }
}
