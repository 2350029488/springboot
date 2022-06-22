package com.example.hellospringbootautoconfigruationtest.controller;

import com.example.hello.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

 @Autowired
    BookService bookService;

 @GetMapping("/book")
 public String book(){
     return bookService.book("红楼梦");
 }
}
