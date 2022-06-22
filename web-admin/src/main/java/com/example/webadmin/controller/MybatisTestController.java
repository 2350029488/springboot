package com.example.webadmin.controller;

import com.example.webadmin.pojo.Book;
import com.example.webadmin.pojo.Dept;
import com.example.webadmin.serveice.BookService;
import com.example.webadmin.serveice.DeptServeice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class MybatisTestController {

    @Autowired
    BookService bookService;

    @Autowired
    DeptServeice deptServeice;

    @GetMapping("/getbook")
    @ResponseBody
    public Book geybook(@RequestParam("id")Integer id){
        Book byId = bookService.getById(id);
        return byId;
    }

    @GetMapping("/getdept")
    @ResponseBody
    public Dept getdept(@RequestParam("id")Integer id){
        Dept dept = deptServeice.selectById(id);
        return dept;
    }

    @GetMapping("/getdeptAll")
    @ResponseBody
    public  List<Dept> getdeptAll(){
        List<Dept> depts = deptServeice.selectAll();
        return depts;
    }
}
