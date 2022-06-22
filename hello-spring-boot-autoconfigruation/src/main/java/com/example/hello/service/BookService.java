package com.example.hello.service;

import com.example.hello.bean.BookProperties;
import org.springframework.beans.factory.annotation.Autowired;

public class BookService {

    @Autowired
    BookProperties bookProperties;

    public String book(String username){
        return bookProperties.getPrefix()+username+bookProperties.getSuffix();
    }
}
